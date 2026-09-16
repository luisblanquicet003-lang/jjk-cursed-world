package com.jjk.mod.shikigami;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.flying.Parrot;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;

public class NueEntity extends Parrot {
    private float energy;
    private int lifespan;

    public NueEntity(EntityType<? extends Parrot> type, Level level) {
        super(type, level);
        this.energy = 120.0f;
        this.lifespan = 1800;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5D, false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    public void tick() {
        super.tick();
        this.lifespan--;
        
        if (this.lifespan <= 0) {
            this.remove(RemovalReason.KILLED);
        }
    }

    public float getEnergy() {
        return energy;
    }

    public void consumeEnergy(float amount) {
        this.energy = Math.max(0, energy - amount);
    }
}
