package com.jjk.mod.event;

import com.jjk.mod.JJKConfig;
import com.jjk.mod.capability.CursedEnergyCapability;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;

@Mod.EventBusSubscriber(modid = "jjk")
public class CombatHandler {

    @SubscribeEvent
    public static void onPlayerAttack(LivingAttackEvent event) {
        if (event.getEntity() instanceof Player player && !player.level.isClientSide) {
            player.getCapability(CursedEnergyCapability.CURSED_ENERGY_CAPABILITY).ifPresent(data -> {
            });
        }
    }

    @SubscribeEvent
    public static void onEntityHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            player.getCapability(CursedEnergyCapability.CURSED_ENERGY_CAPABILITY).ifPresent(data -> {
                float damageMultiplier = (float) JJKConfig.COMMON.damageMultiplier.get();
                event.setAmount(event.getAmount() * damageMultiplier);
            });
        }
    }
}
