package com.jjk.mod.technique;

import net.minecraft.world.entity.player.Player;

public class BloodManipulationTechnique extends CursedTechnique {
    private float bloodReserve;
    private float maxBloodReserve;

    public BloodManipulationTechnique() {
        super("blood_manipulation", "Blood Manipulation", 12.0f, 60);
        this.bloodReserve = 50.0f;
        this.maxBloodReserve = 100.0f;
    }

    @Override
    public void onActivate(Object user) {
        if (user instanceof Player player) {
            isActive = true;
        }
    }

    @Override
    public void onUpdate(Object user) {
    }

    @Override
    public void onDeactivate(Object user) {
        isActive = false;
    }

    public float getBloodReserve() {
        return bloodReserve;
    }

    public void consumeBlood(float amount) {
        this.bloodReserve = Math.max(0, bloodReserve - amount);
    }

    public void addBlood(float amount) {
        this.bloodReserve = Math.min(maxBloodReserve, bloodReserve + amount);
    }
}
