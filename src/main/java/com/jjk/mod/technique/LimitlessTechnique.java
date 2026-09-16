package com.jjk.mod.technique;

import net.minecraft.world.entity.player.Player;

public class LimitlessTechnique extends CursedTechnique {
    private boolean infinityActive;
    private int infinityEnergyCost;

    public LimitlessTechnique() {
        super("limitless", "Limitless", 15.0f, 100);
        this.infinityActive = false;
        this.infinityEnergyCost = 2;
    }

    @Override
    public void onActivate(Object user) {
        if (user instanceof Player player) {
            infinityActive = true;
            isActive = true;
        }
    }

    @Override
    public void onUpdate(Object user) {
        if (user instanceof Player player && infinityActive) {
        }
    }

    @Override
    public void onDeactivate(Object user) {
        if (user instanceof Player player) {
            infinityActive = false;
            isActive = false;
            resetCooldown();
        }
    }

    public boolean isInfinityActive() {
        return infinityActive;
    }

    public int getInfinityEnergyCost() {
        return infinityEnergyCost;
    }
}
