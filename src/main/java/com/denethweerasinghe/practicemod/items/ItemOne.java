package com.denethweerasinghe.practicemod.items;

import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemOne extends Item {
    public ItemOne() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(PracticeMod.setup.creativeTab)
        );
        setRegistryName("itemone");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn){
        System.out.println("This is item one!");
        return new ActionResult<>(ActionResultType.PASS, playerIn.getHeldItem(handIn));
    }
}
