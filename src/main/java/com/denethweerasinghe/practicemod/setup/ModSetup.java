package com.denethweerasinghe.practicemod.setup;

import com.denethweerasinghe.practicemod.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    public ItemGroup creativeTab = new ItemGroup("practicemod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.BLOCKONE);
        }
    };
    public void init() {

    }
}
