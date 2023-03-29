package com.expectale.worldguardcustomflag.listener;

import com.expectale.worldguardcustomflag.WorldGuardCustomFlagManager;
import com.sk89q.worldguard.protection.flags.StateFlag;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashSet;

public class DoorListener implements Listener {
    private final HashSet<Material> doors = new HashSet<>();

    public DoorListener() {
        super();
        for (Material material : Material.values()) {
            if (material.toString().toUpperCase().contains("_DOOR") || material.toString().toUpperCase().contains("_TRAPDOOR") || material.toString().toUpperCase().contains("_FENCE_GATE")) {
                doors.add(material);
            }
        }
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();

        if (block != null && !WorldGuardCustomFlagManager.canBypass(block.getLocation(), event.getPlayer()) && WorldGuardCustomFlagManager.testState(block.getLocation(), event.getPlayer(), WorldGuardCustomFlagManager.OPEN_DOOR) == StateFlag.State.DENY) {
            if (doors.contains(block.getType())) {
                event.setCancelled(true);
            }
        }
    }
}
