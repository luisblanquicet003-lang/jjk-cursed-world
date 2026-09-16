package com.jjk.mod.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafxmod.FXModLanguageProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.jjk.mod.JJKMod;

public class JJKParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = 
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, JJKMod.MOD_ID);

    public static final RegistryObject<ParticleType<?>> CURSED_ENERGY_PARTICLE = 
            PARTICLES.register("cursed_energy", () -> new net.minecraft.core.particles.SimpleParticleType(false));
    
    public static final RegistryObject<ParticleType<?>> BLACK_FLASH_PARTICLE = 
            PARTICLES.register("black_flash", () -> new net.minecraft.core.particles.SimpleParticleType(false));

    public static void register(IEventBus modEventBus) {
        PARTICLES.register(modEventBus);
    }
}
