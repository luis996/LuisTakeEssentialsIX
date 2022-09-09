package luistakeessentialsix.luistakeessentialsix.commands;

import luistakeessentialsix.luistakeessentialsix.LuisTakeEssentialsIX;
import luistakeessentialsix.luistakeessentialsix.Msg;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Lteix implements Listener, CommandExecutor {
    private String invName = "Command Selector";

    public Lteix(LuisTakeEssentialsIX plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(invName)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        if (slot == 11) {
            if (!player.hasPermission("lteix.command.fly")) {
                Msg.send(player, "[LuisTakeEssentialsIX] You don't have permission to do that.");
                player.closeInventory();
                event.setCancelled(true);
                return;
            }
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage("[LuisTakeEssentialsIX] Fly has been disabled.");
            } else {
                player.setAllowFlight(true);
                player.sendMessage("[LuisTakeEssentialsIX] Fly has been enabled.");
            }
            player.closeInventory();
            event.setCancelled(true);
        }
        if (slot == 13) {
            if (!player.hasPermission("lteix.command.heal")) {
                Msg.send(player, "[LuisTakeEssentialsIX] You don't have permission to do that.");
                player.closeInventory();
                event.setCancelled(true);
                return;
            }
            player.setHealth(20);
            player.sendMessage("You have been healed.");
            player.closeInventory();
            event.setCancelled(true);
        }
        if (slot == 15) {
            event.setCancelled(true);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            Msg.send(sender, "Sorry, only players can run this command.");
            return true;
        }

        Player player = (Player) sender;


        Inventory inv = Bukkit.createInventory(player, 9 * 3, invName);

        inv.setItem(11, getItem(new ItemStack(Material.FEATHER), "&9Fly", "&bClick to use", "&aEnables Fly mode in player"));
        inv.setItem(13, getItem(new ItemStack(Material.APPLE), "&9Heal", "&bClick to use", "&aFills the health of the user"));
        inv.setItem(15, getItem(new ItemStack(Material.PAPER), "&9Coming soon!", "&bClick to waste time", "&aDoes nothing"));

        player.openInventory(inv);


        return true;
    }

    private ItemStack getItem(ItemStack item, String name, String ... lore) {
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for (String s : lore) {
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lores);

        item.setItemMeta(meta);
        return item;
    }
}
