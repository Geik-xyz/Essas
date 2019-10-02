package me.geik.essas.voidtospawn;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiReturn;

public class VoidMainGui {
	
	
	public static void firstMenu(InventoryClickEvent e, Player p) {
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&dVoidTheGui"))) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
				if(e.getSlot() == 7 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
						paylasim.gui.getString("VoidToSpawn.setVoidSpawn.itemName")))){
						Bukkit.dispatchCommand(p, "voidtospawn");
						p.closeInventory();
				}
				else if (e.getSlot() == 1 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
						paylasim.gui.getString("VoidToSpawn.toggleFeature.itemName").replace("%cur%", current("voidToSpawn", "teleportSpawn"))))){
						if (paylasim.cfg.getBoolean("voidToSpawn.teleportSpawn") == true) {
							paylasim.cfg.set("voidToSpawn.teleportSpawn", false);
							try {paylasim.cfg.save(paylasim.c);} catch (IOException e1) {e1.printStackTrace();}
							Main.instance.reloadConfig();
							p.closeInventory();
							AdminGuiReturn.voidtoSpawnMenuRe(p);
							}
						else {
							paylasim.cfg.set("voidToSpawn.teleportSpawn", true);
							try {paylasim.cfg.save(paylasim.c);} catch (IOException e1) {e1.printStackTrace();}
							Main.instance.reloadConfig();
							p.closeInventory();
							AdminGuiReturn.voidtoSpawnMenuRe(p);
						}
				}
				else if (e.getSlot() == 4 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
						paylasim.gui.getString("VoidToSpawn.allowedWorlds.itemName")))) {
					VoidAllowedWorlds.worldMenuItemsVoid(p);
				}
			
		}
	}
	public static String current(String gm, String dp) {
		String enabled = paylasim.fc.getString(paylasim.color("Plugin.enabled"));
		String disabled = paylasim.fc.getString(paylasim.color("Plugin.disabled"));
		if (paylasim.cfg.getBoolean(gm + "." + dp) == true) {
			return enabled;}
		else {return disabled;}
	}

}
