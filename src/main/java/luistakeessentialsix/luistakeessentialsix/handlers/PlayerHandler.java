package luistakeessentialsix.luistakeessentialsix.handlers;

import luistakeessentialsix.luistakeessentialsix.LuisTakeEssentialsIX;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerHandler implements Listener {
    public PlayerHandler(LuisTakeEssentialsIX plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("lteix.features.autobread")) {
            return;
        }

        ItemStack item = new ItemStack(Material.BREAD, 16);
        Inventory inv = player.getInventory();

        inv.addItem(item);
    }
}
