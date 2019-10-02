package me.geik.essas.acik;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import me.geik.essas.Main;
import me.geik.essas.chatevent.chatEvent;


public class paylasim {
	
	public static String color(String yazirengi){return ChatColor.translateAlternateColorCodes('&', yazirengi);}
	
	public static String version = Main.instance.getDescription().getVersion();
	public static File c = new File("plugins/Essas/config.yml");
  	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(c);
	public static String langName = cfg.getString("lang");
	
	public static File f = new File("plugins/Essas", langName + ".yml");
  	public static FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
  	public static File g = new File("plugins/Essas", langName + "-Gui.yml");
  	public static FileConfiguration gui = YamlConfiguration.loadConfiguration(g);
  	
	public static String pluginPrefix = fc.getString("Plugin.Prefix");
	
	/*public static void langtranslate() {
		if (LangCreator.LangChecker().substring(LangCreator.LangChecker().length() -1) == "S") {
			langName = LangCreator.LangChecker().substring(0, LangCreator.LangChecker().length() -1);
			f = new File(Main.instance.getClass().getResource(langName + ".yml").getFile());
		}
	}*/
	
	public static void noPerm(Player sender) {sender.sendMessage(color(pluginPrefix + " " + fc.getString("Plugin.noPerm")));}
	public static void noConsole(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.consoleCant")));}
	public static void voidTeleported(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("VoidtoSpawn.teleported")));}
	public static void voidSpawnSaved(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("VoidtoSpawn.spawnSaved")));}
	public static void adakityeniAlan(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("pKit.claimedFirstTime")));}
	public static void alreadyClaimedkit(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("pKit.alreadyClaimed")));}
	public static void pkitdisabled(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("pKit.disabled")));}
	public static void pkitdebug(Player player) {Bukkit.getServer().getConsoleSender().sendMessage(color(pluginPrefix + " " +  
			fc.getString("pKit.debugConsole").replace("%player%", player.getName())));}
	public static void wrongcommandAE(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("autoEvent.wrongCommand")));}
	public static void AEcommandExecuted(CommandSender sender, String arx) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("autoEvent.commandExecuted").replace("%n", arx)));}
	public static void metinStoneBroadcast() {Bukkit.getServer().broadcastMessage(color(pluginPrefix + " " +  fc.getString("metinStone.respawnedAgainBC")));}
	public static void metinCordSaved(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("metinStone.commandSet")));}
	public static void metincmdError(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("metinStone.errorStoneLoc")));}
	public static void noOneCompletedChatEvent() {Bukkit.broadcastMessage(color(pluginPrefix + " " +  fc.getString("chatEvent.noOneCompleted")));}
	public static void youhaveTime(String sec) {Bukkit.broadcastMessage(color(pluginPrefix + " " +  fc.getString("chatEvent.eventGame").replace("%sec%", sec)
			.replace("%target%", chatEvent.hedef)));}
	public static void playerHasCompletedChatEvent(String sec, Player player) {Bukkit.broadcastMessage(color(pluginPrefix + " " +  fc.getString("chatEvent.playerCompleted").replace("%sec%", sec)
			.replace("%player%", player.getName())));}
	public static void updateAvailable(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Update.updateAvailable").replace("%pl", pluginPrefix)));}
	public static void latestVersion(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Update.latestVersion").replace("%pl", pluginPrefix)));}
	public static void chatClearedBy(Player sender, CommandSender S) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Chat.clearedBy").replace("%player%", S.getName())));}
	public static void chatClearedByDEBUG(ConsoleCommandSender sender, CommandSender S) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Chat.clearedBy").replace("%player%", S.getName())));}
	public static void chatClearedByCONSOLE(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Chat.clearedBy").replace("%player%", "CONSOLE")));}
	public static void clearedSelf(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Chat.clearedSelf")));}
	public static void playerOffline(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.playerOffline")));}
	public static void youhaveCleared(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Chat.clearedPlayer").replace("%player%", sender.getName())));}
	public static void clearWrong(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Chat.wrongUsage")));}
	public static void chatMuted(CommandSender sender) {Bukkit.broadcastMessage(color(pluginPrefix + " " +  fc.getString("Chat.chatMuted").replace("%player%", sender.getName())));}
	public static void chatMutedCONSOLE() {Bukkit.broadcastMessage(color(pluginPrefix + " " +  fc.getString("Chat.chatMuted").replace("%player%", "CONSOLE")));}
	public static void chatunMuted(CommandSender sender) {Bukkit.broadcastMessage(color(pluginPrefix + " " +  fc.getString("Chat.chatUnmuted").replace("%player%", sender.getName())));}
	public static void chatunMutedCONSOLE() {Bukkit.broadcastMessage(color(pluginPrefix + " " +  fc.getString("Chat.chatUnmuted").replace("%player%", "CONSOLE")));}
	public static void chatUnavailable(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Chat.chatUnavailable")));}
	public static void giveallExecuted(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.execommandAll")));}
	public static void chatEventAgainRepet(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("chatEvent.startedAgain")));}
	public static void helpessas(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.commandHelp")));}
	public static void helpcmd1(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.help1")));}
	public static void helpcmd2(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.help2")));}
	public static void helpcmd3(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.help3")));}
	public static void chateventAlreadyRunningevent(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("chatEvent.alreadyRunnig")));}
	public static void metinspawnedBYCOMMAND(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("metinStone.spawnedAgain")));}
	public static void metinAlreadyRunning(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("metinStone.alreadySpawned")));}
	public static void metinTasNo(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("metinStone.noStoneLoc")));}
	public static void reloadCmd(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.reload")));}
	public static void metinDisabled(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("metinStone.disabled")));}
	public static void chatEventDisabled(CommandSender sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("chatEvent.disabled")));}
	public static void confirmationDel(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.guiConfirm")));}
	public static void confirmExpire(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.guiConfirmExp")));}
	public static void voidWorldREmoved(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("VoidtoSpawn.guiWorldRemoved")));}
	public static void cancelEntry(Player sender) {sender.sendMessage(color(pluginPrefix + " " +  fc.getString("Plugin.cancelVarEntry").replace("%cncl%", cfg.getString("cancelMethod"))));}
	public static void debugSomethng(String message) {
		if (paylasim.cfg.getBoolean("debug-mode") == true) 
		Bukkit.getServer().getConsoleSender().sendMessage(paylasim.color("&f&lDEBUG "  + message));}
	
	
	

	
	
	
	
	

}
