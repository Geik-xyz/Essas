package me.geik.essas.location;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class VoidToSpawnLocation {
	
	  public static void voidLocation() throws IOException
	  {
		  File voidspawnloc = new File("plugins/Essas/locations", "voidspawn.yml");
		  if (!voidspawnloc.exists()){
			voidspawnloc.createNewFile();
		    FileConfiguration loc = YamlConfiguration.loadConfiguration(voidspawnloc);
			loc.set("Location.x", null);
			loc.set("Location.y", null);
			loc.set("Location.z", null);
			loc.set("Location.yaw", null);
			loc.set("Location.pitch", null);
			loc.set("Location.world", null);
			loc.save(voidspawnloc);}
		  
	  }

}
