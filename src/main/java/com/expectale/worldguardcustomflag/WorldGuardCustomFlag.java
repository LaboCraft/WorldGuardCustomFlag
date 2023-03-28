package com.expectale.worldguardcustomflag;

import com.expectale.worldguardcustomflag.listener.AnvilListener;
import com.expectale.worldguardcustomflag.listener.DoorListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldGuardCustomFlag extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AnvilListener(), this);
        getServer().getPluginManager().registerEvents(new DoorListener(), this);
        getLogger().info("WorldGuardCustomFlag is enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("WorldGuardCustomFlag is disabled");
    }

    @Override
    public void onLoad() {
        WorldGuardCustomFlagManager.init();
    }
}
