package me.geik.essas.autoevent;

import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiReturn;

public class AEGuiMain {
	
	static HashMap<String, Integer> playerEditAE = new HashMap<String, Integer>();
	static HashMap<String, String> playerEditMenu = new HashMap<String, String>();
	static String menu = null;
	
	public static void AEMain(InventoryClickEvent e, Player p) {
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&bAuto Event Gui"))) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
			if(e.getSlot() == 1 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
					paylasim.gui.getString("AutoEventGui.events.itemName").replace("%id%", "first")))){
				AdminGuiReturn.AEEventsRE(p, "first");
				menu = "first";
			}
			else if(e.getSlot() == 4 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
					paylasim.gui.getString("AutoEventGui.events.itemName").replace("%id%", "second")))){
				AdminGuiReturn.AEEventsRE(p, "second");
				menu = "second";
				
			}
			else if(e.getSlot() == 7 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
					paylasim.gui.getString("AutoEventGui.events.itemName").replace("%id%", "third")))){
				AdminGuiReturn.AEEventsRE(p, "third");
				menu = "third";
				
			}
			else if (e.getSlot() == 22) {
				if (paylasim.cfg.getBoolean("autoEvent.events") == true) {
					paylasim.cfg.set("autoEvent.events", false);
					try {paylasim.cfg.save(paylasim.c);} catch (IOException e1) {e1.printStackTrace();}
					Main.instance.reloadConfig();
					p.closeInventory();
					AEListener.taskid.cancel();
					AdminGuiReturn.AEMenuRE(p);
					paylasim.debugSomethng("&cAuto Event has cancelled by &b" + p.getName());
				}
				else {
					AEListener.taskAgain();
					paylasim.cfg.set("autoEvent.events", true);
					try {paylasim.cfg.save(paylasim.c);} catch (IOException e1) {e1.printStackTrace();}
					Main.instance.reloadConfig();
					p.closeInventory();
					AdminGuiReturn.AEMenuRE(p);
					paylasim.debugSomethng("&aAuto event has resumed by &b" + p.getName());
			}
			
		 }
		}
		else if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&cAuto Event "+menu))) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
			if(e.getSlot() == 0 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
					paylasim.gui.getString("AutoEventGui.eventEditCMD.itemName")))){
				if (playerEditAE.containsKey(p.getName())) {
					playerEditAE.remove(p.getName());
					playerEditAE.put(p.getName(), 1);
					playerEditMenu.put(p.getName(), menu);
					p.closeInventory();
					paylasim.cancelEntry(p);}
				else {
					playerEditAE.put(p.getName(), 1);
					playerEditMenu.put(p.getName(), menu);
					p.closeInventory();
					paylasim.cancelEntry(p);}
			}
			else if(e.getSlot() == 1 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
					paylasim.gui.getString("AutoEventGui.eventEditCMD.itemName")))){
				if (playerEditAE.containsKey(p.getName())) {
					playerEditAE.remove(p.getName());
					playerEditAE.put(p.getName(), 2);
					playerEditMenu.put(p.getName(), menu);
					p.closeInventory();
					paylasim.cancelEntry(p);}
				else {
					playerEditAE.put(p.getName(), 2);
					playerEditMenu.put(p.getName(), menu);
					p.closeInventory();
					paylasim.cancelEntry(p);}
				
			}
			else if(e.getSlot() == 7 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
					paylasim.gui.getString("AdminPanel.contactDev.itemName")))){
				e.setCancelled(true);
				p.sendMessage(paylasim.color("&b&lDISCORD&3 Geik#1211"));
			}
			else if(e.getSlot() == 8 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
					paylasim.gui.getString("Others.goBack.itemName")))){
				p.closeInventory();
				AdminGuiReturn.AEMenuRE(p);
			}
			
			
		}
		
		
	}

}
