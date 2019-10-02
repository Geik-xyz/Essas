package me.geik.essas.language;

import java.io.File;

import me.geik.essas.acik.paylasim;

public class LangCreator {
	
	public static void LangChecker() {
	 
		 File f = new File("plugins/Essas", paylasim.langName + ".yml");
		 if (!f.exists()) {
		   paylasim.langName = "en-US";
		 }
	}
	
}
