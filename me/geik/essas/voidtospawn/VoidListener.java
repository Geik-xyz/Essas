package me.geik.essas.voidtospawn;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class VoidListener implements Listener{
	
	private Main plugin;
	  
	  public VoidListener(Main plugin){
		    this.plugin = plugin;}
	  
	  HashMap<String, Integer> voidPrevent = new HashMap<String, Integer>();
	

	@EventHandler
	public void onFallEvent(PlayerMoveEvent e) {
		// Files
	  	File spawn = new File("plugins/Essas/locations/voidspawn.yml");
	  	FileConfiguration loc = YamlConfiguration.loadConfiguration(spawn);
	  	//
		if (plugin.getConfig().getBoolean("voidToSpawn.teleportSpawn") == true) {
			if (loc.get("Location.x") != null && loc.get("Location.y") != null && loc.get("Location.z") != null) {
				List<String> worldlist = paylasim.cfg.getStringList("voidToSpawn.allowedWorlds");
				// player loc
				Player player = e.getPlayer();
				String playerworl = e.getPlayer().getLocation().getWorld().getName();
				// Spawn Loc
				double x = loc.getDouble("Location.x");
				double y = loc.getDouble("Location.y");
				double z = loc.getDouble("Location.z");
				float yaw = (float) loc.getDouble("Location.yaw");
				float pitch = (float) loc.getDouble("Location.pitch");
				String string = loc.getString("Location.world");
				World world = Bukkit.getServer().getWorld(string);
				Location locx = new Location(world, x, y, z);
				//
				if(e.getPlayer().getLocation().getY() <= -60){
					if (worldlist.contains(playerworl.toString())) {
						locx.setYaw(yaw);
						player.getLocation().setPitch(pitch);
						player.teleport(locx);
						player.sendMessage(paylasim.color(paylasim.fc.getString("Plugin.Prefix") + " " + paylasim.fc.getString("VoidtoSpawn.teleported")));
						voidPrevent.put(player.getName(), 1);
					}
				}
			}	
		}
	}
	
	
	@EventHandler
	public void onFallDamage(EntityDamageEvent event){
		if(this.plugin.getConfig().getBoolean("voidToSpawn.teleportSpawn") == true){
			if(event.getEntity() instanceof Player && event.getCause() == DamageCause.FALL){
				Player player = (Player) event.getEntity();
					if (voidPrevent.containsKey(player.getName())) {
						event.setCancelled(true);
						voidPrevent.remove(player.getName());
					}}}}
	
	@EventHandler
	public void envanterdeTiklayinca(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		VoidMainGui.firstMenu(e, p);
		VoidAllowedWorlds.secondMenu(e, p);
		  
	}
	@EventHandler
	public void chatListen(AsyncPlayerChatEvent e) {
		VoidAllowedWorlds.chatEventData(e);
	}

}
