//package net.daqem.daqemsbiomes.common.world;
//
//import net.minecraft.util.registry.DynamicRegistries;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.DimensionType;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.gen.DimensionSettings;
//import net.minecraft.world.gen.NoiseChunkGenerator;
//import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
//import net.minecraftforge.common.world.ForgeWorldType;
//import net.minecraft.world.gen.ChunkGenerator;
//
//public class ModWorldType extends ForgeWorldType {
//
//    public ModWorldType() {
//        super(null);
//    }
//
//    @Override
//    public ChunkGenerator createChunkGenerator(Registry<Biome> biomeRegistry, Registry<DimensionSettings> dimensionSettingsRegistry, long seed, String generatorSettings)
//    {
//        return new NoiseChunkGenerator(new ModBiomeProvider(seed, biomeRegistry), seed, () -> dimensionSettingsRegistry.getOrThrow(DimensionSettings.field_242734_c));
//    }
//
//    @Override
//    public DimensionGeneratorSettings createSettings(DynamicRegistries dynamicRegistries, long seed, boolean generateFeatures, boolean generateBonusChest, String generatorSettings)
//    {
//        Registry<Biome> biomeRegistry = dynamicRegistries.getRegistry(Registry.BIOME_KEY);
//        Registry<DimensionSettings> dimensionSettingsRegistry = dynamicRegistries.getRegistry(Registry.NOISE_SETTINGS_KEY);
//        Registry<DimensionType> dimensionTypeRegistry = dynamicRegistries.getRegistry(Registry.DIMENSION_TYPE_KEY);
//
//        return new DimensionGeneratorSettings(seed, generateFeatures, generateBonusChest,
//                DimensionGeneratorSettings.func_242749_a(dimensionTypeRegistry,  DimensionType.getDefaultSimpleRegistry(dimensionTypeRegistry, biomeRegistry, dimensionSettingsRegistry, randomSeed()),
//                        createChunkGenerator(biomeRegistry, dimensionSettingsRegistry, seed, null)));
//    }
//
//    public long randomSeed() {
//        long leftLimit = 1L;
//        long rightLimit = 9999999999L;
//        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
//    }
//}
