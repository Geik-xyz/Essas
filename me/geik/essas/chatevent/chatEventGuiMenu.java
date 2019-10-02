package me.geik.essas.chatevent;

import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiReturn;

public class chatEventGuiMenu {
	
	public static HashMap<String, String> playerEdit = new HashMap<String, String>();
	static String menu = null;
	
	public static void chatGuiMain(InventoryClickEvent e, Player p) {
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&6Chat Event Gui"))) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
			if(e.getSlot() == 1 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("ChatEventGui.gameCooldown.itemName")))){
				if (playerEdit.containsKey(p.getName())) {
					playerEdit.remove(p.getName());
					playerEdit.put(p.getName(), "gameCoolDown");
					p.closeInventory();
				}else {
					playerEdit.put(p.getName(), "gameCoolDown");
					p.closeInventory();}
				
			}
			else if(e.getSlot() == 4){
				if (paylasim.cfg.getBoolean("chat-event.events") == true) {
					paylasim.cfg.set("chat-event.events", false);
					try {paylasim.cfg.save(paylasim.c);} catch (IOException e1) {e1.printStackTrace();}
					Main.instance.reloadConfig();
					chatEvent.donguid.cancel();
					chatEvent.basladi = null;
					p.closeInventory();
					AdminGuiReturn.ChatEventMainRE(p);
					paylasim.debugSomethng("&cChat event has cancelled by &b" + p.getName());
				}
				else {
					chatEvent.ChatEventBaslat();
					paylasim.cfg.set("chat-event.events", true);
					try {paylasim.cfg.save(paylasim.c);} catch (IOException e1) {e1.printStackTrace();}
					Main.instance.reloadConfig();
					p.closeInventory();
					AdminGuiReturn.ChatEventMainRE(p);
					paylasim.debugSomethng("&aChat Event has resumed by &b" + p.getName());
			}
				
			}
			else if(e.getSlot() == 7 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("ChatEventGui.gameLong.itemName")))){
				if (playerEdit.containsKey(p.getName())) {
					playerEdit.remove(p.getName());
					playerEdit.put(p.getName(), "gameLong");
					p.closeInventory();
				}else {
					playerEdit.put(p.getName(), "gameLong");
					p.closeInventory();}
			}
			else if(e.getSlot() == 19 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("ChatEventGui.gameChars.itemName")))){
				if (playerEdit.containsKey(p.getName())) {
					playerEdit.remove(p.getName());
					playerEdit.put(p.getName(), "chars");
					p.closeInventory();
				}else {
					playerEdit.put(p.getName(), "chars");
					p.closeInventory();}
			}
			else if(e.getSlot() == 22 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("ChatEventGui.wordLong.itemName")))){
				if (playerEdit.containsKey(p.getName())) {
					playerEdit.remove(p.getName());
					playerEdit.put(p.getName(), "wordLong");
					p.closeInventory();
				}else {
					playerEdit.put(p.getName(), "wordLong");
					p.closeInventory();}
			}
			else if(e.getSlot() == 25 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("ChatEventGui.cmds.itemName")))){
				chatEventCmmds.cmdListMenu(p);
			}

			
		}
	}

}
