package luistakeessentialsix.luistakeessentialsix.commands;

import luistakeessentialsix.luistakeessentialsix.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            Msg.send(sender,"Sorry, only players can run this command");
            return true;
        }

        Player player = (Player) sender;
        if (player.hasPermission("lteix.command.heal")) {
            player.setHealth(20);
            return true;
        }
        return true;
    }
}
