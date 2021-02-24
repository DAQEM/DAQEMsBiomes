package net.daqem.daqemsbiomes.init;

import net.daqem.daqemsbiomes.common.block.BlockItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "daqemsbiomes");

    public static final RegistryObject<Item> CHERRY_BLOSSOM_LEAVES = ITEMS.register("cherry_blossom_leaves", () -> new BlockItemBase(ModBlocks.CHERRY_BLOSSOM_LEAVES.get()));
    public static final RegistryObject<Item> CHERRY_BLOSSOM_SAPLING = ITEMS.register("cherry_blossom_sapling", () -> new BlockItemBase(ModBlocks.CHERRY_BLOSSOM_SAPLING.get()));

    public static final RegistryObject<Item> LOGO = ITEMS.register("logo", () -> new Item(new Item.Properties()));
}
