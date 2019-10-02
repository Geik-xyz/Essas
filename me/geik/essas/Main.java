package me.geik.essas;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.geik.essas.acik.paylasim;
import me.geik.essas.autoevent.AEListener;
import me.geik.essas.chatevent.chatEvent;
import me.geik.essas.language.LangCreator;
import me.geik.essas.location.LocationsCreator;
import me.geik.essas.metintasi.metinListener;
import me.geik.essas.permantKit.adakitfolder;
import me.geik.utils.UpdateChecker;

public class Main extends JavaPlugin{
	
	public static ListenerRegister listeners;
	public static Main instance;
	public static int API = 61901;
	public static boolean update;
	public static boolean globalmute = false;
	Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("Essas");
	File langen = new File("plugins/Essas", "en-US.yml");
	File langenGui = new File("plugins/Essas", "en-US-Gui.yml");
	File langtr = new File("plugins/Essas", "tr-TR.yml");
	File langtrGui = new File("plugins/Essas", "tr-TR-Gui.yml");
	
	public void onEnable() {
		try {LocationsCreator.locationFile();} catch (IOException e) {e.printStackTrace();}
		try {adakitfolder.alanlarKurulum();} catch (IOException e) {e.printStackTrace();}
		saveDefaultConfig();
		if (!langen.exists()) saveResource("en-US.yml", false);
		if (!langenGui.exists()) saveResource("en-US-Gui.yml", false);
		if (!langtr.exists()) saveResource("tr-TR.yml", false);
		if (!langtrGui.exists()) saveResource("tr-TR-Gui.yml", false);
		instance = this;
		listeners = new ListenerRegister();
		getCommand("voidtospawn").setExecutor(new me.geik.essas.voidtospawn.voidCommands(this));
		getCommand("pkit").setExecutor(new me.geik.essas.permantKit.adakit(this));
		getCommand("autoevent").setExecutor(new me.geik.essas.autoevent.AECommands(this));
		getCommand("metinstone").setExecutor(new me.geik.essas.metintasi.metinCommands(this));
		getCommand("clear").setExecutor(new me.geik.essas.chat.chatCommand(this));
		getCommand("mutechat").setExecutor(new me.geik.essas.chat.chatCommand(this));
		getCommand("essas").setExecutor(new me.geik.essas.maincommands.Commands(this));
		if (getConfig().getBoolean("autoEvent.events") == true) {
			Bukkit.getConsoleSender().sendMessage(paylasim.color("&a&lESSAS &aAutoEvent enabled."));
			AEListener.taskAgain();}
		metinListener.metindurumu = false;
		if (getConfig().getBoolean("metin.event") == true) {
			Bukkit.getConsoleSender().sendMessage(paylasim.color("&a&lESSAS &aMetinStone enabled."));
			metinListener.metincd2();
		}
		if( Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
			new Placeholders().register();}
		if (getConfig().getBoolean("chat-event.events") == true) {
			Bukkit.getConsoleSender().sendMessage(paylasim.color("&a&lESSAS &aChatEvent enabled."));
		chatEvent.ChatEventBaslat();}
		UpdateChecker.checkupdates.start();
		
		metrics();
        globalmute = false;
        LangCreator.LangChecker();
	}
	
	
	
	
	public void onDisable() {
	  
	}
	
	public void metrics() {
		Metrics metrics = new Metrics(this);
        metrics.addCustomChart(new Metrics.DrilldownPie("java_version", () -> {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        String javaVersion = System.getProperty("java.version");
        Map<String, Integer> entry = new HashMap<>();
        entry.put(javaVersion, 1);
        if (javaVersion.startsWith("1.7")) {
            map.put("Java 1.7", entry);
        } else if (javaVersion.startsWith("1.8")) {
            map.put("Java 1.8", entry);
        } else if (javaVersion.startsWith("1.9")) {
            map.put("Java 1.9", entry);
        } else {
            map.put("Other", entry);
        }
        return map;
        }));
	}
	
	

}
