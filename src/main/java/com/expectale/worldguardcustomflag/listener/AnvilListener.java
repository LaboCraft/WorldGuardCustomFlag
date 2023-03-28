package com.expectale.worldguardcustomflag.listener;

import com.destroystokyo.paper.event.block.AnvilDamagedEvent;
import com.expectale.worldguardcustomflag.WorldGuardCustomFlagManager;
import com.sk89q.worldguard.protection.flags.StateFlag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AnvilListener implements Listener {

    @EventHandler
    public void onBlockDamageEvent(AnvilDamagedEvent event) {

        if (WorldGuardCustomFlagManager.testState(event.getInventory().getLocation(), (Player) event.getView().getPlayer(), WorldGuardCustomFlagManager.ANVIL_DAMAGE) == StateFlag.State.DENY) {
            event.setCancelled(true);
        }
    }
}
