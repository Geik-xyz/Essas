package me.geik.essas.metintasi;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiItems;
import me.geik.essas.gui.AdminGuiReturn;
import me.geik.essas.permantKit.adakitGuiCMDS;

public class metinHealthPercentageGUI {

	
	public static void metinHealthPercentage(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&dMetinStone-HealthEvents"))) {
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
			e.setCancelled(true);
			if (e.getSlot() == 0) {
				metinHealthPercentageMenu1(player, 0);
			}
			else if (e.getSlot() == 2) {
				metinHealthPercentageMenu1(player, 25);
			}
			else if (e.getSlot() == 6) {
				metinHealthPercentageMenu1(player, 50);
			}
			else if (e.getSlot() == 8) {
				metinHealthPercentageMenu1(player, 75);
				
			}
		}
		else if (e.getView().getTitle().contains(paylasim.color("&dMetinHP-"))) {
			if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) return;
			e.setCancelled(true);
			String[] menuNameRR = e.getView().getTitle().split("-");
			String menuName = menuNameRR[1];
			if (e.getSlot() == 4) {
				AdminGuiReturn.healthEvents(player);
			}
			else if (e.getSlot() == 0) {
				adakitGuiCMDS.cmdListMenu(player, "metin.health-percent." + menuName + ".command", "&4Metin-CMDS-" + menuName);
			}
			else if (e.getSlot() == 8) {
				adakitGuiCMDS.cmdListMenu(player, "metin.health-percent." + menuName + ".spawn-mob", "&4Metin-MOBS-" + menuName);
			}
		}
	}
	
	
	
	public static void metinHealthPercentageMenu1(Player player, int name) {
		Inventory healtheventinside = Bukkit.getServer().createInventory(player, 9, (paylasim.color("&dMetinHP-" + String.valueOf(name))));
		
		ItemStack commnd = AdminGuiItems.metinHPCommandsnOthers(Material.PAPER, name, false);
		ItemStack mob = AdminGuiItems.metinHPCommandsnOthers(Material.ROTTEN_FLESH, name, true);
		
		healtheventinside.setItem(0, commnd);
		healtheventinside.setItem(8, mob);
		healtheventinside.setItem(4, AdminGuiItems.esya("Others", "goBack", Material.IRON_DOOR));
		
		player.openInventory(healtheventinside);
	}
}
