package com.denethweerasinghe.practicemod.items;

import com.denethweerasinghe.practicemod.customclass.CustomClass;
import com.denethweerasinghe.practicemod.customclass.ICustomClass;
import com.denethweerasinghe.practicemod.setup.PracticeMod;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemOne extends Item {
    public ItemOne() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(PracticeMod.setup.creativeTab)
        );
        setRegistryName("itemone");
    }

//    @Override
//    public ActionResultType onItemUse(ItemUseContext context) {
//        World world = context.getWorld();
//        if (!world.isRemote) {
//            if (world.getBlockState(context.getPos()).getBlock() == Blocks.WATER) {
//                ICustomClass cap = CustomClass.getFromPlayer(context.getPlayer());
//                cap.setCounter(cap.getCounter() + 10);
//                PracticeMod.LOGGER.info("new value is: " + cap.getCounter());
//            }
//        }
//        return ActionResultType.SUCCESS;
//    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn){
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
        if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            PracticeMod.LOGGER.info("Air click");
            return new ActionResult<>(ActionResultType.PASS, itemstack);
        } else {
            if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                BlockPos blockpos = ((BlockRayTraceResult) raytraceresult).getPos();
                if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
                    PracticeMod.LOGGER.info("Block click");
                    return new ActionResult<>(ActionResultType.PASS, itemstack);
                }

                if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
                    if (!worldIn.isRemote) {
                        ICustomClass cap = CustomClass.getFromPlayer(playerIn);
                        cap.setCounter(cap.getCounter() + 10);
                        worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                        PracticeMod.LOGGER.info("new value is: " + cap.getCounter());
                        CustomClass.updateClient((ServerPlayerEntity) playerIn, cap);
                        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
                    }
                }
            }
            return new ActionResult<>(ActionResultType.PASS, itemstack);
        }
    }
//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn){
//        if (!worldIn.isRemote){
//            ICustomClass cap = CustomClass.getFromPlayer(playerIn);
//            cap.setCounter(cap.getCounter()+10);
//            PracticeMod.LOGGER.info("new value is: " + cap.getCounter());
//        }
//        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
//    }
}
