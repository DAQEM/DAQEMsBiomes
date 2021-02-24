package net.daqem.daqemsbiomes.common.util;

import net.daqem.daqemsbiomes.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class VanillaCompatibility {

    public static void setupVanillaCompatibility() {
        RenderTypeLookup.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_SAPLING.get(), RenderType.getCutout());
    }
}
