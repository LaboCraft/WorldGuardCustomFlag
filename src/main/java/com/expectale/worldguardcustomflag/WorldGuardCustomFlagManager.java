package com.expectale.worldguardcustomflag;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.StateFlag;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WorldGuardCustomFlagManager {
    public static StateFlag ANVIL_DAMAGE = new StateFlag("anvil-damage", true);
    public static StateFlag OPEN_DOOR = new StateFlag("open-door", true);

    public static void init() {
        WorldGuard.getInstance().getFlagRegistry().register(ANVIL_DAMAGE);
        WorldGuard.getInstance().getFlagRegistry().register(OPEN_DOOR);
    }

    public static StateFlag.State testState(Location location, Player player, StateFlag flag) {
        LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(player);
        com.sk89q.worldedit.util.Location wrappedLocation = BukkitAdapter.adapt(location);
        return WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery().queryState(wrappedLocation, localPlayer, flag);
    }

    public static boolean canBypass(Location location, Player player) {
        return WorldGuard.getInstance()
                .getPlatform()
                .getSessionManager()
                .hasBypass(WorldGuardPlugin.inst().wrapPlayer(player), BukkitAdapter.adapt(location.getWorld()));
    }
}
