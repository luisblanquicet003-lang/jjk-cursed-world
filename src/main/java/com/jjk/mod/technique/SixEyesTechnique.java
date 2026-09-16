package com.jjk.mod.technique;

import net.minecraft.world.entity.player.Player;

public class SixEyesTechnique extends CursedTechnique {
    private boolean sightActive;
    private double energyReductionMultiplier = 0.7;

    public SixEyesTechnique() {
        super("six_eyes", "Six Eyes", 0.0f, 0);
        this.sightActive = false;
    }

    @Override
    public void onActivate(Object user) {
        if (user instanceof Player player) {
            sightActive = true;
            isActive = true;
        }
    }

    @Override
    public void onUpdate(Object user) {
    }

    @Override
    public void onDeactivate(Object user) {
        sightActive = false;
        isActive = false;
    }

    public boolean isSightActive() {
        return sightActive;
    }

    public double getEnergyReductionMultiplier() {
        return energyReductionMultiplier;
    }
}
