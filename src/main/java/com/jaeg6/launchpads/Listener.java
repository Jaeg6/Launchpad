package com.jaeg6.launchpads;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

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
        {
            //check block is a gold pressure plate
            Block b = event.getTo().getBlock().getLocation().getBlock();
            if(b.getBlockData().getMaterial().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE))
            {
                //review config file to see if this specific gold pressure plate
                Vector vector = main.isLp(b.getLocation());
                if(!(vector == null))
                {
                    //is a launchpad
                    //launch player with retrieved properties
                    p.setVelocity(vector);
                }
                return;
            }
        }

        return;
    }
}
