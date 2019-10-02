package me.geik.essas.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import me.geik.essas.acik.paylasim;

public class AdminGuiItems {
	public static ItemStack esya(String paneltype, String gamemode, Material itemmat) {
		
    	List<String> list = paylasim.gui.getStringList(paneltype + "." + gamemode + ".itemLore");
    	List<String> newList = new ArrayList<String>();
    	for (String string : list) {
    		newList.add(string.replace("&", "§"));}
    	String isim = paylasim.gui.getString(paneltype + "." + gamemode + ".itemName").replace("&", "§");
    	ItemStack item = new ItemStack(itemmat);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(isim);
    	meta.setLore(newList);
    	item.setItemMeta(meta);
    	return item;
	  }
	public static ItemStack dc(String paneltype, String gamemode, Material itemmat) {
		
    	List<String> list = paylasim.gui.getStringList(paneltype + "." + gamemode + ".itemLore");
    	List<String> newList = new ArrayList<String>();
    	for (String string : list) {
    		newList.add(string.replace("&", "§"));}
	    	newList.add(paylasim.color("&bhttps://discord.gg/xZ6fxK9"));
	    	newList.add(paylasim.color("&3Dev DC: &4Geik#1211"));
    	String isim = paylasim.gui.getString(paneltype + "." + gamemode + ".itemName").replace("&", "§");
    	ItemStack item = new ItemStack(itemmat);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(isim);
    	meta.setLore(newList);
    	item.setItemMeta(meta);
    	return item;
	  }
	// VOID TO SPAWN
	public static ItemStack togglesetting(String paneltype, String gamemode, Material itemmat, String cfgName, String toggletype, String mob) {
		String current;
		if (paylasim.cfg.getBoolean(cfgName + "." + toggletype) == true) {
			current = paylasim.fc.getString("Plugin.enabled");}
		else current = paylasim.fc.getString("Plugin.disabled");
		
    	List<String> list = paylasim.gui.getStringList(paneltype + "." + gamemode + ".itemLore");
    	List<String> newList = new ArrayList<String>();
    	for (String string : list) {
    		newList.add(string.replace("%cur%", current).replace("&", "§").replace("%mob%", mob));}
    	String isim = paylasim.gui.getString(paneltype + "." + gamemode + ".itemName").replace("%cur%", current).replace("&", "§");
    	ItemStack item = new ItemStack(itemmat);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(isim);
    	meta.setLore(newList);
    	item.setItemMeta(meta);
    	return item;
	  }
	public static ItemStack listCMDWorld(String paneltype, String gamemode, Material itemmat, String cfgName, String listName) {
		
		List<String> list = paylasim.gui.getStringList(paneltype + "." + gamemode + ".itemLore");
		List<String> newList = new ArrayList<String>();
		for (String string : list) {
			newList.add(string.replace("&", "§"));}
		List<String> list2 = paylasim.cfg.getStringList(cfgName + "." + listName);
		for (String string2 : list2) {
			newList.add(paylasim.color(" &7- &f" + string2));}
		String isim = paylasim.gui.getString(paneltype + "." + gamemode + ".itemName").replace("&", "§");
		ItemStack item = new ItemStack(itemmat);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(isim);
		meta.setLore(newList);
		item.setItemMeta(meta);
		return item;
	}
	public static ItemStack Allowedworlds(String paneltype, int i, String dir) {
		
		List<String> list = paylasim.gui.getStringList(paneltype + ".itemLore");
		List<String> newList = new ArrayList<String>();
		for (String string : list) {
			newList.add(string.replace("&", "§"));}
    	String isim = paylasim.cfg.getStringList(dir).get(i);
    	ItemStack item = new ItemStack(Material.PAPER);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(isim);
    	meta.setLore(newList);
    	item.setItemMeta(meta);
    	return item;
	  }
	
	// AEVENT ITEMS
	
