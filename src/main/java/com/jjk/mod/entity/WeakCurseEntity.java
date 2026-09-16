package com.jjk.mod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollingGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class WeakCurseEntity extends Monster {
    private int grade = 4;
    private float cursedEnergy = 20.0f;

    public WeakCurseEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollingGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new net.minecraft.world.entity.ai.goal.NearestAttackableTargetGoal<>(this, net.minecraft.world.entity.player.Player.class, false));
    }

    public int getGrade() {
        return grade;
    }

    public float getCursedEnergy() {
        return cursedEnergy;
    }
}
