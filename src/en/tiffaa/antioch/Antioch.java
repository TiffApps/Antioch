package en.tiffaa.antioch;

import org.bukkit.plugin.java.JavaPlugin;

import en.tiffaa.antioch.commands.CommandAntioch;

public class Antioch extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("antioch").setExecutor(new CommandAntioch());
		getServer().getPluginManager().registerEvents(new GrenadeListener(), this);
		getServer().getPluginManager().registerEvents(new Spawn_Tnt(), this);
	}
}