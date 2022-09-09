package luistakeessentialsix.luistakeessentialsix.commands;

import luistakeessentialsix.luistakeessentialsix.LuisTakeEssentialsIX;
import luistakeessentialsix.luistakeessentialsix.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            Msg.send(sender, "Sorry, only players can run this command.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("lteix.command.fly")) {
            Msg.send(player, "[LuisTakeEssentialsIX] You don't have permission to do that.");
            return true;
        }
        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage("[LuisTakeEssentialsIX] Fly has been disabled.");
        } else {
            player.setAllowFlight(true);
            player.sendMessage("[LuisTakeEssentialsIX] Fly has been enabled.");
        }
        return true;
    }
}
