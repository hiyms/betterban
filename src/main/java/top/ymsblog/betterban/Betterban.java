package top.ymsblog.betterban;

import org.bukkit.plugin.java.JavaPlugin;

import top.ymsblog.betterban.Commands;
import top.ymsblog.betterban.BListeners;

public final class Betterban extends JavaPlugin {
    private static String p_ver;

    static {
        p_ver = "1.1.1";
    }

    @Override
    public void onEnable() {
        this.getCommand("bban").setExecutor(new Commands(this));
        getServer().getPluginManager().registerEvents(new BListeners(this), this);
        this.saveDefaultConfig();
        // Plugin startup logic

    }
    public String getVersion(){
        return p_ver;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
