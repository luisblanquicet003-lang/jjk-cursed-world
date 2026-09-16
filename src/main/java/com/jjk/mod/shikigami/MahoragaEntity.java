package com.jjk.mod.shikigami;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.AbstractVillager;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;

public class MahoragaEntity extends AbstractVillager {
    private float adaptationProgress;
    private float maxAdaptation = 100.0f;
    private float energy;
    private int lifespan;

    public MahoragaEntity(EntityType<? extends AbstractVillager> type, Level level) {
        super(type, level);
        this.energy = 500.0f;
        this.lifespan = 3600;
        this.adaptationProgress = 0.0f;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.8D, false));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }

    @Override
    public void tick() {
        super.tick();
        this.lifespan--;
        
        if (this.lifespan <= 0) {
            this.remove(RemovalReason.KILLED);
        }
    }

    public void addAdaptation(float amount) {
        this.adaptationProgress = Math.min(maxAdaptation, adaptationProgress + amount);
    }

    public float getAdaptationProgress() {
        return adaptationProgress;
    }

    public boolean isFullyAdapted() {
        return adaptationProgress >= maxAdaptation;
    }

    public float getEnergy() {
        return energy;
    }
}
