package net.daqem.daqemsbiomes.init;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class ModFeatures {

    public static final class Configs {

        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_CONFIG = register("cherry_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ModFeatures.States.CHERRY_BLOSSOM_LOG), new SimpleBlockStateProvider(States.CHERRY_BLOSSOM_LEAVES), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_TREE_BEES_CONFIG = register("bees_cherry_tree", Feature.TREE.withConfiguration(CHERRY_TREE_CONFIG.getConfig().func_236685_a_(ImmutableList.of(Features.Placements.BEES_002_PLACEMENT))));
        public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BIG_CHERRY_TREE_CONFIG = register("big_cherry_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CHERRY_BLOSSOM_LOG), new SimpleBlockStateProvider(States.CHERRY_BLOSSOM_LEAVES), new FancyFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build()));

        public static final ConfiguredFeature<?, ?> CHERRY_FOREST_TREES = register("cherry_forest_trees", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(BIG_CHERRY_TREE_CONFIG.withChance(0.1F), Features.OAK_BEES_005.withChance(0.25F)), CHERRY_TREE_BEES_CONFIG)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(/*The Amount of trees that generate*/10, 0.1F, 1))));

        private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
            return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
        }
    }

    public static final class States {

        private static final BlockState CHERRY_BLOSSOM_LEAVES = (ModBlocks.CHERRY_BLOSSOM_LEAVES.get()).getDefaultState();

        private static final BlockState CHERRY_BLOSSOM_LOG = ModBlocks.CHERRY_BLOSSOM_LOG.get().getDefaultState();
    }
}
