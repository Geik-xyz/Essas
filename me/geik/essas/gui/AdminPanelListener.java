package me.geik.essas.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class AdminPanelListener implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public AdminPanelListener(Main plugin) {
		this.plugin = plugin;}
	
	@EventHandler
	public void onclickA(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(paylasim.color("&cAdmin Panel"))) {
        	if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
        	else {
        		e.setCancelled(true);
        		AdminGuiInteracts.voidToSpawn(e, p);
        		AdminGuiInteracts.autoEvent(e, p);
        		AdminGuiInteracts.chatEvent(e, p);
        		AdminGuiInteracts.pkit(e, p);
        		AdminGuiInteracts.metin(e, p);
        	}
        }
		
	}
}
