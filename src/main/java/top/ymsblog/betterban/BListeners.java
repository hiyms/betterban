package top.ymsblog.betterban;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;

import java.util.List;
import java.util.Objects;
import java.util.regex.*;

public class BListeners implements Listener {
    private Betterban MainPlugin;
    BListeners(Betterban betterban){
        MainPlugin = betterban;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
//        if(!event.getPlayer().hasPermission("betterban.donotban")) return;
        String playerip = Objects.requireNonNull(event.getPlayer().getAddress()).getAddress().getHostAddress();
        List<String> rebanlist = MainPlugin.getConfig().getStringList("rebanip");
        List<String> whiteuser = MainPlugin.getConfig().getStringList("whiteuser");
        if(whiteuser.contains(event.getPlayer().getName())||!MainPlugin.getConfig().getBoolean("enable")){
            System.out.println("The user is in whitelist or the plugin not run");
            return;
        }
        for(String str : rebanlist){
            if(Pattern.matches(str,playerip)){
                event.getPlayer().kickPlayer("[Better Ban]This ip is banned");
                break;
            }
        }
    }
}
