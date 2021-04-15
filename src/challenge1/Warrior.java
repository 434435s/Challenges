package challenge1;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Warrior implements CommandExecutor{
	private static final ItemStack iHelm = new ItemStack(Material.IRON_HELMET, 1);
	private static final ItemStack iChest = new ItemStack(Material.IRON_CHESTPLATE, 1);
	private static final ItemStack iLegs = new ItemStack(Material.IRON_LEGGINGS, 1);
	private static final ItemStack iBoots = new ItemStack(Material.IRON_BOOTS, 1);
	
	static {
		makeHelm();
		makeChest();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length > 0) {
			sender.sendMessage(ChatColor.RED + "You have entered too many arguments!");
			return true;
		}
		if(sender instanceof ConsoleCommandSender || sender instanceof CommandBlock) {
			sender.sendMessage(ChatColor.RED + "You can't use this command!");
			return true;
		}
		Player recipient = (Player)sender;
		recipient.getInventory().addItem(iHelm);
		recipient.getInventory().addItem(iChest);
		return true;
	}
	
	private static void makeHelm() {
		ItemMeta meta = iHelm.getItemMeta();
		
		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();
		UUID uuid3 = UUID.randomUUID();
		
		AttributeModifier armor = new AttributeModifier(uuid1, "armor", 0.25, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
		AttributeModifier kbResist = new AttributeModifier(uuid2, "kbResist", 0.075, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
		AttributeModifier movSPD = new AttributeModifier(uuid3, "movSPD", -0.05, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
		
		meta.setUnbreakable(true);
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Golem's Helmet");
		meta.addEnchant(Enchantment.THORNS, 2, true);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
		meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, kbResist);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, movSPD);
		
		iHelm.setItemMeta(meta);
	}
	
	private static void makeChest() {
		ItemMeta meta = iChest.getItemMeta();
		
		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();
		UUID uuid3 = UUID.randomUUID();
		
		AttributeModifier armor = new AttributeModifier(uuid1, "armor", 0.25, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
		AttributeModifier kbResist = new AttributeModifier(uuid2, "kbResist", 0.075, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
		AttributeModifier movSPD = new AttributeModifier(uuid3, "movSPD", -0.05, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
		
		meta.setUnbreakable(true);
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Golem's Chestplate");
		meta.addEnchant(Enchantment.THORNS, 2, true);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armor);
		meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, kbResist);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, movSPD);
		
		iChest.setItemMeta(meta);
	}
	
}
