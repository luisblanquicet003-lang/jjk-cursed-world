package com.jjk.mod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class JJKBlocks {
    public static class CursedStone extends Block {
        public CursedStone() {
            super(Properties.of(Material.STONE)
                    .strength(2.0f, 6.0f)
                    .sound(SoundType.STONE));
        }
    }

    public static class CursedLantern extends Block {
        public CursedLantern() {
            super(Properties.of(Material.DECORATION)
                    .strength(0.3f)
                    .sound(SoundType.GLASS)
                    .lightLevel(state -> 12));
        }
    }
}
