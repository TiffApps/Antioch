package en.tiffaa.antioch.commands;

import java.util.Arrays;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandAntioch implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if (sender instanceof Player) {
			
			Player player = (Player)sender;

			if (cmd.getName().equalsIgnoreCase("antioch")) {
				
				player.getInventory().clear();
				
				ItemStack grenade = new ItemStack(Material.EGG);
				
				ItemMeta customM = grenade.getItemMeta();
				customM.setDisplayName("The Holy Hand Grenade of Antioch");
				customM.setLore(Arrays.asList("First shalt thou take out the Holy Pin.",
						"Then, shalt thou count to three. No more. No less.",
						"Three shalt be the number thou shalt count,",
						"and the number of the counting shall be three.",
						"Four shalt thou not count, neither count thou two,",
						"excepting that thou then proceed to three.",
						"Five is right out. Once at the number three,",
						"being the third number be reached,",
						"then, lobbest thou thy Holy Hand Grenade of Antioch",
						"towards thy foe, who, being naughty in My sight,",
						"shall snuff it."));
				customM.addEnchant(Enchantment.KNOCKBACK, 2, true);
				customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				grenade.setItemMeta(customM);
				player.getInventory().setItemInMainHand(grenade);

				player.updateInventory();
				
				return true;
			}
		}	
		return false;
	}
}
