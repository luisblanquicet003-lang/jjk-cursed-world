package com.jjk.mod.technique;

import net.minecraft.world.entity.player.Player;

public class TenShadowsTechnique extends CursedTechnique {
    private int maxShikigami = 10;
    private int activeShikigami = 0;

    public TenShadowsTechnique() {
        super("ten_shadows", "Ten Shadows Technique", 20.0f, 80);
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

    public int getMaxShikigami() {
        return maxShikigami;
    }

    public int getActiveShikigami() {
        return activeShikigami;
    }
}
