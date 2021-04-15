package challenge1;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Dnb implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final ItemStack bricks64 = new ItemStack(Material.BRICKS,  64);
		final ItemStack diamonds16 = new ItemStack(Material.DIAMOND, 16);
		if(args.length == 0 && sender instanceof Player) {
			((Player)sender).getInventory().addItem(bricks64, diamonds16);
			sender.sendMessage(ChatColor.GREEN + "You have given yourself: 64x Bricks, 16x Diamonds.");
			return true;
		}
		if(args.length == 0) {
			sender.sendMessage(ChatColor.RED + "You cannot give yourself items!");
			return true;
		}
		if(args.length == 1 && Bukkit.getPlayerExact(args[0]) != null) {
			Player recipient = Bukkit.getPlayerExact(args[0]);
			recipient.getInventory().addItem(diamonds16, bricks64);
			sender.sendMessage(ChatColor.GREEN + "You have given " + args[0] + ": 64x Bricks, 16x Diamonds.");
			recipient.sendMessage(ChatColor.GREEN + sender.getName() + " has given you: 64x Bricks, 16x Diamonds.");
			return true;
		}
		if(args.length > 1)
			sender.sendMessage(ChatColor.RED + "You have entered too many arguments!");
		if(Bukkit.getPlayerExact(args[0]) == null) {
			sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
			return true;
		}
		return true;
	}
	
}
