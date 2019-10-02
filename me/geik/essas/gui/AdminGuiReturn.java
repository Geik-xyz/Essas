package me.geik.essas.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.geik.essas.acik.paylasim;

public class AdminGuiReturn {
	
	public static void mainMenu(Player player) {
		Inventory sohbet = Bukkit.getServer().createInventory(player, 27, (paylasim.color("&cAdmin Panel")));
		ItemStack gui1 = AdminGuiItems.esya("AdminPanel", "voidtospawn", Material.ENDER_PEARL);
		ItemStack gui2 = AdminGuiItems.esya("AdminPanel", "metinstone", Material.SPONGE);
		ItemStack gui3 = AdminGuiItems.esya("AdminPanel", "chatEvent", Material.PAPER);
		ItemStack gui4 = AdminGuiItems.esya("AdminPanel", "permantKit", Material.IRON_AXE);
		ItemStack gui5 = AdminGuiItems.esya("AdminPanel", "autoEvent", Material.COMPASS);
		ItemStack gui6 = AdminGuiItems.dc("AdminPanel", "contactDev", Material.BOOK);
		sohbet.setItem(1, gui1);
		sohbet.setItem(4, gui2);
		sohbet.setItem(7, gui3);
		sohbet.setItem(19, gui4);
		sohbet.setItem(22, gui5);
		sohbet.setItem(25, gui6);
		player.openInventory(sohbet);
	}
	
	// VOID MENU
	
	public static void voidtoSpawnMenuRe(Player player) {
		Inventory sohbet = Bukkit.getServer().createInventory(player, 9, (paylasim.color("&dVoidTheGui")));
		
		ItemStack gui3 = AdminGuiItems.esya("VoidToSpawn", "setVoidSpawn", Material.MAP);
		ItemStack gui2 = AdminGuiItems.listCMDWorld("VoidToSpawn", "allowedWorlds", Material.BEDROCK, "voidToSpawn", "allowedWorlds");
		ItemStack gui1 = AdminGuiItems.togglesetting("VoidToSpawn", "toggleFeature", Material.LEVER, "voidToSpawn", "teleportSpawn", "");
		sohbet.setItem(1, gui1);
		sohbet.setItem(4, gui2);
		sohbet.setItem(7, gui3);
		player.openInventory(sohbet);
		
	}

	// AE Menu
	
	public static void AEMenuRE(Player player) {
		Inventory aemenu = Bukkit.getServer().createInventory(player, 27, (paylasim.color("&bAuto Event Gui")));
		
		ItemStack gui1 = AdminGuiItems.togglesetting("AutoEventGui", "toggleFeature", Material.LEVER, "autoEvent", "events", "");
		ItemStack first = AdminGuiItems.AEVents(Material.GOLD_INGOT, "first", "events", "");
		ItemStack second = AdminGuiItems.AEVents(Material.GOLD_INGOT, "second", "events", "");
		ItemStack third = AdminGuiItems.AEVents(Material.GOLD_INGOT, "third", "events", "");
		
		
		aemenu.setItem(1, first);
		aemenu.setItem(4, second);
		aemenu.setItem(7, third);
		aemenu.setItem(22, gui1);
		player.openInventory(aemenu);
		
	}
	public static void AEEventsRE(Player player, String menu) {
		Inventory aemenu = Bukkit.getServer().createInventory(player, 9, (paylasim.color("&cAuto Event "+menu)));
		
		ItemStack cmd = AdminGuiItems.AEVents(Material.PAPER, menu, "eventEditCMD", "command");
		ItemStack time = AdminGuiItems.AEVents(Material.PAPER, menu, "eventEditCMD", "time");
		ItemStack gui6 = AdminGuiItems.dc("AdminPanel", "contactDev", Material.BOOK);
		
		
		aemenu.setItem(0, cmd);
		aemenu.setItem(1, time);
		aemenu.setItem(7, gui6);
		aemenu.setItem(8, AdminGuiItems.esya("Others", "goBack", Material.IRON_DOOR));
		player.openInventory(aemenu);
		
	}
	// Chat Event Return
	
