package me.geik.essas.location;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MetinCordinate {
	
	
	public static void metinloc() throws IOException
	  {
		  File metinloc = new File("plugins/Essas/locations", "metinloc.yml");
		  if (!metinloc.exists()){
			  metinloc.createNewFile();
		    FileConfiguration ml = YamlConfiguration.loadConfiguration(metinloc);
		    ml.set("Location.x", null);
		    ml.set("Location.y", null);
			ml.set("Location.z", null);
			ml.set("Location.yaw", null);
			ml.set("Location.pitch", null);
			ml.set("Location.world", null);
			ml.save(metinloc);}
		  
	  }

}
