package net.daqem.daqemsbiomes.biomes;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

import static net.daqem.daqemsbiomes.util.SkyColorGenerator.getSkyColorWithTemperatureModifier;

public class CherryBlossomForest {

    public static Biome makeCherryBlossomForest() {
        MobSpawnInfo.Builder mobSpawnInfo$builder = new MobSpawnInfo.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244178_j);
        DefaultBiomeFeatures.withStrongholdAndMineshaft(biomeGenerationSettings$builder);
        biomeGenerationSettings$builder.withStructure(StructureFeatures.RUINED_PORTAL);
        biomeGenerationSettings$builder.withStructure(StructureFeatures.VILLAGE_PLAINS);
        DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings$builder);
        DefaultBiomeFeatures.withMonsterRoom(biomeGenerationSettings$builder);
        biomeGenerationSettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FOREST_FLOWER_VEGETATION_COMMON);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomeGenerationSettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings$builder);
        DefaultBiomeFeatures.withDisks(biomeGenerationSettings$builder);
        biomeGenerationSettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FOREST_FLOWER_TREES);
        biomeGenerationSettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_FOREST);
        DefaultBiomeFeatures.withBadlandsGrass(biomeGenerationSettings$builder);
        DefaultBiomeFeatures.withNormalMushroomGeneration(biomeGenerationSettings$builder);
        DefaultBiomeFeatures.withSugarCaneAndPumpkins(biomeGenerationSettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(biomeGenerationSettings$builder);
        DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings$builder);
        return (new Biome.Builder()
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.FOREST)
                .depth(0.1F)
                .scale(0.1F)
                .downfall(0.5F)
                .temperature(0.7F)
                .setEffects((new BiomeAmbience.Builder())
                        .setWaterColor(4159204)
                        .setWaterFogColor(329011)
                        .setFogColor(12638463)
                        .withSkyColor(getSkyColorWithTemperatureModifier(0.7F))
                        .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                        .build())
                .withMobSpawnSettings(mobSpawnInfo$builder.copy())
                .withGenerationSettings(biomeGenerationSettings$builder.build())
                .build());
    }
}

