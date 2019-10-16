package com.denethweerasinghe.practicemod.hudoverlay;

import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeIngameGui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class HudEventHandler {

    protected int foodIconsOffset;
    private static final ResourceLocation bar = new ResourceLocation(PracticeMod.MODID, "textures/gui/icons.png");

    public static void init(){
        MinecraftForge.EVENT_BUS.register((new HudEventHandler()));
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onRender(RenderGameOverlayEvent.Pre event){

        if (event.getType() != RenderGameOverlayEvent.ElementType.FOOD)
           return;

        foodIconsOffset = ForgeIngameGui.right_height;

        if(event.isCanceled())
           return;
       Minecraft mc = Minecraft.getInstance();
       PlayerEntity player = mc.player;

       float maxExhaustion = 4.0F;
       float ratio = 2 / maxExhaustion;
       int left = mc.mainWindow.getScaledWidth() /2 + 91;
       int top = mc.mainWindow.getScaledHeight() - foodIconsOffset;
       int width = (int) (ratio) * 81;
       int height = 9;

        mc.getTextureManager().bindTexture(bar);
        mc.ingameGUI.blit(left-width, top, 81 - width, 18, width, height+60);
    }
}
