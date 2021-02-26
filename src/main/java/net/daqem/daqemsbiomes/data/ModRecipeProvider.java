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
        ShapedRecipeBuilder.shapedRecipe(Items.CRAFTING_TABLE.getItem())
                .patternLine("XX")
                .patternLine("XX")
                .key('X', ModItems.CHERRY_BLOSSOM_PLANKS.get())
                .addCriterion("cherry_blossom_planks", InventoryChangeTrigger.Instance.forItems(ModItems.CHERRY_BLOSSOM_PLANKS.get()))
                .build(consumer);

        ShapelessRecipeBuilder.shapelessRecipe(ModItems.CHERRY_BLOSSOM_PLANKS.get(), 4)
                .addIngredient(ModItems.CHERRY_BLOSSOM_LOGS.get())
                .addCriterion("cherry_blossom_logs", InventoryChangeTrigger.Instance.forItems(ModItems.CHERRY_BLOSSOM_LOGS.get()))
                .build(consumer);
    }
}
