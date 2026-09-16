package com.jjk.mod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafxmod.FXModLanguageProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(JJKMod.MOD_ID)
public class JJKMod {
    public static final String MOD_ID = "jjk";
    public static final Logger LOGGER = LogManager.getLogger();

    public JJKMod() {
        ModLoadingContext.getInstance().registerConfig(ModConfig.Type.COMMON, JJKConfig.SPEC);
        LOGGER.info("JJK: CURSED WORLD initialized");
    }
}
