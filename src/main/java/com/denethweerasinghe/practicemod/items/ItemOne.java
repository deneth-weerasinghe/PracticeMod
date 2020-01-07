package com.denethweerasinghe.practicemod.items;

import com.denethweerasinghe.practicemod.customclass.CustomClass;
import com.denethweerasinghe.practicemod.customclass.ICustomClass;
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
        if (!worldIn.isRemote){
            ICustomClass cap = CustomClass.getFromPlayer(playerIn);
            cap.setCounter(cap.getCounter()+10);
            PracticeMod.LOGGER.info("new value is: " + cap.getCounter());
        }
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }
}
