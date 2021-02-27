package net.daqem.daqemsbiomes.init;

import net.daqem.daqemsbiomes.DAQEMsBiomes;
import net.daqem.daqemsbiomes.common.block.tree.CherryBlossomTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = createRegister(ForgeRegistries.BLOCKS);
    public static final DeferredRegister<Item> ITEMS = createRegister(ForgeRegistries.ITEMS);

    //LEAVES
    public static final RegistryObject<Block> CHERRY_BLOSSOM_LEAVES = register("cherry_blossom_leaves", () ->
            new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));

    //SAPLINGS
    public static final RegistryObject<Block> CHERRY_BLOSSOM_SAPLING = register("cherry_blossom_sapling", () ->
            new SaplingBlock(new CherryBlossomTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));

    //LOGS
    public static final RegistryObject<Block> CHERRY_BLOSSOM_LOGS = register("cherry_blossom_logs", () ->
            new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

    // PLANKS
    public static final RegistryObject<Block> CHERRY_BLOSSOM_PLANKS = register("cherry_blossom_planks", () ->
            new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));

    // STAIRS
    public static final RegistryObject<Block> CHERRY_BLOSSOM_STAIRS = register("cherry_blossom_stairs", () ->
            new StairsBlock(CHERRY_BLOSSOM_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(CHERRY_BLOSSOM_PLANKS.get())));

    // SLABS
    public static final RegistryObject<Block> CHERRY_BLOSSOM_SLAB = register("cherry_blossom_slab", () ->
            new SlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));


    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
        return ret;
    }

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> createRegister(IForgeRegistry<T> registry) {
        return DeferredRegister.create(registry, DAQEMsBiomes.MOD_ID);
    }
}
