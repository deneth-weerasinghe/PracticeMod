package com.denethweerasinghe.practicemod.handlers;

import com.denethweerasinghe.practicemod.customclass.CustomClass;
import com.denethweerasinghe.practicemod.customclass.ICustomClass;
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
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class HudEventHandler {

    private static final ResourceLocation barLocation = new ResourceLocation(PracticeMod.MODID, "textures/gui/hud_overlay.png");

    public static void init() {
        MinecraftForge.EVENT_BUS.register(new HudEventHandler());
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {

        if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE)
            return;
        if (event.isCanceled())
            return;

        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = (PlayerEntity) mc.getRenderViewEntity();
        FontRenderer fr = mc.fontRenderer;

        //screen coordinates from which we draw our HUD elements
        int elementPosX = mc.mainWindow.getScaledWidth() / 2 + 10;
        int elementPosY = mc.mainWindow.getScaledHeight() - 49;

        //makes sure the bar doesn't overwrite the air bar, which only appears under these conditions
        if (player.areEyesInFluid(FluidTags.WATER) || player.getAir() < 300) {
            elementPosY -= 10;
        }

        //makes the bar visible only in survival or adventure mode
        if (player.isCreative() || player.isSpectator())
            return;

        ICustomClass cap = CustomClass.getFromPlayer(player);

        mc.getTextureManager().bindTexture(barLocation);
        mc.ingameGUI.blit(elementPosX, elementPosY, 0, 0, 81, 9);
        mc.ingameGUI.drawCenteredString(fr, String.valueOf(cap.getCounter()), mc.mainWindow.getScaledWidth()/2, mc.mainWindow.getScaledHeight()/2, 0xFFFFFF);
        int healthBarFraction = (int)(81 * (player.getHealth()/player.getMaxHealth()));
        mc.ingameGUI.blit(elementPosX, elementPosY, 0,18,healthBarFraction,9);
    }
}