package net.daqem.daqemsbiomes;

import net.daqem.daqemsbiomes.init.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(DAQEMsBiomes.MOD_ID)
public class DAQEMsBiomes {

    public static final String MOD_ID = "daqemsbiomes";
    public static final Logger LOGGER = LogManager.getLogger();

    public DAQEMsBiomes() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () ->
                modEventBus.addListener(EventPriority.LOWEST, this::doClientStuff));
        modEventBus.addListener(EventPriority.LOWEST, this::setup);

        ModBiomes.BIOMES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModBiomes.setup();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        ModBiomes.registerBiomes(event);
        LOGGER.info("Common Setup Done!");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }}
