package luistakeessentialsix.luistakeessentialsix.handlers;

import luistakeessentialsix.luistakeessentialsix.LuisTakeEssentialsIX;
import luistakeessentialsix.luistakeessentialsix.Msg;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class WallTorchHandler implements Listener {
    public WallTorchHandler(LuisTakeEssentialsIX plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onWallTorchPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();

        if (block.getType() != Material.WALL_TORCH) {
            return;
        }
        event.setCancelled(true);
        Msg.send(event.getPlayer(), "Torches are forbidden because of exploit and, are UGLY!, use glowstone.");
    }
}
