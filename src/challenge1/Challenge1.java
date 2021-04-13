package challenge1;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class Challenge1 extends JavaPlugin{
	
	public static Challenge1 plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		this.getCommand("greet").setExecutor(new Greet());
		this.getCommand("dnb").setExecutor(new Dnb());
		this.getCommand("tsword").setExecutor(new Tntsword());
		getServer().getPluginManager().registerEvents(new Tntsword(), this);
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Challenge1 has been enabled!");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Challenge1 has been disabled!");
	}
}
