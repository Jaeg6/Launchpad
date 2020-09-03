package com.jaeg6.launchpads;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class Listener implements org.bukkit.event.Listener {

    private Main main;

    public Listener(Main plugin)
    {
        main = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        //check that player has moved a block
        if(event.getFrom().getBlockX() == event.getTo().getBlockX() && event.getFrom().getBlockY() == event.getTo().getBlockY() && event.getFrom().getBlockZ() == event.getTo().getBlockZ())
        {
            //player has not moved
            return;
        }

        Player p = event.getPlayer();
        //check that player is in spawn world
        if(p.getWorld().getName().equals("world_nether"))
        {
            //check block is a gold pressure plate
            Block b = event.getTo().getBlock().getLocation().add(0, 1, 0).getBlock();
            if(b.getBlockData().getMaterial().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE))
            {
                //review config file to see if this specific gold pressure plate
                p.sendMessage("You're standing on a gold pressure plate!");
                return;
            }
        }

        return;
    }
}
