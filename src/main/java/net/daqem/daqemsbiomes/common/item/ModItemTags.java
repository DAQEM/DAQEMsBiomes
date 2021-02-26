package net.daqem.daqemsbiomes.common.item;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;
import net.minecraft.util.ResourceLocation;

public class ModItemTags {

    protected static final TagRegistry<Item> collection = TagRegistryManager.create(new ResourceLocation("item"), ITagCollectionSupplier::getItemTags);

    public static final ITag.INamedTag<Item> CHERRY_BLOSSOM_LOGS = makeWrapperTag("cherry_blossom_logs");

    public static ITag.INamedTag<Item> makeWrapperTag(String id) {
        return collection.createTag(id);
    }

}
