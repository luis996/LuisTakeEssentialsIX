package luistakeessentialsix.luistakeessentialsix.commands;

import luistakeessentialsix.luistakeessentialsix.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoBread implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {

        Player player = (Player) sender;

        Msg.send(player, "[!] Everyone with permission lteix.features.autobread will get 16 breads every connect [!]");
        Msg.send(player, "[!] This feature requires LuckPerms plugin [!]");
        return true;
    }
}
