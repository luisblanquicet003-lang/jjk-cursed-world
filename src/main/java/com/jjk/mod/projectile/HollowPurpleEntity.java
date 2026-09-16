package com.jjk.mod.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;

public class HollowPurpleEntity extends AbstractArrow {
    private float damage = 25.0f;
    private int radius = 10;
    private int lifespan = 200;

    public HollowPurpleEntity(EntityType<? extends AbstractArrow> type, Level level) {
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
        this.explode();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.explode();
    }

    private void explode() {
        if (!this.level.isClientSide) {
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), radius, false, net.minecraft.world.level.block.Blocks.VOID_AIR.defaultBlockState());
        }
        this.remove(RemovalReason.KILLED);
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }
}
