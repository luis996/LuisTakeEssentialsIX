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

        if (!event.getPlayer().hasPermission("lteix.bypass.torch")) {
            block.setType(Material.GLOWSTONE);
            Msg.send(event.getPlayer(), "Torch disabled due to headless piston exploit.");
        }
    }
}
