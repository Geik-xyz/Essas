package me.geik.essas.permantKit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class adakitfolder {
	
	
	public static void alanlarKurulum() throws IOException
	{File langFile = new File("plugins/Essas", "pkit");
	 if (!langFile.exists()) {
		 langFile.mkdirs();
		 adakityml();
		 adakitIP() ;
	 }
	 else {
		 adakityml();
		 adakitIP();
	 }

	}
	public static void adakityml() throws IOException
	  {
		  File alanlarKurulum = new File("plugins/Essas/pkit", "players.yml");
		  if (!alanlarKurulum.exists()){
			alanlarKurulum.createNewFile();
		    FileConfiguration alan = YamlConfiguration.loadConfiguration(alanlarKurulum);
		    List<String> hasPack = new ArrayList<String>();
			hasPack.addAll(alan.getStringList("Takes"));
		    alan.set("Takes", hasPack);
		    alan.save(alanlarKurulum);}
	  }
	public static void adakitIP() throws IOException
	  {
		  File alanlarKurulumip = new File("plugins/Essas/pkit", "playerIPs.yml");
		  if (!alanlarKurulumip.exists()){
			alanlarKurulumip.createNewFile();
		    FileConfiguration alan = YamlConfiguration.loadConfiguration(alanlarKurulumip);
		    List<String> hasPack = new ArrayList<String>();
			hasPack.addAll(alan.getStringList("Takes"));
		    alan.set("Takes", hasPack);
		    alan.save(alanlarKurulumip);}
	  }

}
