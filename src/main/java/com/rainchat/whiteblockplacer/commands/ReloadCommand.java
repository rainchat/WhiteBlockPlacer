package com.rainchat.whiteblockplacer.commands;

import com.rainchat.whiteblockplacer.FileManager;
import com.rainchat.whiteblockplacer.Listener.PlayerListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        PlayerListener.updateDate();
        FileManager.getInstance().reloadAllFiles();
        sender.sendMessage("Конфиг обновлен");
        return true;
    }
}
