package challenge1;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;


public class Tntsword implements CommandExecutor,Listener {
	
	private static final ItemStack tntsword = new ItemStack(Material.DIAMOND_SWORD, 1);
	//Key for comparison in later method
	private static final NamespacedKey key = new NamespacedKey(Challenge1.plugin, "434435s");
	
	static {
		//Instantiating meta for tntsword (above).
		ItemMeta meta = tntsword.getItemMeta();
		
		//UUIDs for the coming AttributeModifiers.
		UUID uuidDMG = UUID.randomUUID();
		UUID uuidHP = UUID.randomUUID();
		UUID uuidSPD = UUID.randomUUID();
		
		
		//Setting up AttributeModifiers to apply dmg, hp and spd, only when in hand by 10, 10 and 0.0675 respectively.
		AttributeModifier plus10DMG = new AttributeModifier(uuidDMG ,"10dmg", 10.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier plus10HP = new AttributeModifier(uuidHP ,"10hp", 10.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier plusSPD = new AttributeModifier(uuidSPD, "10spd", 0.0675, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		
		//Creating lore ArrayList.
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Blow stuff up!");
		meta.setLore(lore);
		
		//Changing the meta instantiated before to change tntsword's name, making it unbreakable, and adding dmg, hp, and spd using the before AttributeModifiers.
		meta.setDisplayName(ChatColor.DARK_RED + "TNT" + ChatColor.GRAY + "Sword");
		meta.setUnbreakable(true);
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, plus10DMG);
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, plus10HP);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, plusSPD);
		meta.getPersistentDataContainer().set(key, PersistentDataType.DOUBLE, Math.E);
		
		//Setting the tntsword meta to the modified meta.
		tntsword.setItemMeta(meta);
		
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerUse(PlayerInteractEvent useEvent) {
		Player user = useEvent.getPlayer();
		if(useEvent.getAction().equals(Action.RIGHT_CLICK_AIR) || useEvent.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			PersistentDataContainer handContainer = user.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer();
			if(handContainer.has(key, PersistentDataType.DOUBLE)) {
				TNTPrimed tnt = user.getWorld().spawn(user.getLocation(), TNTPrimed.class);
				for(int i = 0; i < 5; i++)
					tnt.setFuseTicks(0);
					user.getWorld().spawnEntity(user.getLocation(), tnt.getType());
				}
		}
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//Check if the sender is a player, and if there are no arguments
		if(sender instanceof Player && args.length < 1) {
			//Cast the sender as a player, now "recipient", and give them the tntsword set up earlier, return true to end.
			Player recipient = (Player)sender;
			recipient.getInventory().addItem(tntsword.clone());
			return true;
		}
		//Check if the sender is Console, if so send a message that console can't get the item, return true to end.
		else if(sender instanceof ConsoleCommandSender) {
			sender.sendMessage(ChatColor.RED + "You can't get this item!");
			return true;
		}
		//Will activate when the arguments are 1 or greater, send the sender this, return true to end.
			sender.sendMessage(ChatColor.RED + "You have entered too many arguments!");
		return true;
	}
}