	public static ItemStack AEVents(Material itemmat, String consoleName, String eventType, String setting) {
		
		String time = paylasim.cfg.getString("autoEvent." + consoleName + ".time");
		String command = paylasim.cfg.getString("autoEvent." + consoleName + ".command");
		
		List<String> list = paylasim.gui.getStringList("AutoEventGui." + eventType + ".itemLore");
		List<String> newList = new ArrayList<String>();
		for (String string : list) {
			newList.add(string.replace("&", "§").replace("%time%", time).replace("%cmd%", command)
					.replace("%settings%", setting).replace("command", "&aCommand: " + command).replace("time", "&eTime: " + time).replace("&", "§"));}
		String isim = paylasim.gui.getString("AutoEventGui." + eventType + ".itemName").replace("%id%", consoleName).replace("&", "§");
		ItemStack item = new ItemStack(itemmat);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(isim);
		meta.setLore(newList);
		item.setItemMeta(meta);
		return item;
	}
	// ChatEvent Items
	public static ItemStack chateventValue(String paneltype, String gamemode, Material itemmat, String gameType, String value) {
		
    	List<String> list = paylasim.gui.getStringList(paneltype + "." + gamemode + ".itemLore");
    	List<String> newList = new ArrayList<String>();
    	for (String string : list) {
    		newList.add(string.replace("&", "§").replace("%val%", paylasim.cfg.getString(gameType + "." + value)));}
    	String isim = paylasim.gui.getString(paneltype + "." + gamemode + ".itemName").replace("&", "§");
    	ItemStack item = new ItemStack(itemmat);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(isim);
    	meta.setLore(newList);
    	item.setItemMeta(meta);
    	return item;
	  }
	
public static ItemStack metinMobValue(String paneltype, String gamemode, Material itemmat, String gameType, String value, String newMob) {
		
    	List<String> list = paylasim.gui.getStringList(paneltype + "." + gamemode + ".itemLore");
    	List<String> newList = new ArrayList<String>();
    	for (String string : list) {
    		newList.add(string.replace("&", "§").replace("%val%", paylasim.cfg.getString(gameType + "." + value)).replace("%mob%", newMob) );}
    	String isim = paylasim.gui.getString(paneltype + "." + gamemode + ".itemName").replace("&", "§").replace("%mob%", newMob);
    	ItemStack item = new ItemStack(itemmat);
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(isim);
    	meta.setLore(newList);
    	item.setItemMeta(meta);
    	return item;
	  }
public static ItemStack metinHealthEVents (Material itemmat, int name) {
	List<String> list = paylasim.gui.getStringList("MetinStone.hpeventGui.itemLore");
	List<String> cfgList = paylasim.cfg.getStringList("metin.health-percent." + String.valueOf(name) + ".spawn-mob");
	List<String> cfgList2 = paylasim.cfg.getStringList("metin.health-percent." + String.valueOf(name) + ".command");
	List<String> newList = new ArrayList<String>();

	for (String string : list) {
		newList.add(string.replace("&", "§"));}
	newList.add(paylasim.color("&cMob Spawning:"));
	for (String setting : cfgList) {
		newList.add(("&f- &e" + setting).replace("&", "§"));
	}
	newList.add(paylasim.color("&dCommand:"));
	for (String setting2 : cfgList2) {
		newList.add(("&f- &3" + setting2).replace("&", "§"));
	}
	
	
	
	String isim = paylasim.color(String.valueOf(name));
	ItemStack item = new ItemStack(itemmat);
	ItemMeta meta = item.getItemMeta();
	meta.setDisplayName(isim);
	meta.setLore(newList);
	item.setItemMeta(meta);
	return item;
}

	public static ItemStack metinHPCommandsnOthers(Material itemmat, int name, boolean selector) {
		List<String> list = paylasim.gui.getStringList("MetinStone.hpeventGui.itemLore");
		List<String> cfgList = paylasim.cfg.getStringList("metin.health-percent." + String.valueOf(name) + ".spawn-mob");
		List<String> cfgList2 = paylasim.cfg.getStringList("metin.health-percent." + String.valueOf(name) + ".command");
		List<String> newList = new ArrayList<String>();

		for (String string : list) {
			newList.add(string.replace("&", "§"));}
		String isim = "Report this to Dev";
		
		
		if (selector == true) {
			isim = "&4Mobs";
			newList.add(paylasim.color("&cMob Spawning:"));
			for (String setting : cfgList) {
				newList.add(("&f- &e" + setting).replace("&", "§"));
			}
		}
		else {
			isim = "&cCommands";
			newList.add(paylasim.color("&dCommand:"));
			for (String setting2 : cfgList2) {
				newList.add(("&f- &3" + setting2).replace("&", "§"));
			}
		}
		
		
		String isim2 = paylasim.color(isim);
		ItemStack item = new ItemStack(itemmat);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(isim2);
		meta.setLore(newList);
		item.setItemMeta(meta);
		return item;
	}
}
