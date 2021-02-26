package net.daqem.daqemsbiomes.init;

import net.daqem.daqemsbiomes.common.block.BlockItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "daqemsbiomes");

    // LEAVES
    public static final RegistryObject<Item> CHERRY_BLOSSOM_LEAVES = ITEMS.register("cherry_blossom_leaves", () -> new BlockItemBase(ModBlocks.CHERRY_BLOSSOM_LEAVES.get()));

    // SAPLINGS
    public static final RegistryObject<Item> CHERRY_BLOSSOM_SAPLING = ITEMS.register("cherry_blossom_sapling", () -> new BlockItemBase(ModBlocks.CHERRY_BLOSSOM_SAPLING.get()));

    // LOGS
    public static final RegistryObject<Item> CHERRY_BLOSSOM_LOGS = ITEMS.register("cherry_blossom_logs", () -> new BlockItemBase(ModBlocks.CHERRY_BLOSSOM_LOGS.get()));

    // PLANKS
    public static final RegistryObject<Item> CHERRY_BLOSSOM_PLANKS = ITEMS.register("cherry_blossom_planks", () -> new BlockItemBase(ModBlocks.CHERRY_BLOSSOM_PLANKS.get()));

    //OTHER
    public static final RegistryObject<Item> LOGO = ITEMS.register("logo", () -> new Item(new Item.Properties()));
}
