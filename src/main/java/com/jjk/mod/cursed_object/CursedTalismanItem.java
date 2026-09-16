package com.jjk.mod.cursed_object;

import net.minecraft.world.item.Item;

public class CursedTalismanItem extends Item {
    private int energyBoost = 5;
    private int rarity = 2;

    public CursedTalismanItem(Properties properties) {
        super(properties);
    }

    public int getEnergyBoost() {
        return energyBoost;
    }

    public int getRarity() {
        return rarity;
    }
}
