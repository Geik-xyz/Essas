package me.geik.essas.chatevent;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiItems;
import me.geik.essas.gui.AdminGuiReturn;

public class chatEventCmmds {
	
	public static HashMap<String, Integer> playercmds = new HashMap<String, Integer>();
	
	
	static HashMap<String, String> confirmation = new HashMap<String, String>();
	
	public static void cmmdsMenu(InventoryClickEvent e, Player p, String MenuName, String cmdList) {
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color(MenuName))) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
				int clicked = e.getSlot();
				int listSira = clicked-9;
				if (listSira >= 0) {
					if(e.getSlot() == clicked && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
							paylasim.cfg.getStringList(cmdList).get(listSira)))){
						if (confirmation.containsKey(p.getName()) && confirmation.containsValue(paylasim.cfg.getStringList(cmdList).get(listSira))) {
							confirmation.remove(p.getName(), paylasim.cfg.getStringList(cmdList).get(listSira));
							List<String> worldName = paylasim.cfg.getStringList(cmdList);
							worldName.remove(paylasim.cfg.getStringList(cmdList).get(listSira));
							paylasim.cfg.set(cmdList, worldName);
							try {paylasim.cfg.save(paylasim.c);} catch (IOException e1) {e1.printStackTrace();}
							Main.instance.reloadConfig();
							cmdListMenu(p);
							paylasim.voidWorldREmoved(p);
							
						}else {
						confirmation.put(p.getName(), paylasim.cfg.getStringList(cmdList).get(listSira));
						paylasim.confirmationDel(p);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
								public void run() {
									if (confirmation.containsKey(p.getName())) {
										confirmation.remove(p.getName());
										paylasim.confirmExpire(p);}}},200);}
						
					}
				} else {
					if(e.getSlot() == 8 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
							paylasim.gui.getString("Others.addMoreData.itemName")))){
						if (!playercmds.containsKey(p.getName())) {
							playercmds.put(p.getName(), 1);
							p.closeInventory();
							paylasim.cancelEntry(p);
							
						}
						else {
							playercmds.remove(p.getName());}}
					if (e.getSlot() == 0) {
						AdminGuiReturn.ChatEventMainRE(p);
					}
				}
				
						
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// chatEventMenuCreator
	public static void cmdListMenu(Player p) {
		Inventory worlds = Bukkit.getServer().createInventory(p, 27, (paylasim.color("&dChat Even GUI-Cmds")));
		
		worlds.setItem(0, AdminGuiItems.esya("Others", "goBack", Material.IRON_DOOR));
		worlds.setItem(8, AdminGuiItems.esya("Others", "addMoreData", Material.TORCH));
		
		
		List<String> list = paylasim.cfg.getStringList("chat-event.reward");
		String[] array = list.toArray(new String[list.size()]);
		for (int i = 0 ; i <= 17 ; i++) {
			if (array.length <= 17) {
				if (array.length == i) {
					p.openInventory(worlds);
					break;
				}
				else worlds.setItem(i+9, AdminGuiItems.Allowedworlds("Others.commands", i, "chat-event.reward"));
			}
			else break;
			
		}
	}

}
