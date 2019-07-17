package en.tiffaa.antioch;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class Spawn_Tnt implements Listener {
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		
		if (event.getEntity().getType() == EntityType.EGG) {
            Egg egg = (Egg) event.getEntity();
            Player player = (Player) egg.getShooter();
            ItemStack item = player.getInventory().getItemInMainHand();
            
            if (item.getItemMeta().hasEnchant(Enchantment.KNOCKBACK) && item.getType() == Material.EGG) {
            	TNTPrimed tnt = egg.getLocation().getWorld().spawn(egg.getLocation().add(0.5, 1, 0.5), TNTPrimed.class);
            	tnt.setIsIncendiary(true);
            	tnt.setFuseTicks(0);
            	tnt.setYield(50.0f);
            	/* TODO: replace the sound by a custom sound "HAAAALLELUJAH" from Worms (Holy Hand Grenade) */
            	player.playSound(player.getLocation(), Sound.ENTITY_CAT_DEATH, 10, 1);
            }
        }
	}	
}