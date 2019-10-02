package me.geik.essas;

import org.bukkit.Bukkit;

import me.geik.essas.metintasi.metinGuiListener;
import me.geik.essas.metintasi.metinListener;
import me.geik.essas.permantKit.adakitGui;
import me.geik.essas.voidtospawn.VoidListener;
import me.geik.essas.autoevent.AEListener;
import me.geik.essas.chat.chatListener;
import me.geik.essas.chatevent.chatEventListener;
import me.geik.essas.gui.AdminPanelListener;

public class ListenerRegister {
	
	public VoidListener voidListener;
	public metinListener metinlisten;
	public chatEventListener chatevent;
	public chatListener clistener;
	public AdminPanelListener guilist1;
	public AEListener aelistener;
	public adakitGui adakitListener;
	public metinGuiListener metinguilistener;
	
	@SuppressWarnings("unused")
	private Main plugin;
	public ListenerRegister(Main plugin){
		    this.plugin = plugin;}
	
	public ListenerRegister() {
		this.voidListener = new VoidListener(Main.instance);
		Bukkit.getPluginManager().registerEvents(voidListener, Main.instance);
		this.metinlisten = new metinListener(Main.instance);
		Bukkit.getPluginManager().registerEvents(metinlisten, Main.instance);
		this.chatevent = new chatEventListener(Main.instance);
		Bukkit.getPluginManager().registerEvents(chatevent, Main.instance);
		this.clistener = new chatListener(Main.instance);
		Bukkit.getPluginManager().registerEvents(clistener, Main.instance);
		this.guilist1 = new AdminPanelListener(Main.instance);
		Bukkit.getPluginManager().registerEvents(guilist1, Main.instance);
		this.aelistener = new AEListener(Main.instance);
		Bukkit.getPluginManager().registerEvents(aelistener, Main.instance);
		this.adakitListener = new adakitGui(Main.instance);
		Bukkit.getPluginManager().registerEvents(adakitListener, Main.instance);
		this.metinguilistener = new metinGuiListener(Main.instance);
		Bukkit.getPluginManager().registerEvents(metinguilistener, Main.instance);
		
	}
	
	

}
