package me.geik.essas.voidtospawn;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiItems;
import me.geik.essas.gui.AdminGuiReturn;

public class VoidAllowedWorlds {
	
	
	static HashMap<String, String> confirmation = new HashMap<String, String>();
	public static HashMap<String, Integer> data = new HashMap<String, Integer>();
	
	public static void secondMenu(InventoryClickEvent e, Player p) {
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&dVoidAllowedWorlds"))) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
				int clicked = e.getSlot();
				int listSira = clicked-9;
				if (listSira >= 0) {
					if(e.getSlot() == clicked && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
							paylasim.cfg.getStringList("voidToSpawn.allowedWorlds").get(listSira)))){
						if (confirmation.containsKey(p.getName()) && confirmation.containsValue(paylasim.cfg.getStringList("voidToSpawn.allowedWorlds").get(listSira))) {
							confirmation.remove(p.getName(), paylasim.cfg.getStringList("voidToSpawn.allowedWorlds").get(listSira));
							List<String> worldName = paylasim.cfg.getStringList("voidToSpawn.allowedWorlds");
							worldName.remove(paylasim.cfg.getStringList("voidToSpawn.allowedWorlds").get(listSira));
							paylasim.cfg.set("voidToSpawn.allowedWorlds", worldName);
							try {paylasim.cfg.save(paylasim.c);} catch (IOException e1) {e1.printStackTrace();}
							Main.instance.reloadConfig();
							worldMenuItemsVoid(p);
							paylasim.voidWorldREmoved(p);
							
						}else {
						confirmation.put(p.getName(), paylasim.cfg.getStringList("voidToSpawn.allowedWorlds").get(listSira));
						paylasim.confirmationDel(p);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
								public void run() {
									if (confirmation.containsKey(p.getName())) {
										confirmation.remove(p.getName());
										paylasim.confirmExpire(p);}}},200);}
						
					}
				} else {
					if(e.getSlot() == clicked && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
							paylasim.gui.getString("Others.addMoreData.itemName")))){
						if (!data.containsKey(p.getName())) {
							data.put(p.getName(), 1);
							p.closeInventory();
							paylasim.cancelEntry(p);
							
						}
						else {
							data.remove(p.getName());}}
					if (e.getSlot() == 0) {
						AdminGuiReturn.voidtoSpawnMenuRe(p);
					}
				}
				
						
		}
	}
	public static void worldMenuItemsVoid(Player p) {
		Inventory worlds = Bukkit.getServer().createInventory(p, 27, (paylasim.color("&dVoidAllowedWorlds")));
		
		worlds.setItem(0, AdminGuiItems.esya("Others", "goBack", Material.IRON_DOOR));
		worlds.setItem(8, AdminGuiItems.esya("Others", "addMoreData", Material.TORCH));
		
		
		List<String> list = paylasim.cfg.getStringList("voidToSpawn.allowedWorlds");
		String[] array = list.toArray(new String[list.size()]);
		for (int i = 0 ; i <= 17 ; i++) {
			if (array.length <= 17) {
				if (array.length == i) {
					p.openInventory(worlds);
					break;
				}
				else worlds.setItem(i+9, AdminGuiItems.Allowedworlds("Others.worldList", i, "voidToSpawn.allowedWorlds"));
			}
			else break;
			
		}
	}
	
	public static void chatEventData(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		List<String> worldName = paylasim.cfg.getStringList("voidToSpawn.allowedWorlds");
		String world = e.getMessage();
		if (data.containsKey(p.getName())) {
			e.setCancelled(true);
			if (e.getMessage().equalsIgnoreCase(paylasim.cfg.getString("cancelMethod"))){
				data.remove(p.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					public void run() {
						worldMenuItemsVoid(p);
					}
				}, 1);
			}else {
				worldName.add(world);
				paylasim.cfg.set("voidToSpawn.allowedWorlds", worldName);
				try {paylasim.cfg.save(paylasim.c);} catch (IOException e1) {e1.printStackTrace();}
				Main.instance.reloadConfig();
				data.remove(p.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					public void run() {
						worldMenuItemsVoid(p);
					}
				}, 1);
				
			}
			}
		else {
		}
	}


}
