//package net.daqem.daqemsbiomes.world;
//
//import com.google.common.collect.ImmutableList;
//import com.mojang.serialization.Codec;
//import com.mojang.serialization.codecs.RecordCodecBuilder;
//import net.daqem.daqemsbiomes.util.ModClimates;
//import net.minecraft.util.RegistryKey;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.util.registry.RegistryLookupCodec;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.Biomes;
//import net.minecraft.world.biome.provider.BiomeProvider;
//import net.minecraft.world.gen.layer.Layer;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class ModBiomeProvider extends BiomeProvider {
//
//    public static final Codec<ModBiomeProvider> CODEC = RecordCodecBuilder.create((builder) ->
//    {
//        return builder.group(
//                Codec.LONG.fieldOf("seed").stable().forGetter((biomeProvider) -> biomeProvider.seed),
//                RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((biomeProvider) -> biomeProvider.biomes)
//        ).apply(builder, builder.stable(ModBiomeProvider::new));
//    });
//
//    private static final List<RegistryKey<Biome>> VANILLA_POSSIBLE_BIOMES = ImmutableList.of(Biomes.OCEAN, Biomes.PLAINS, Biomes.DESERT, Biomes.MOUNTAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.SWAMP, Biomes.RIVER, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER, Biomes.SNOWY_TUNDRA, Biomes.SNOWY_MOUNTAINS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELD_SHORE, Biomes.BEACH, Biomes.DESERT_HILLS, Biomes.WOODED_HILLS, Biomes.TAIGA_HILLS, Biomes.MOUNTAIN_EDGE, Biomes.JUNGLE, Biomes.JUNGLE_HILLS, Biomes.JUNGLE_EDGE, Biomes.DEEP_OCEAN, Biomes.STONE_SHORE, Biomes.SNOWY_BEACH, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.DARK_FOREST, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA_HILLS, Biomes.GIANT_TREE_TAIGA, Biomes.GIANT_TREE_TAIGA_HILLS, Biomes.WOODED_MOUNTAINS, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.BADLANDS, Biomes.WOODED_BADLANDS_PLATEAU, Biomes.BADLANDS_PLATEAU, Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_WARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.SUNFLOWER_PLAINS, Biomes.DESERT_LAKES, Biomes.GRAVELLY_MOUNTAINS, Biomes.FLOWER_FOREST, Biomes.TAIGA_MOUNTAINS, Biomes.SWAMP_HILLS, Biomes.ICE_SPIKES, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE, Biomes.TALL_BIRCH_FOREST, Biomes.TALL_BIRCH_HILLS, Biomes.DARK_FOREST_HILLS, Biomes.SNOWY_TAIGA_MOUNTAINS, Biomes.GIANT_SPRUCE_TAIGA, Biomes.GIANT_SPRUCE_TAIGA_HILLS, Biomes.MODIFIED_GRAVELLY_MOUNTAINS, Biomes.SHATTERED_SAVANNA, Biomes.SHATTERED_SAVANNA_PLATEAU, Biomes.ERODED_BADLANDS, Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU, Biomes.MODIFIED_BADLANDS_PLATEAU);
//
//    private final long seed;
//    private final Layer noiseBiomeLayer;
//    private final Registry<Biome> biomes;
//
//    public ModBiomeProvider(long seed, Registry<Biome> biomes)
//    {
//        super(Stream.concat(VANILLA_POSSIBLE_BIOMES.stream(), ModClimates.getOverworldBiomes().stream()).map(biomes::getValueForKey).collect(Collectors.toList()));
//        this.seed = seed;
//        this.noiseBiomeLayer = ModLayerUtil.createGenLayers(seed, new ModOverworldGenSettings());
//        this.biomes = biomes;
//    }
//
//    @Override
//    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
//        return CODEC;
//    }
//
//    @Override
//    public BiomeProvider getBiomeProvider(long seed) {
//        return new ModBiomeProvider(seed, this.biomes);
//    }
//
//    @Override
//    public Biome getNoiseBiome(int x, int y, int z)
//    {
//        return this.noiseBiomeLayer.func_242936_a(this.biomes, x, z);
//    }
//}