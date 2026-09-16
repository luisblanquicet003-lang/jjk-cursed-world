package com.jjk.mod.shikigami;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;

public class DivineDogEntity extends WaterAnimal {
    private int summoner;
    private float energy;
    private int lifespan;

    public DivineDogEntity(EntityType<? extends WaterAnimal> type, Level level) {
        super(type, level);
        this.energy = 100.0f;
        this.lifespan = 1200;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, false));
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

    public float getEnergy() {
        return energy;
    }

    public void consumeEnergy(float amount) {
        this.energy = Math.max(0, energy - amount);
        if (energy <= 0) {
            this.remove(RemovalReason.KILLED);
        }
    }
}
