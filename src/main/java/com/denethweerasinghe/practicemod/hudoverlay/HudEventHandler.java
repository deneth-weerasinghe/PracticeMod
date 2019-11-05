package com.denethweerasinghe.practicemod.hudoverlay;

import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class HudEventHandler {

    private static final ResourceLocation barLocation = new ResourceLocation(PracticeMod.MODID, "textures/gui/hud_overlay.png");

    public static void init() {
        MinecraftForge.EVENT_BUS.register((new HudEventHandler()));
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onRender(RenderGameOverlayEvent.Post event) {

        if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE)
            return;
        if (event.isCanceled())
            return;

        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = (PlayerEntity) mc.getRenderViewEntity();
        FontRenderer fr = mc.fontRenderer;
        int elementPosX = mc.mainWindow.getScaledWidth() / 2 + 10;
        int elementPosY = mc.mainWindow.getScaledHeight() - 49;

        if (player.areEyesInFluid(FluidTags.WATER) || player.getAir() < 300) {
            elementPosY -= 10;
        }
        if (player.isCreative() || player.isSpectator())
            return;

        mc.getTextureManager().bindTexture(barLocation);
        mc.ingameGUI.blit(elementPosX, elementPosY, 0, 0, 81, 9);
        mc.ingameGUI.drawCenteredString(fr, "lmao", mc.mainWindow.getScaledWidth()/2, mc.mainWindow.getScaledHeight()/2, 0xFFFFFF);
    }
}