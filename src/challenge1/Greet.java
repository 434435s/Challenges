package challenge1;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Greet implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0)
			sender.sendMessage("[Console] >> " + ChatColor.GREEN + "Hello! How are you? :)");
		else if(args.length == 1) {
			Player target = Bukkit.getPlayerExact(args[0]);
			if(target == null)
				sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
			else if(sender instanceof ConsoleCommandSender)
				target.sendMessage("[Console] >> " + ChatColor.GREEN + "says: Hello! How are you? :)");
			else {
				target.sendMessage(ChatColor.GREEN + sender.getName() +" says: Hello! How are you? :)");
				sender.sendMessage(ChatColor.GREEN + "You have greeted " + args[0] + "!");
			}
		}
		else
			sender.sendMessage(ChatColor.RED + "You have entered too many arguments!");
		return true;
	}

}
