package com.jjk.mod.capability;

import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;

@Mod.EventBusSubscriber(modid = "jjk")
public class CapabilityEvents {

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Player> event) {
        Player player = event.getObject();
        
        if (!player.getCapability(CursedEnergyCapability.CURSED_ENERGY_CAPABILITY).isPresent()) {
            CursedEnergyData data = new CursedEnergyData();
            event.addCapability(
                    new net.minecraft.resources.ResourceLocation("jjk", "cursed_energy"),
                    new ICapabilityProvider() {
                        private final LazyOptional<CursedEnergyData> instance = LazyOptional.of(() -> data);

                        @Override
                        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
                            if (cap == CursedEnergyCapability.CURSED_ENERGY_CAPABILITY) {
                                return instance.cast();
                            }
                            return LazyOptional.empty();
                        }
                    }
            );
        }
    }
}