	public static void ChatEventMainRE(Player player) {
		Inventory chatgui = Bukkit.getServer().createInventory(player, 27, (paylasim.color("&6Chat Event Gui")));
		
		ItemStack toggleFeature = AdminGuiItems.togglesetting("ChatEventGui", "toggleFeature", Material.LEVER, "chat-event", "events", "");
		ItemStack gameCooldown = AdminGuiItems.chateventValue("ChatEventGui", "gameCooldown", Material.COMPASS, "chat-event", "gameCoolDown");
		ItemStack gameLong = AdminGuiItems.chateventValue("ChatEventGui", "gameLong", Material.STICK, "chat-event", "gameLong");
		ItemStack gameChars = AdminGuiItems.chateventValue("ChatEventGui", "gameChars", Material.MAP, "chat-event", "chars");
		ItemStack wordLong = AdminGuiItems.chateventValue("ChatEventGui", "wordLong", Material.CACTUS, "chat-event", "wordLong");
		ItemStack cmds = AdminGuiItems.listCMDWorld("ChatEventGui", "cmds", Material.PAPER, "chat-event", "reward");
		
		
		chatgui.setItem(4, toggleFeature);
		chatgui.setItem(1, gameCooldown);
		chatgui.setItem(7, gameLong);
		chatgui.setItem(19, gameChars);
		chatgui.setItem(22, wordLong);
		chatgui.setItem(25, cmds);
		player.openInventory(chatgui);
		
	}
	// pKit
	public static void pKitReturnsMain(Player player) {
		Inventory aemenu = Bukkit.getServer().createInventory(player, 9, (paylasim.color("&bpKit")));
		
		ItemStack toggle = AdminGuiItems.togglesetting("pKit", "toggleFeature", Material.LEVER, "permantKit", "enable-kit", "");
		ItemStack cmd = AdminGuiItems.listCMDWorld("pKit", "cmds", Material.PAPER, "permantKit", "kit-cmds");
		ItemStack gui6 = AdminGuiItems.dc("AdminPanel", "contactDev", Material.BOOK);
		
		
		aemenu.setItem(4, toggle);
		aemenu.setItem(0, cmd);
		aemenu.setItem(8, gui6);
		player.openInventory(aemenu);
		
	}
	// METIN MAIN MENU RETURNER
	public static void metinMainRE(Player player) {
		Inventory aemenu = Bukkit.getServer().createInventory(player, 45, (paylasim.color("&dMetinStone")));
		
		ItemStack gui6 = AdminGuiItems.dc("AdminPanel", "contactDev", Material.BOOK); //
		ItemStack cmd = AdminGuiItems.listCMDWorld("MetinStone", "metinTopBreakin", Material.PAPER, "metin", "top-breaking-reward");//
		
		ItemStack toggleCDAN = AdminGuiItems.togglesetting("MetinStone", "metinResAn", Material.TORCH, "metin", "respawned-again-broadcast", ""); //
		ItemStack toggle = AdminGuiItems.togglesetting("MetinStone", "toggleFeature", Material.LEVER, "metin", "event", ""); //
		
		ItemStack metinhp = AdminGuiItems.chateventValue("MetinStone", "metinHealth", Material.APPLE, "metin", "health"); //
		ItemStack metincd = AdminGuiItems.chateventValue("MetinStone", "metinRespawnCD", Material.COMPASS, "metin", "respawn-cooldown"); //
		ItemStack metinmat = AdminGuiItems.chateventValue("MetinStone", "metinMaterial", Material.SPONGE, "metin", "metin-material"); //
		
		ItemStack metinSPMobGUI = AdminGuiItems.esya("MetinStone", "spawnMobEveryHP", Material.NETHERRACK); //
		ItemStack metinHPEventGUI = AdminGuiItems.esya("MetinStone", "healthEvents", Material.BOOKSHELF);
		
		
		
		aemenu.setItem(1, cmd);
		aemenu.setItem(4, toggle);
		aemenu.setItem(7, metinhp);
		aemenu.setItem(19, metincd);
		aemenu.setItem(22, metinmat);
		aemenu.setItem(25, toggleCDAN);
		aemenu.setItem(37, metinSPMobGUI);
		aemenu.setItem(40, metinHPEventGUI);
		aemenu.setItem(43, gui6);
		player.openInventory(aemenu);
	}
	public static void spawnMobEveryHP(Player player) {
		Inventory spawnmobhpmenu = Bukkit.getServer().createInventory(player, 18, (paylasim.color("&dMetinStone-SpawnMob")));
		
		ItemStack togglefeature = AdminGuiItems.togglesetting("MetinStone", "toggleFeature", Material.TORCH, "metin.spawn-mob-every-health", "enable", ""); //
		
		ItemStack togglezombie = AdminGuiItems.togglesetting("MetinStone", "toggleMob", Material.TORCH, "metin.spawn-mob-every-health", "zombie", "ZOMBIE"); //
		ItemStack toggleskeleton = AdminGuiItems.togglesetting("MetinStone", "toggleMob", Material.TORCH, "metin.spawn-mob-every-health", "skeleton", "SKELETON"); //
		
		ItemStack zombieCount = AdminGuiItems.metinMobValue("MetinStone", "mobCount", Material.ROTTEN_FLESH, "metin.spawn-mob-every-health", "zombie-count", "ZOMBIE"); 
		ItemStack skeletonCount = AdminGuiItems.metinMobValue("MetinStone", "mobCount", Material.BONE, "metin.spawn-mob-every-health", "skeleton-count", "SKELETON"); 
		
		spawnmobhpmenu.setItem(4, togglefeature);
		spawnmobhpmenu.setItem(1, togglezombie);
		spawnmobhpmenu.setItem(7, toggleskeleton);
		
		spawnmobhpmenu.setItem(12, zombieCount);
		spawnmobhpmenu.setItem(14, skeletonCount);
		
		player.openInventory(spawnmobhpmenu);
		
	}
	public static void healthEvents(Player player) {
		Inventory healthevent = Bukkit.getServer().createInventory(player, 9, (paylasim.color("&dMetinStone-HealthEvents")));
		
		ItemStack sifir = AdminGuiItems.metinHealthEVents(Material.BONE, 0);
		ItemStack yirmibes = AdminGuiItems.metinHealthEVents(Material.BONE, 25);
		ItemStack elli = AdminGuiItems.metinHealthEVents(Material.BONE, 50);
		ItemStack yetmisbes = AdminGuiItems.metinHealthEVents(Material.BONE, 75);
		
		healthevent.setItem(0, sifir);
		
		healthevent.setItem(2, yirmibes);
		
		healthevent.setItem(6, elli);
		
		healthevent.setItem(8, yetmisbes);
		
		player.openInventory(healthevent);
	}
	
}
