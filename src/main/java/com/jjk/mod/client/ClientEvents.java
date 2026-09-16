package com.jjk.mod.client;

import com.jjk.mod.JJKMod;
import com.jjk.mod.capability.CursedEnergyCapability;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.world.entity.player.Player;

@Mod.EventBusSubscriber(modid = JJKMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAboveHealthBar("jjk:cursed_energy_bar", (gui, poseStack, partialTick, width, height) -> {
            renderCursedEnergyBar(poseStack, width, height);
        });
    }

    private static void renderCursedEnergyBar(PoseStack poseStack, int width, int height) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;

        if (player == null) return;

        player.getCapability(CursedEnergyCapability.CURSED_ENERGY_CAPABILITY).ifPresent(data -> {
            int barWidth = 182;
            int barHeight = 5;
            int x = width / 2 - barWidth / 2;
            int y = height - 49;

            // Draw background (empty bar)
            fill(poseStack, x, y, x + barWidth, y + barHeight, 0xFF09070D);

            // Draw filled portion
            float percent = data.getEnergyPercent();
            int filledWidth = (int) (barWidth * percent);

            if (filledWidth > 0) {
                int color = getEnergyColor(percent);
                fill(poseStack, x + 1, y + 1, x + filledWidth, y + barHeight - 1, color);
            }

            // Draw border
            fill(poseStack, x, y, x + barWidth, y + 1, 0xFF28103D);
            fill(poseStack, x, y + barHeight - 1, x + barWidth, y + barHeight, 0xFF28103D);
        });
    }

    private static int getEnergyColor(float percent) {
        if (percent > 0.8f) {
            return 0xFF9A3CFF;
        } else if (percent > 0.6f) {
            return 0xFF7020A8;
        } else if (percent > 0.4f) {
            return 0xFF4A146E;
        } else if (percent > 0.2f) {
            return 0xFF28103D;
        } else {
            return 0xFF160B22;
        }
    }

    private static void fill(PoseStack poseStack, int x1, int y1, int x2, int y2, int color) {
        if (x1 < x2) {
            int i = x1;
            x1 = x2;
            x2 = i;
        }

        if (y1 < y2) {
            int j = y1;
            y1 = y2;
            y2 = j;
        }

        GuiComponent.fill(poseStack, x2, y2, x1, y1, color);
    }
}
