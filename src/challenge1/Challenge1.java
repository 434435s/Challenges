package challenge1;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Challenge1 extends JavaPlugin{
	
	@Override
	public void onEnable() {
		this.getCommand("greet").setExecutor(new Greet());
		this.getCommand("dnb").setExecutor(new Dnb());
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Challenge1 has been enabled!");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Challenge1 has been disabled!");
	}
}
