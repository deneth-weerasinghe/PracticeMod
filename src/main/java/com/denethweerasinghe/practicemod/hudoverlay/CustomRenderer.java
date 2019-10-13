package com.denethweerasinghe.practicemod.hudoverlay;

import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiUtils;
import org.lwjgl.opengl.GL11;

import java.text.DecimalFormat;

public class CustomRenderer extends GuiUtils {

    public static final ResourceLocation overLayBar = new ResourceLocation(PracticeMod.MODID, "textures/gui/hud_overlay.png");
    private Minecraft mc;

    public CustomRenderer(Minecraft mc){
        this.mc = mc;
    }

    public void renderBar(int width, int height){
        FontRenderer fontRenderer = mc.fontRenderer;
        DecimalFormat decFormat = new DecimalFormat("#,###");

        // OpenGL setup
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        GL11.glPushMatrix();
        GL11.glColor4f(1, 1, 1, 1); //check it works like this
        mc.textureManager.bindTexture(overLayBar);

        drawTexturedModalRect(0, 0, 0, 0, 81, 9, 1.0F);


    }


}
