package com.jjk.mod.curse;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class SpecialGradeCurseEntity extends Monster {
    private int grade = 5; // Special Grade
    private float cursedEnergy = 500.0f;
    private float health = 200.0f;

    public SpecialGradeCurseEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.setHealth(health);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new net.minecraft.world.entity.ai.goal.MeleeAttackGoal(this, 1.5D, false));
        this.goalSelector.addGoal(2, new net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollingGoal(this, 1.2D));
        this.goalSelector.addGoal(3, new net.minecraft.world.entity.ai.goal.RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new net.minecraft.world.entity.ai.goal.NearestAttackableTargetGoal<>(this, net.minecraft.world.entity.player.Player.class, false));
    }

    public int getGrade() {
        return grade;
    }

    public float getCursedEnergy() {
        return cursedEnergy;
    }
}
