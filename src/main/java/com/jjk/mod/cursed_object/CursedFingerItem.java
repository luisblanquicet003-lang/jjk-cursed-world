package com.jjk.mod.cursed_object;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CursedFingerItem extends Item {
    private int energyBoost = 20;
    private int rarity = 5; // Rarest

    public CursedFingerItem(Properties properties) {
        super(properties);
    }

    public int getEnergyBoost() {
        return energyBoost;
    }

    public int getRarity() {
        return rarity;
    }
}
