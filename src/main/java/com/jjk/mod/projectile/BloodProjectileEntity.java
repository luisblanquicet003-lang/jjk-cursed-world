package com.jjk.mod.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class BloodProjectileEntity extends AbstractArrow {
    private float damage = 8.0f;
    private int lifespan = 300;

    public BloodProjectileEntity(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    @Override
    public void tick() {
        super.tick();
        this.lifespan--;
        
        if (this.lifespan <= 0) {
            this.remove(RemovalReason.KILLED);
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        result.getEntity().hurt(net.minecraft.world.damagesource.DamageSource.GENERIC, damage);
        this.remove(RemovalReason.KILLED);
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }
}
