package me.geik.essas.metintasi;

public class metinCore {
	
	/*public static void metinhealthEvent(String health, Player player) {
		  Set<String> keys = metinListener.playersx.keySet();
	      for(String key: keys){
			for (String metintasiKiran : paylasim.cfg.getStringList("metin.health-percent." + health + ".command")){
				  metintasiKiran = metintasiKiran.replaceAll("&", "§");
				  metintasiKiran = metintasiKiran.replaceAll("%player%", key);
				  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), metintasiKiran);}
			
		 }
		}
		
		public static void spawnmobs(String health, Player player) {
		  for (String mobs : paylasim.cfg.getStringList("metin.health-percent." + health + ".spawn-mob")){
			String[] count = mobs.split(",");
			int mobcount = Integer.valueOf(count[1]);
			EntityType mobtype = EntityType.valueOf(count[0]);
			for (int i = 0; i < mobcount ; i++) {
				player.getWorld().spawnEntity(player.getLocation().add(1, 2, 0), mobtype);}
		  }
				
	    }
		
		
		public static void canEksilince(Player player) {
			metinListener.can = metinListener.can-1;
			if (!metinListener.playersx.containsKey(player.getName())) {
				metinListener.playersx.put(player.getName(), 1);
			} else {
				int count = metinListener.playersx.get(player.getName());
				metinListener.playersx.remove(player.getName());
				metinListener.playersx.put(player.getName(), count + 1);
			}
			if (metinListener.yetmisbescan == metinListener.can) {
				metinhealthEvent("75", player);
				spawnmobs("75", player);
			}
			else if (metinListener.ellican == metinListener.can) {
				metinhealthEvent("50", player);
				spawnmobs("50", player);
			}
			else if (metinListener.yirmibescan == metinListener.can) {
				metinhealthEvent("25", player);
				spawnmobs("25", player);}
		}
		public static void canEksilince2(Player player) {
			if (paylasim.cfg.getBoolean("metin.spawn-mob-every-health.enable") == true ) {
				if (paylasim.cfg.getBoolean("metin.spawn-mob-every-health.zombie") == true) {
					int zombiecount = paylasim.cfg.getInt("metin.spawn-mob-every-health.zombie-count");
					for (int i = 0; i < zombiecount ; i++) {
						player.getWorld().spawnEntity(player.getLocation().add(1, 2, 0), EntityType.ZOMBIE);}
					
				}
				if (paylasim.cfg.getBoolean("metin.spawn-mob-every-health.skeleton") == true) {
					int skeletoncount = paylasim.cfg.getInt("metin.spawn-mob-every-health.skeleton-count");
					for (int i = 0; i < skeletoncount ; i++) {
						player.getWorld().spawnEntity(player.getLocation().add(1, 2, 0), EntityType.SKELETON);}
					
					
				}
			}
		}
		
		public static void tasRestorasyonu(BlockBreakEvent e, String matsx) {
			e.setCancelled(true);
			e.getBlock().setType(Material.getMaterial(matsx));
			e.getBlock().getDrops().clear();
		}
		
		public static BukkitRunnable metintask;
		public static void metincd2() {
			 if (metintask != null) {
				 metintask.cancel();
				 metintask = null;
		        }
			 metintask = new BukkitRunnable() {
		            @Override
		            public synchronized void cancel() throws IllegalStateException {
		                super.cancel();
		            }
		            public void run() {
		            	if (metinListener.loc.get("Location.x") != null && metinListener.loc.get("Location.world") != null) {
		            	int x = metinListener.loc.getInt("Location.x");
		    			int y = metinListener.loc.getInt("Location.y");
		    			int z = metinListener.loc.getInt("Location.z");
		    			String string = metinListener.loc.getString("Location.world");
		    			World world = Bukkit.getServer().getWorld(string);
		    			Location tas = new Location(world, x, y, z);
		    			String materialx = paylasim.cfg.getString("metin.metin-material");
		    			
		    			metinListener.can = metinListener.defaultcan;
		                	tas.getBlock().setType(Material.getMaterial(materialx));
		                	metinListener.metindurumu = true;
		                	 if (paylasim.cfg.getBoolean("metin.respawned-again-broadcast") == true) paylasim.metinStoneBroadcast();
		                	metintask.cancel();
		            	} else paylasim.metinTasNo(Bukkit.getServer().getConsoleSender());
		    			
		            	metintask.cancel();
		            }
		        }; metintask.runTaskLater(Main.instance, 20*60*paylasim.cfg.getInt("metin.respawn-cooldown"));
		    }*/

}
