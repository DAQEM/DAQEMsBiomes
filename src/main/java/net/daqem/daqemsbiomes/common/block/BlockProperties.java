package net.daqem.daqemsbiomes.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockProperties {

    public static AbstractBlock.Properties CHERRY_BLOSSOM_LEAVES(MaterialColor color) {
        return AbstractBlock.Properties.create(Material.LEAVES, color).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid();
    }
}
