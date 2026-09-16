package com.jjk.mod.sound;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import com.jjk.mod.JJKMod;

public class JJKSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = 
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, JJKMod.MOD_ID);

    public static final RegistryObject<SoundEvent> CURSED_ENERGY_CHARGE = 
            SOUNDS.register("cursed_energy_charge", () -> new SoundEvent(new ResourceLocation(JJKMod.MOD_ID, "cursed_energy_charge")));
    
    public static final RegistryObject<SoundEvent> CURSED_ENERGY_RELEASE = 
            SOUNDS.register("cursed_energy_release", () -> new SoundEvent(new ResourceLocation(JJKMod.MOD_ID, "cursed_energy_release")));
    
    public static final RegistryObject<SoundEvent> BLACK_FLASH = 
            SOUNDS.register("black_flash", () -> new SoundEvent(new ResourceLocation(JJKMod.MOD_ID, "black_flash")));

    public static void register(IEventBus modEventBus) {
        SOUNDS.register(modEventBus);
    }
}
