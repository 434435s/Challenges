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
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Warrior implements CommandExecutor{
	private static final ItemStack iHelm = new ItemStack(Material.IRON_HELMET, 1);
	private static final ItemStack iChest = new ItemStack(Material.IRON_CHESTPLATE, 1);
	private static final ItemStack iLegs = new ItemStack(Material.IRON_LEGGINGS, 1);
	private static final ItemStack iBoots = new ItemStack(Material.IRON_BOOTS, 1);
	private static final ItemStack iSword = new ItemStack(Material.IRON_SWORD, 1);
	private static final ItemStack iShield = new ItemStack(Material.IRON_BARS, 1);
	
	static {
		makeHelm();
		makeChest();
		makeLegs();
		makeBoots();
		makeSword();
		makeShield();
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
		recipient.getInventory().addItem(iLegs);
		recipient.getInventory().addItem(iBoots);
		recipient.getInventory().addItem(iSword);
		recipient.getInventory().addItem(iShield);
		return true;
	}
	
	private static void makeHelm() {
		ItemMeta meta = iHelm.getItemMeta();

		UUID help = UUID.randomUUID();
		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();
		UUID uuid3 = UUID.randomUUID();
		UUID uuid4 = UUID.randomUUID();
		
		AttributeModifier percentArmor = new AttributeModifier(uuid1, "percentArmor", 0.25, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
		AttributeModifier kbResist = new AttributeModifier(uuid2, "kbResist", 0.075, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
		AttributeModifier movSPD = new AttributeModifier(uuid3, "movSPD", -0.045, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HEAD);
		AttributeModifier flatArmor = new AttributeModifier(uuid4, "flatArmor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		
		meta.setUnbreakable(true);
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Golem's Helmet");
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, percentArmor);
		meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, kbResist);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, movSPD);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, flatArmor);
		
		iHelm.setItemMeta(meta);
	}
	
	private static void makeChest() {
		ItemMeta meta = iChest.getItemMeta();
		
		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();
		UUID uuid3 = UUID.randomUUID();
		UUID uuid4 = UUID.randomUUID();
		
		AttributeModifier percentArmor = new AttributeModifier(uuid1, "percentArmor", 0.25, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
		AttributeModifier kbResist = new AttributeModifier(uuid2, "kbResist", 0.075, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
		AttributeModifier movSPD = new AttributeModifier(uuid3, "movSPD", -0.06, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.CHEST);
		AttributeModifier flatArmor= new AttributeModifier(uuid4, "flatArmor", 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
		
		meta.setUnbreakable(true);
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Golem's Chestplate");
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, percentArmor);
		meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, kbResist);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, movSPD);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, flatArmor);
		
		iChest.setItemMeta(meta);
	}

	private static void makeLegs() {
		ItemMeta meta = iLegs.getItemMeta();

		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();
		UUID uuid3 = UUID.randomUUID();
		UUID uuid4 = UUID.randomUUID();

		AttributeModifier percentArmor = new AttributeModifier(uuid1, "percentArmor", 0.25, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
		AttributeModifier kbResist = new AttributeModifier(uuid2, "kbResist", 0.075, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
		AttributeModifier movSPD = new AttributeModifier(uuid3, "movSPD", -0.055, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.LEGS);
		AttributeModifier flatArmor= new AttributeModifier(uuid4, "flatArmor", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);

		meta.setUnbreakable(true);
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Golem's Leggings");
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, percentArmor);
		meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, kbResist);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, movSPD);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, flatArmor);

		iLegs.setItemMeta(meta);
	}

	private static void makeBoots() {
		ItemMeta meta = iBoots.getItemMeta();

		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();
		UUID uuid3 = UUID.randomUUID();
		UUID uuid4 = UUID.randomUUID();

		AttributeModifier percentArmor = new AttributeModifier(uuid1, "percentArmor", 0.25, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
		AttributeModifier kbResist = new AttributeModifier(uuid2, "kbResist", 0.075, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
		AttributeModifier movSPD = new AttributeModifier(uuid3, "movSPD", -0.04, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
		AttributeModifier flatArmor= new AttributeModifier(uuid4, "flatArmor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);

		meta.setUnbreakable(true);
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Golem's Boots");
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, percentArmor);
		meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, kbResist);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, movSPD);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, flatArmor);

		iBoots.setItemMeta(meta);
	}

	private static void makeSword() {
		ItemMeta meta = iSword.getItemMeta();

		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();

		AttributeModifier AD = new AttributeModifier(uuid1, "AD", 12, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier atkSPD = new AttributeModifier(uuid2, "atkSPD", -0.75, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);

		meta.setUnbreakable(true);
		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Golem's Sword");
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AD);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, atkSPD);

		iSword.setItemMeta(meta);
	}

	private static void makeShield() {
		ItemMeta meta = iShield.getItemMeta();

		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();
		UUID uuid3 = UUID.randomUUID();
		UUID uuid4 = UUID.randomUUID();

		AttributeModifier flatArmor = new AttributeModifier(uuid1, "flatArmor", 7.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
		AttributeModifier handAD = new AttributeModifier(uuid2, "handAD", 20, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier handAtkSPD = new AttributeModifier(uuid3, "handAtkSPD", -0.9, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);
		AttributeModifier handKb = new AttributeModifier(uuid4, "handKb", 0.5, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.HAND);

		meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Golem's Bulwark");
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, flatArmor);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, handAtkSPD);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, handAD);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, handKb);

		iShield.setItemMeta(meta);
	}
}
