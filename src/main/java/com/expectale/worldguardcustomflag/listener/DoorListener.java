package com.expectale.worldguardcustomflag.listener;

import com.expectale.worldguardcustomflag.WorldGuardCustomFlagManager;
import com.sk89q.worldguard.protection.flags.StateFlag;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DoorListener implements Listener {

    private final Set<Material> doors = new HashSet<>(Arrays.asList(    Material.ACACIA_DOOR, Material.BIRCH_DOOR, Material.CRIMSON_DOOR, Material.JUNGLE_DOOR, Material.DARK_OAK_DOOR, Material.OAK_DOOR, Material.SPRUCE_DOOR, Material.WARPED_DOOR,
                                                                        Material.ACACIA_TRAPDOOR, Material.BIRCH_TRAPDOOR, Material.CRIMSON_TRAPDOOR, Material.JUNGLE_TRAPDOOR, Material.DARK_OAK_TRAPDOOR, Material.OAK_TRAPDOOR, Material.SPRUCE_TRAPDOOR, Material.WARPED_TRAPDOOR,
                                                                        Material.ACACIA_FENCE_GATE, Material.BIRCH_FENCE_GATE, Material.CRIMSON_FENCE_GATE, Material.JUNGLE_FENCE_GATE, Material.DARK_OAK_FENCE_GATE, Material.OAK_FENCE_GATE, Material.SPRUCE_FENCE_GATE, Material.WARPED_FENCE_GATE));

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
