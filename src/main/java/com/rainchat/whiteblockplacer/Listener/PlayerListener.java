package com.rainchat.whiteblockplacer.Listener;

import com.rainchat.whiteblockplacer.FileManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerListener implements Listener {

    private static List<String> blocksBreak;
    private static List<String> blocksPlace;



    public PlayerListener(){
        FileConfiguration file =  FileManager.Files.CONFIG.getFile();
        blocksBreak = new ArrayList<>();
        blocksPlace = new ArrayList<>();
    }

    public static void updateDate(){
        FileConfiguration file =  FileManager.Files.CONFIG.getFile();
        blocksBreak = file.getStringList("BlockBreakList");
        blocksPlace = file.getStringList("BlockPlaceList");
    }




    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if (!e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)){
            return;
        }


        for (String blockName: blocksBreak){
            if (e.getBlock().getType().name().contains(blockName)){
                return;
            }
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if (!e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)){
            return;
        }


        for (String blockName: blocksPlace){
            if (e.getBlock().getType().name().contains(blockName)){
                return;
            }
        }
        e.setCancelled(true);
    }


    @EventHandler
    public void onBucket(PlayerBucketEmptyEvent e) {
        if (!e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)){
            return;
        }
        e.setCancelled(true);

    }
}
