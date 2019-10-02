package me.geik.essas.location;

import java.io.File;
import java.io.IOException;

public class LocationsCreator {
	
	
	
	public static void locationFile() throws IOException
	{File langFile = new File("plugins/Essas", "locations");
	 if (!langFile.exists()) {
		 langFile.mkdirs();
		 VoidToSpawnLocation.voidLocation();
		 MetinCordinate.metinloc();
	 }
	 else {
		 VoidToSpawnLocation.voidLocation();
		 MetinCordinate.metinloc();
	 }
	}

}
