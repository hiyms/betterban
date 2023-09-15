package top.ymsblog.betterban;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import top.ymsblog.betterban.Betterban;

import java.util.Objects;

public class Commands implements CommandExecutor {
    private Betterban MainPlugin;
    public Commands(Betterban betterban){
        MainPlugin = betterban;
    }
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(Objects.equals(args[0], "reload")){
            if(sender instanceof Player&&!sender.hasPermission("betterban.command.reload")){
                sender.sendMessage("[BetterBan] You do not have this permission!");
                return false;
            }
            MainPlugin.reloadConfig();
            return true;
        } else if (Objects.equals(args[0], "abort")) {
            sender.sendMessage("BetterBan By yms@ymsblog.top\nVersion "+MainPlugin.getVersion());
        }
        return false;
    }

}
