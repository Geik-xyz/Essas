package me.geik.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;


public class UpdateChecker {
	  public static Thread checkupdates = new Thread()
	  {
		File cf = new File("plugins/Essas/config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(cf);
	    
	    public void run()
	    {
	    	if (cfg.getBoolean("updateChecker") == true){
	    	
	        URL url = null;
	        try
	        {
	          url = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + Main.API);
	        }
	        catch (MalformedURLException localMalformedURLException) {}
	        URLConnection conn = null;
	        try
	        {
	          conn = url.openConnection();
	        }
	        catch (IOException localIOException) {}
	        try
	        {
	          BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	          if (br.readLine().equals(paylasim.version))
	          {
	        	  Bukkit.getConsoleSender().sendMessage(paylasim.color(paylasim.fc.getString("Plugin.Prefix") + " " + paylasim.fc.getString("Update.latestVersion")
	        	  .replace("%pl", paylasim.fc.getString("Plugin.Prefix"))));
	            Main.update = false;
	          }
	          else
	          {
	        	Bukkit.getConsoleSender().sendMessage(paylasim.color(paylasim.fc.getString("Plugin.Prefix") +  " " +paylasim. fc.getString("Update.updateAvailable")
	        	.replace("%pl", paylasim.fc.getString("Plugin.Prefix"))));
	            Main.update = true;
	          }
	        }
	        catch (IOException localIOException1) {}
	    	}
	    }
	  };

}
