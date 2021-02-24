package net.daqem.daqemsbiomes.init;

import net.daqem.daqemsbiomes.common.block.BlockProperties;
import net.daqem.daqemsbiomes.common.block.tree.CherryBlossomTree;
import net.minecraft.block.*;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "daqemsbiomes");

    public static final RegistryObject<Block> CHERRY_BLOSSOM_LEAVES = BLOCKS.register("cherry_blossom_leaves", () -> new LeavesBlock(BlockProperties.CHERRY_BLOSSOM_LEAVES(MaterialColor.PINK).notSolid()));
    public static final RegistryObject<Block> CHERRY_BLOSSOM_SAPLING = BLOCKS.register("cherry_blossom_sapling", () -> new SaplingBlock(new CherryBlossomTree(), AbstractBlock.Properties.create(Blocks.OAK_SAPLING.getDefaultState().getMaterial())));
}
