package luistakeessentialsix.luistakeessentialsix.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healthTroll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            String PlayerName = args[0];
            Player target = Bukkit.getServer().getPlayerExact(PlayerName);

            if (target == null) {
                sender.sendMessage("You need to provide a valid online player name!");
            } else {
                // lmao best friend come do pvp
                target.setHealth(1);
            }
        } else {
            sender.sendMessage("You need to send an argument");
            sender.sendMessage("/healthtroll <player>");
        }

        return true;
    }
}
