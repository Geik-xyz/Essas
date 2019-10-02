package me.geik.essas.permantKit;

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
import me.geik.essas.metintasi.metinHealthPercentageGUI;

public class adakitGuiCMDS {
public static HashMap<String, Integer> pkitCMD = new HashMap<String, Integer>();
public static HashMap<String, Integer> mmenuName = new HashMap<String, Integer>();
	
	
	public static HashMap<String, Integer> confirmationpkit = new HashMap<String, Integer>();
	
	public static void cmmdsMenu(InventoryClickEvent e, Player p, String MenuName, String cmdList, String adakit, int mmenu) throws IOException {
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color(MenuName+ mmenu)) || e.getView().getTitle().equalsIgnoreCase(paylasim.color(MenuName))) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
				int clicked = e.getSlot();
				int listSira = clicked-9;
				if (listSira >= 0) {
						if (confirmationpkit.containsKey(p.getName()) && confirmationpkit.get(p.getName()) == listSira) {
								confirmationpkit.remove(p.getName(), listSira);
								List<String> worldName = paylasim.cfg.getStringList(cmdList);
								worldName.remove(paylasim.cfg.getStringList(cmdList).get(listSira));
								paylasim.cfg.set(cmdList, worldName);
								paylasim.cfg.save(paylasim.c);
								Main.instance.reloadConfig();
								if (adakit == "adakit") adakitGuiCMDS.cmdListMenu(p, "permantKit.kit-cmds", "&bpKit-CMDS");
								else if (adakit == "mcmds") adakitGuiCMDS.cmdListMenu(p, cmdList, "&4Metin-CMDS-" + mmenu);
								else if (adakit == "mmobs") adakitGuiCMDS.cmdListMenu(p, cmdList, "&4Metin-MOBS-" + mmenu);
								else adakitGuiCMDS.cmdListMenu(p, "metin.top-breaking-reward", "&dMetin-TopBreaking Reward");
									
								
								paylasim.voidWorldREmoved(p);
							
						}else {
							confirmationpkit.put(p.getName(), listSira);
						paylasim.confirmationDel(p);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
								public void run() {
									if (confirmationpkit.containsKey(p.getName())) {
										confirmationpkit.remove(p.getName());
										paylasim.confirmExpire(p);}}},200);}
						
					
				} else {
					if(e.getSlot() == 8 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(
							paylasim.gui.getString("Others.addMoreData.itemName")))){
						if (!pkitCMD.containsKey(p.getName())) {
							if (adakit == "adakit") pkitCMD.put(p.getName(), 1);
							else if (adakit == "mmobs") {pkitCMD.put(p.getName(), 2); mmenuName.put(p.getName(), mmenu);}
							else if (adakit == "mcmds") {pkitCMD.put(p.getName(), 3); mmenuName.put(p.getName(), mmenu);}
							else pkitCMD.put(p.getName(), 0);
							p.closeInventory();
							paylasim.cancelEntry(p);
							
						}
						else {
							pkitCMD.remove(p.getName());
							mmenuName.remove(p.getName());}}
					if (e.getSlot() == 0) {
						if (adakit == "adakit") AdminGuiReturn.pKitReturnsMain(p);
						else if (adakit == "mmobs") metinHealthPercentageGUI.metinHealthPercentageMenu1(p, mmenu);
						else if (adakit == "mcmds") metinHealthPercentageGUI.metinHealthPercentageMenu1(p, mmenu);
						else AdminGuiReturn.metinMainRE(p);
					}
				}
				
						
		}
	}
	public static void cmmdsMenu2(InventoryClickEvent e, Player p) throws IOException {
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&bpKit"))) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
			if(e.getSlot() == 4){
				if (paylasim.cfg.getBoolean("permantKit.enable-kit") == true) {
					paylasim.cfg.set("permantKit.enable-kit", false);
					paylasim.cfg.save(paylasim.c);
					Main.instance.reloadConfig();
					p.closeInventory();
					AdminGuiReturn.pKitReturnsMain(p);
					paylasim.debugSomethng("&cpKit has cancelled by &b" + p.getName());
				}
				else {
					paylasim.cfg.set("permantKit.enable-kit", true);
					paylasim.cfg.save(paylasim.c);
					Main.instance.reloadConfig();
					p.closeInventory();
					AdminGuiReturn.pKitReturnsMain(p);
					paylasim.debugSomethng("&apKit has resumed by &b" + p.getName());
			}
			}
			else if (e.getSlot() == 0  && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("pKit.cmds.itemName")))) {
			  adakitGuiCMDS.cmdListMenu(p, "permantKit.kit-cmds", "&bpKit-CMDS");
		  }
			else if (e.getSlot() == 8 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("AdminPanel.contactDev.itemName")))) {
				p.sendMessage(paylasim.color("&b&lDISCORD &3Geik#1211"));
			}
		}
	}
	// pKitMenuCreator
	public static void cmdListMenu(Player p, String cmdList, String menuName) {
		Inventory kits = Bukkit.getServer().createInventory(p, 27, (paylasim.color(menuName)));
		
		kits.setItem(0, AdminGuiItems.esya("Others", "goBack", Material.IRON_DOOR));
		kits.setItem(8, AdminGuiItems.esya("Others", "addMoreData", Material.TORCH));
		
		
		List<String> list = paylasim.cfg.getStringList(cmdList);
		if (list.size() >= 2) {
			String[] array = list.toArray(new String[list.size()]);
			for (int i = 0 ; i <= 17 ; i++) {
				if (array.length <= 17) {
					if (array.length == i) {
						p.openInventory(kits);
						break;
					}
					else kits.setItem(i+9, AdminGuiItems.Allowedworlds("Others.commands", i, cmdList));
				}
				else break;
				
			}
		} else if (list.size() == 1){
			kits.setItem(9, AdminGuiItems.Allowedworlds("Others.commands", 0, cmdList));
			p.openInventory(kits);
		}
		else {
			p.openInventory(kits);
		}
	}

}