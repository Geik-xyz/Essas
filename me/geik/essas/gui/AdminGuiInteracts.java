package me.geik.essas.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import me.geik.essas.acik.paylasim;

public class AdminGuiInteracts {
	
	
	public static void voidToSpawn(InventoryClickEvent e, Player player) {
		if(e.getSlot() == 1 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase
				(paylasim.color(paylasim.gui.getString("AdminPanel.voidtospawn.itemName").replace("&", "§"))))){
			if (player.hasPermission("essas.admin.gui")) {
				AdminGuiReturn.voidtoSpawnMenuRe(player);
				
			} else {player.closeInventory(); paylasim.noPerm(player);}}}
	
	
	public static void autoEvent(InventoryClickEvent e, Player player) {
		if(e.getSlot() == 22 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase
				(paylasim.color(paylasim.gui.getString("AdminPanel.autoEvent.itemName").replace("&", "§"))))){
			if (player.hasPermission("essas.admin.gui")) {
				AdminGuiReturn.AEMenuRE(player);
				
			} else {player.closeInventory(); paylasim.noPerm(player);}}}
	
	public static void chatEvent(InventoryClickEvent e, Player player) {
		if(e.getSlot() == 7 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase
				(paylasim.color(paylasim.gui.getString("AdminPanel.chatEvent.itemName").replace("&", "§"))))){
			if (player.hasPermission("essas.admin.gui")) {
				AdminGuiReturn.ChatEventMainRE(player);
				
			} else {player.closeInventory(); paylasim.noPerm(player);}}}
	public static void pkit(InventoryClickEvent e, Player player) {
		if(e.getSlot() == 19 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase
				(paylasim.color(paylasim.gui.getString("AdminPanel.permantKit.itemName").replace("&", "§"))))){
			if (player.hasPermission("essas.admin.gui")) {
				AdminGuiReturn.pKitReturnsMain(player);
				
			} else {player.closeInventory(); paylasim.noPerm(player);}}}
	public static void metin(InventoryClickEvent e, Player player) {
		if(e.getSlot() == 4 && (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase
				(paylasim.color(paylasim.gui.getString("AdminPanel.metinstone.itemName").replace("&", "§"))))){
			if (player.hasPermission("essas.admin.gui")) {
				AdminGuiReturn.metinMainRE(player);
			}
		}
	}

}
