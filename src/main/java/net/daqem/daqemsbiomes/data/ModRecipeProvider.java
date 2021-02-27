package net.daqem.daqemsbiomes.data;

import net.daqem.daqemsbiomes.common.item.ModItemTags;
import net.daqem.daqemsbiomes.init.ModBlocks;
import net.daqem.daqemsbiomes.init.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends ForgeRecipeProvider {


    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

        // CRAFTING TABLE
        ShapedRecipeBuilder.shapedRecipe(Items.CRAFTING_TABLE.getItem(), 1)
                .patternLine("XX")
                .patternLine("XX")
                .key('X', ModItems.CHERRY_BLOSSOM_PLANKS.get())
                .addCriterion("cherry_blossom_planks", InventoryChangeTrigger.Instance.forItems(ModItems.CHERRY_BLOSSOM_PLANKS.get()))
                .build(consumer);

        // STICKS
        ShapedRecipeBuilder.shapedRecipe(Items.STICK.getItem(), 4)
                .patternLine("X")
                .patternLine("X")
                .key('X', ModItems.CHERRY_BLOSSOM_PLANKS.get())
                .addCriterion("cherry_blossom_planks", InventoryChangeTrigger.Instance.forItems(ModItems.CHERRY_BLOSSOM_PLANKS.get()))
                .build(consumer);

        // SLABS
        ShapedRecipeBuilder.shapedRecipe(ModItems.CHERRY_BLOSSOM_SLAB.get(), 6)
                .patternLine("XXX")
                .key('X', ModItems.CHERRY_BLOSSOM_PLANKS.get())
                .addCriterion("cherry_blossom_planks", InventoryChangeTrigger.Instance.forItems(ModItems.CHERRY_BLOSSOM_PLANKS.get()))
                .build(consumer);

        // STAIRS
        ShapedRecipeBuilder.shapedRecipe(ModItems.CHERRY_BLOSSOM_STAIRS.get(), 4)
                .patternLine("X  ")
                .patternLine("XX ")
                .patternLine("XXX")
                .key('X', ModItems.CHERRY_BLOSSOM_PLANKS.get())
                .addCriterion("cherry_blossom_planks", InventoryChangeTrigger.Instance.forItems(ModItems.CHERRY_BLOSSOM_PLANKS.get()))
                .build(consumer);

        // SHAPELESS
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHERRY_BLOSSOM_PLANKS.get(), 4)
                .addIngredient(ModItems.CHERRY_BLOSSOM_LOGS.get())
                .addCriterion("cherry_blossom_logs", InventoryChangeTrigger.Instance.forItems(ModItems.CHERRY_BLOSSOM_LOGS.get()))
                .build(consumer);

    }
}
