package net.daqem.daqemsbiomes;

import net.daqem.daqemsbiomes.client.VanillaCompatibility;
import net.daqem.daqemsbiomes.init.ModBiomes;
import net.daqem.daqemsbiomes.init.ModBlocks;
import net.daqem.daqemsbiomes.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DAQEMsBiomes.MOD_ID)
public class DAQEMsBiomes {

    public static final String MOD_ID = "daqemsbiomes";
    public static final Logger LOGGER = LogManager.getLogger();

    public DAQEMsBiomes() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> modEventBus.addListener(EventPriority.LOWEST, this::doClientStuff));
        modEventBus.addListener(EventPriority.LOWEST, this::setup);

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBiomes.BIOMES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModBiomes.registerBiomes(event);
        LOGGER.info("Common Stuff Done!");

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        DeferredWorkQueue.runLater(VanillaCompatibility::setupVanillaCompatibility);
        LOGGER.info("Client Stuff Done!");
    }

    public static final ItemGroup TAB = new ItemGroup("daqemsbiomestab") {
        public ItemStack createIcon() {
            return new ItemStack(ModItems.LOGO.get());
        }
    };
}
