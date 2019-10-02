package me.geik.essas.metintasi;

import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiReturn;
import me.geik.essas.permantKit.adakitGuiCMDS;

public class metinSpawnMobEveryGuiListener {
	
	
	public static void spawnMobEveryGui(InventoryClickEvent e) throws IOException {
		Player player = (Player) e.getWhoClicked();
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&dMetinStone-SpawnMob"))) {
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
			e.setCancelled(true);
			if (e.getSlot() == 4) {
				toggler(player, "enable");}
			else if (e.getSlot() == 1) {
				toggler(player, "zombie");
			}
			else if (e.getSlot() == 7) {
				toggler(player, "skeleton");
			}
			else if (e.getSlot() == 12) {
				if (metinGuiListener.playerEdit.containsKey(player.getName())) {
					metinGuiListener.playerEdit.remove(player.getName());
					metinGuiListener.playerEdit.put(player.getName(), "zombie-count");
					player.closeInventory();
				}else {
					metinGuiListener.playerEdit.put(player.getName(), "zombie-count");
					player.closeInventory();}
			}
			else if (e.getSlot() == 14) {
				if (metinGuiListener.playerEdit.containsKey(player.getName())) {
					metinGuiListener.playerEdit.remove(player.getName());
					metinGuiListener.playerEdit.put(player.getName(), "skeleton-count");
					player.closeInventory();
				}else {
					metinGuiListener.playerEdit.put(player.getName(), "skeleton-count");
					player.closeInventory();}
			}
			
		}
	}
	
	public static void toggler(Player player, String configuration) throws IOException {
		if (paylasim.cfg.getBoolean("metin.spawn-mob-every-health." + configuration) == true) {
			paylasim.cfg.set("metin.spawn-mob-every-health." + configuration, false);
			paylasim.cfg.save(paylasim.c);
			Main.instance.reloadConfig();
			player.closeInventory();
			metinListener.metintask.cancel();
			AdminGuiReturn.spawnMobEveryHP(player);
			paylasim.debugSomethng("&cMetinStone " + configuration + " has cancelled by &b" + player.getName());
		}
		else {
			metinListener.metincd2();
			paylasim.cfg.set("metin.spawn-mob-every-health." + configuration, true);
			paylasim.cfg.save(paylasim.c);
			Main.instance.reloadConfig();
			player.closeInventory();
			AdminGuiReturn.spawnMobEveryHP(player);
			paylasim.debugSomethng("&aMetinStone " + configuration + " has resumed by &b" + player.getName());}
	}
	public static void metinGuiMain(InventoryClickEvent e, Player player) throws IOException {
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&dMetinStone"))) {
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
			e.setCancelled(true);
			if (e.getSlot() == 43) {
				player.sendMessage(paylasim.color("&b&lDISCORD&3 Geik#1211"));
			}
			else if (e.getSlot() == 4) {
				if (paylasim.cfg.getBoolean("metin.event") == true) {
					paylasim.cfg.set("metin.event", false);
					paylasim.cfg.save(paylasim.c);
					Main.instance.reloadConfig();
					player.closeInventory();
					metinListener.metintask.cancel();
					AdminGuiReturn.metinMainRE(player);
					paylasim.debugSomethng("&cMetinStone has cancelled by &b" + player.getName());
				}
				else {
					metinListener.metincd2();
					paylasim.cfg.set("metin.event", true);
					paylasim.cfg.save(paylasim.c);
					Main.instance.reloadConfig();
					player.closeInventory();
					AdminGuiReturn.metinMainRE(player);
					paylasim.debugSomethng("&aMetinStone has resumed by &b" + player.getName());
				}}
			else if (e.getSlot() == 25) {
				if (paylasim.cfg.getBoolean("metin.respawned-again-broadcast") == true) {
					paylasim.cfg.set("metin.respawned-again-broadcast", false);
					paylasim.cfg.save(paylasim.c);
					Main.instance.reloadConfig();
					player.closeInventory();
					{metinListener.metintask.cancel(); metinListener.metincd2();}
					AdminGuiReturn.metinMainRE(player);
					paylasim.debugSomethng("&cMetin announce has cancelled by &b" + player.getName());
				} else {
					paylasim.cfg.set("metin.respawned-again-broadcast", true);
					paylasim.cfg.save(paylasim.c);
					Main.instance.reloadConfig();
					player.closeInventory();
					{metinListener.metintask.cancel(); metinListener.metincd2();}
					AdminGuiReturn.metinMainRE(player);
					paylasim.debugSomethng("&aMetin announce has resumed by &b" + player.getName());
				}}
			else if (e.getSlot() == 1) {
				adakitGuiCMDS.cmdListMenu(player, "metin.top-breaking-reward", "&dMetin-TopBreaking Reward");
			}
			else if (e.getSlot() == 7) {
				if (metinGuiListener.playerEdit.containsKey(player.getName())) {
					metinGuiListener.playerEdit.remove(player.getName());
					metinGuiListener.playerEdit.put(player.getName(), "health");
					player.closeInventory();
				}else {
					metinGuiListener.playerEdit.put(player.getName(), "health");
					player.closeInventory();}
			}
			else if (e.getSlot() == 19) {
				if (metinGuiListener.playerEdit.containsKey(player.getName())) {
					metinGuiListener.playerEdit.remove(player.getName());
					metinGuiListener.playerEdit.put(player.getName(), "respawn-cooldown");
					player.closeInventory();
				}else {
					metinGuiListener.playerEdit.put(player.getName(), "respawn-cooldown");
					player.closeInventory();}
			}
			else if (e.getSlot() == 22) {
				if (metinGuiListener.playerEdit.containsKey(player.getName())) {
					metinGuiListener.playerEdit.remove(player.getName());
					metinGuiListener.playerEdit.put(player.getName(), "metin-material");
					player.closeInventory();
				}else {
					metinGuiListener.playerEdit.put(player.getName(), "metin-material");
					player.closeInventory();}
			}
			else if (e.getSlot() == 37) {
				AdminGuiReturn.spawnMobEveryHP(player);
			}
			else if (e.getSlot() == 40) {
				AdminGuiReturn.healthEvents(player);
			}
			
		}
	}

}
