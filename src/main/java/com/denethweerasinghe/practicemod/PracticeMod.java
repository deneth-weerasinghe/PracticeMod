package com.denethweerasinghe.practicemod;

import com.denethweerasinghe.practicemod.blocks.BlockOne;
import com.denethweerasinghe.practicemod.blocks.BlockTwo;
import com.denethweerasinghe.practicemod.blocks.ModBlocks;
import com.denethweerasinghe.practicemod.items.ItemOne;
import com.denethweerasinghe.practicemod.setup.ClientProxy;
import com.denethweerasinghe.practicemod.setup.IProxy;
import com.denethweerasinghe.practicemod.setup.ModSetup;
import com.denethweerasinghe.practicemod.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("practicemod")
public class PracticeMod {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    // proxy will hold two different values depending if the code is server side or client side


    public static ModSetup setup = new ModSetup();
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public PracticeMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this ::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        proxy.getClientWorld(); // will either run as usual or throw an exception depending if the code runs server (bad) or client side (as it should be)
        setup.init();
        proxy.init();
    }


    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                    new BlockOne(),
                    new BlockTwo()
            ); // blocks registry event
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

            Item.Properties properties = new Item.Properties().group(setup.creativeTab); // adds the universal property of being in a specific category of items (ItemGroup)
            // used for placing the following items being registered into a "creative tab" (Minecraft's "cheat menu")

            event.getRegistry().registerAll(

                    // items associated with blocks, whose registry event will be loaded after the blocks
                    // needed to keep the blocks in the inventory, otherwise it will be just a blocks in the world
                    new BlockItem(ModBlocks.BLOCKONE, properties).setRegistryName("blockone"),
                    new BlockItem(ModBlocks.BLOCKTWO, properties).setRegistryName("blocktwo"),

                    // complex items/non-BlockItems
                    new ItemOne() // properties defined in separate class because it'd be a mess to define a complex item object here whereas BlockItems have simple properties
            );
        }
    }
}
