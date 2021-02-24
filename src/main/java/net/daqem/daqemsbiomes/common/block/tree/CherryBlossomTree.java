package net.daqem.daqemsbiomes.common.block.tree;

import net.daqem.daqemsbiomes.init.ModFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class CherryBlossomTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        if (randomIn.nextInt(10) == 0)
            return largeHive ? ModFeatures.Configs.BIG_CHERRY_TREE_CONFIG : ModFeatures.Configs.BIG_CHERRY_TREE_CONFIG;
        return largeHive ? ModFeatures.Configs.CHERRY_TREE_CONFIG : ModFeatures.Configs.CHERRY_TREE_CONFIG;
    }
}
