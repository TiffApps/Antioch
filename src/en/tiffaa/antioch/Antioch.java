package en.tiffaa.antioch;

import org.bukkit.plugin.java.JavaPlugin;

import en.tiffaa.antioch.commands.CommandAntioch;

/*
* Created by Tiffaa the 28/07/2018
* @author Tiffaa
*/

public class Antioch extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("antioch").setExecutor(new CommandAntioch());
		getServer().getPluginManager().registerEvents(new GrenadeListener(), this);
		getServer().getPluginManager().registerEvents(new Spawn_Tnt(), this);
	}
}
