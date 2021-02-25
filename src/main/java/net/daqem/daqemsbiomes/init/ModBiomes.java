package net.daqem.daqemsbiomes.init;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.daqem.daqemsbiomes.DAQEMsBiomes;
import net.daqem.daqemsbiomes.common.biome.overworld.CherryBlossomForest;
//import net.daqem.daqemsbiomes.common.world.ModWorldType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.GameData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = DAQEMsBiomes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DAQEMsBiomes.MOD_ID);

    public static final RegistryObject<Biome> CHERRY_BLOSSOM_FORREST = BIOMES.register("cherry_blossom_forest", CherryBlossomForest::makeCherryBlossomForest);

    //TODO Autumn forest (With different colors of red/orange leaves) (foxes) (autumn maple tree maybe oak logs)
    //TODO Arctic Taiga (white leaves) (white foxed and and dogs)
    //TODO Redwood forest
    //TODO Tropical islands
    //TODO Canyon
    //TODO Red Desert (child of desert)
    //TODO Better hills and mountains
    //TODO Tropical biome
    //TODO Mixed forest (maple, ash, Poplar, Oak, Birch)

    @SubscribeEvent
    public static void registerBiomes(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            setupBiome(CHERRY_BLOSSOM_FORREST.get(), BiomeManager.BiomeType.WARM, 10000/*TODO Change before release*/, BiomeDictionary.Type.RARE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        });
        Logger gameDataLogger = (Logger) LogManager.getLogger(GameData.class);
        gameDataLogger.setLevel(Level.OFF);
    }

    public static void setupBiome(Biome biome, BiomeManager.BiomeType biomeType, int weight, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(key(biome), types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(key(biome), weight));
    }

    public static RegistryKey<Biome> key(Biome biome) {
        return RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome), "Biome registry name was null"));
    }
}
