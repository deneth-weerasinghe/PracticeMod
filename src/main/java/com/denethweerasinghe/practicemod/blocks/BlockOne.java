package com.denethweerasinghe.practicemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockOne extends Block {

    public BlockOne() {
        super(Properties.create(Material.SAND)
                .sound(SoundType.SAND)
                .hardnessAndResistance(1.0f)
                .lightValue(15)
                .slipperiness(1.0f)
                .harvestLevel(3)
                .harvestTool(ToolType.SHOVEL)
        );
        setRegistryName("blockone");
    }
}
