package luistakeessentialsix.luistakeessentialsix.handlers;

import luistakeessentialsix.luistakeessentialsix.LuisTakeEssentialsIX;
import luistakeessentialsix.luistakeessentialsix.Msg;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class TorchHandler implements Listener {
    public TorchHandler(LuisTakeEssentialsIX plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTorchPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        if (block.getType() != Material.TORCH) {
            return;
        }

        block.setType(Material.GLOWSTONE);
        Msg.send(event.getPlayer(), "Torch disabled due to headless piston exploit.");
    }
}
