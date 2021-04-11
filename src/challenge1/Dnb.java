package challenge1;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Dnb implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		ItemStack b = new ItemStack(Material.BRICKS,  64);
		ItemStack d = new ItemStack(Material.DIAMOND, 16);
		//If the sender is console
		if(sender instanceof ConsoleCommandSender) {
			if(args.length == 0) {
				sender.sendMessage(ChatColor.RED + "You cannot give yourself items!");
				return true;
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
					return true;
				}
				target.getInventory().addItem(d, b);
				sender.sendMessage(ChatColor.GREEN + "You have given " + args[0] + ": 64x Bricks, 16x Diamonds.");
				target.sendMessage("[Console] >> " + ChatColor.GREEN + "has given you: 64x Bricks, 16x Diamonds.");
				return true;
			}
			else {
				sender.sendMessage(ChatColor.RED + "You have entered too many arguments!");
				return true;
			}
		}
		//If the sender is a player
		else if(sender instanceof Player) {
			if(args.length == 0) {
				sender.sendMessage(ChatColor.GREEN + "You have given yourself: 64x Bricks, 16x Diamonds.");
				((Player) sender).getInventory().addItem(d, b);
				return true;
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
					return true;
				}
				target.getInventory().addItem(d, b);
				sender.sendMessage(ChatColor.GREEN + "You have given " + args[0] + ": 64x Bricks, 16x Diamonds.");
				target.sendMessage(ChatColor.GREEN + sender.getName() + " has given you: 64x Bricks, 16x Diamonds.");
				return true;
			}
			else
				sender.sendMessage(ChatColor.RED + "You have entered too many arguments!");
		}
		//How
		else
			sender.sendMessage(ChatColor.RED + "I have no idea how you executed this, please contact a server admin!");
		return true;
	}
	
}
