package net.daqem.daqemsbiomes.data;

import com.google.common.eventbus.Subscribe;
import net.daqem.daqemsbiomes.DAQEMsBiomes;
import net.daqem.daqemsbiomes.client.ModBlockStateProvider;
import net.daqem.daqemsbiomes.client.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = DAQEMsBiomes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenertors {
    private DataGenertors() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
        gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));
        gen.addProvider(new ModRecipeProvider(gen));
    }
}
