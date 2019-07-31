package com.denethweerasinghe.practicemod.items;

import com.denethweerasinghe.practicemod.PracticeMod;
import net.minecraft.item.Item;

public class ItemOne extends Item {
    public ItemOne() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(PracticeMod.setup.creativeTab)
        );
        setRegistryName("itemone");
    }
}
