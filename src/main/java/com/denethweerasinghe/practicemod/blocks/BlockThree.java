package com.denethweerasinghe.practicemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockThree extends Block {

    public BlockThree() {
        super(Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(2.0f, 3.0f)
                .harvestTool(ToolType.AXE)
        );
        setRegistryName("blockthree");

    }
}
