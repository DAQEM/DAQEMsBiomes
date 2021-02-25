package net.daqem.daqemsbiomes.client;

import net.daqem.daqemsbiomes.DAQEMsBiomes;
import net.daqem.daqemsbiomes.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {
        super(gen, DAQEMsBiomes.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.CHERRY_BLOSSOM_LEAVES.get());
        simpleBlock(ModBlocks.CHERRY_BLOSSOM_SAPLING.get(), models().cross("cherry_blossom_sapling", modLoc("block/cherry_blossom_sapling")));
    }
}
