package com.rainchat.whiteblockplacer;

import com.rainchat.whiteblockplacer.Listener.PlayerListener;
import com.rainchat.whiteblockplacer.commands.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class WhiteBlockPlacer extends JavaPlugin {

    FileManager fileManager = FileManager.getInstance();

    @Override
    public void onEnable() {

        fileManager.logInfo(true)
                .setup(this);

        getServer().getPluginManager().registerEvents(new PlayerListener(),this);
        PlayerListener.updateDate();
        getCommand("whiteplace").setExecutor(new ReloadCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
