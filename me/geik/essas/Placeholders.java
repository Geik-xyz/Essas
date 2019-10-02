package me.geik.essas;

import org.bukkit.entity.Player;


import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.geik.essas.acik.paylasim;
import me.geik.essas.metintasi.metinListener;

public class Placeholders extends PlaceholderExpansion {
	@SuppressWarnings("unused")
	private Main plugin;
    
    public String getIdentifier() {
        return "essas";
    }

    public String getPlugin() {
        return null;
    }


    /*
     The author of the Placeholder
     This cannot be null
     */
    public String getAuthor() {
        return "Geik";
    }

    /*
     Same with #getAuthor() but for versioon
     This cannot be null
     */

    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {
        // placeholder: %customplaceholder_staff_count%
        if (identifier.equals("metinstone_hp_current")) {
        	if (metinListener.metindurumu == true){
        		return String.valueOf(metinListener.can);
        	}
        	else{
        		return String.valueOf("");
        	}
        }
        if (identifier.equals("metinstone_hp_max")) {
        	if (metinListener.metindurumu == true){
        		return String.valueOf(metinListener.defaultcan);
        	}
        	else{
        		return String.valueOf("");
        	}
        }
        if (identifier.equals("metinstone_status")){
        	if (metinListener.metindurumu == true){
        		return String.valueOf(paylasim.color(paylasim.fc.getString("metinStone.alive")));
        	}
        	else{
        		return String.valueOf(paylasim.color(paylasim.fc.getString("metinStone.death")));
        	}
        }
        // always check if the player is null for placeholders related to the player!
        // anything else someone types is invalid because we never defined %customplaceholder_<what they want a value for>%
        // we can just return null so the placeholder they specified is not replaced.
        return null;
    }
    	
    }
