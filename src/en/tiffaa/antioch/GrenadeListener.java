package en.tiffaa.antioch;

import java.util.concurrent.TimeUnit;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class GrenadeListener implements Listener {

	@EventHandler
	public void Grenade_to_throw_event(PlayerInteractEvent event) {
				 
		Player player = event.getPlayer();
		ItemStack item = player.getInventory().getItemInMainHand();
		
		if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK))
			if (item.getType() == Material.EGG && item.getItemMeta().hasEnchant(Enchantment.KNOCKBACK)) {
				player.sendMessage("§cOne...");
				try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				player.sendMessage("§cTwo...");
				try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				player.sendMessage("§cFive !");
				player.launchProjectile(Egg.class);
			}
	}
}

