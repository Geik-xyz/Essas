package me.geik.essas.metintasi;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.geik.essas.acik.paylasim;

public class metinGUI {
	
	public static HashMap<String, Integer> confirmation = new HashMap<String, Integer>();
	public static HashMap<String, String> chatEdit = new HashMap<String, String>();
	
	public static void metinGuiEvent1(InventoryClickEvent e, Player p) {
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&dMetinStone"))) {
			e.setCancelled(true);
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
			if(e.getSlot() == 1 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("MetinStone.metinTopBreakin.itemName")))){
				
				
			}
			else if(e.getSlot() == 4 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("MetinStone.toggleFeature.itemName")))){
				
				
			}
			else if(e.getSlot() == 7 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("MetinStone.metinHealth.itemName")))){
				
				
			}
			else if(e.getSlot() == 19 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("MetinStone.metinRespawnCD.itemName")))){
				
				
			}
			else if(e.getSlot() == 22 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("MetinStone.metinMaterial.itemName")))){
				
				
			}
			else if(e.getSlot() == 25 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("MetinStone.metinResAn.itemName")))){
				
				
			}
			else if(e.getSlot() == 37 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("MetinStone.spawnMobEveryHP.itemName")))){
				
				
			}
			else if(e.getSlot() == 40 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("MetinStone.healthEvents.itemName")))){
				
				
			}
			else if(e.getSlot() == 43 && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(paylasim.color(paylasim.gui.getString("AdminPanel.contactDev.itemName")))){
				
				
			}
		}
	}

}
