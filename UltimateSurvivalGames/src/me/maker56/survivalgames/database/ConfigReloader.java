package me.maker56.survivalgames.database;

import me.maker56.survivalgames.SurvivalGames;
import me.maker56.survivalgames.arena.ArenaManager;
import me.maker56.survivalgames.arena.chest.ChestManager;
import me.maker56.survivalgames.commands.messages.MessageHandler;
import me.maker56.survivalgames.commands.permission.PermissionHandler;
import me.maker56.survivalgames.game.GameManager;
import me.maker56.survivalgames.listener.PlayerListener;

public class ConfigReloader {
	
	public static void reloadConfig() {
		ConfigLoader.reloadConfig();
		PermissionHandler.reinitializeUsePermission();
		ChestManager.reinitializeConfig();
		PlayerListener.allowedCmds = SurvivalGames.instance.getConfig().getStringList("Allowed-Commands");
	}
	
	public static void reloadDatabase() {
		ConfigLoader.reloadDatabase();
		GameManager.reinitializeDatabase();
		ArenaManager.reinitializeDatabase();
	}
	
	public static void reloadSigns() {
		ConfigLoader.reloadSigns();
		SurvivalGames.signManager.reload();
		SurvivalGames.signManager.updateSigns();
	}
	
	public static void reloadMessage() {
		ConfigLoader.reloadMessages();
		MessageHandler.reload();
	}

}
