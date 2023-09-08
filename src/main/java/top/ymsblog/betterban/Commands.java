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
            if(sender instanceof Player&&!sender.hasPermission("betterban.reload")){
                sender.sendMessage("[BetterBan] You do not have this permission!");
                return true;
            }
            MainPlugin.reloadConfig();
            return true;
        } else if (Objects.equals(args[0], "abort")) {
            sender.sendMessage("BetterBan By yms@ymsblog.top\nVersion "+MainPlugin.getVersion());
        } else if (Objects.equals(args[0], "set")&&args.length==3) {
            if(sender instanceof Player&&!sender.hasPermission("betterban.set")){
                sender.sendMessage("[BetterBan] You do not have this permission!");
                return false;
            }
            if (Objects.equals(args[1],"run")){
                if (Objects.equals(args[2],"true")) {
                    MainPlugin.getConfig().set("run",true);
                    MainPlugin.saveConfig();
                    sender.sendMessage("Start bban!");
                } else if (Objects.equals(args[2],"false")) {
                    MainPlugin.getConfig().set("run",false);
                    MainPlugin.saveConfig();
                    sender.sendMessage("Stop Bban!");
                } else {
                    sender.sendMessage("It have some error ...");
                }
            } else if (Objects.equals(args[1],"add")){
                java.util.List<String> blist =  MainPlugin.getConfig().getStringList("rebanip");
                blist.add(args[2]);
                MainPlugin.getConfig().set("rebanip",blist);
            } else if (Objects.equals(args[1],"remove")){
                java.util.List<String> blist =  MainPlugin.getConfig().getStringList("rebanip");
                blist.remove(args[2]);
                MainPlugin.getConfig().set("rebanip",blist);
            }
            return true;
        } else {
            sender.sendMessage("Can not found this command!");
            return true;
        }
        return true;
    }

}
