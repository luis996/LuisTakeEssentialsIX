package luistakeessentialsix.luistakeessentialsix;

import luistakeessentialsix.luistakeessentialsix.handlers.TorchHandler;
import luistakeessentialsix.luistakeessentialsix.handlers.WallTorchHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LuisTakeEssentialsIX extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("[LuisTakeEssentialsIX] Plugin Enabled");

        // Invokes the torch handlers
        new TorchHandler(this);
        new WallTorchHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[LuisTakeEssentialsIX] Plugin Disabled. If this doesn't occur at server shutdown");
        Bukkit.getLogger().info("[LuisTakeEssentialsIX] Report to Luis64_gamer#6795");
        Bukkit.getLogger().info("[LuisTakeEssentialsIX] If it doesn't work try to update plugin!");
    }
}
