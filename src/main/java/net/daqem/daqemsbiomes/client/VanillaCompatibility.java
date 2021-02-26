package net.daqem.daqemsbiomes.client;

import net.daqem.daqemsbiomes.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class VanillaCompatibility {

    public static void setupVanillaCompatibility() {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            RenderType transparentRenderType = RenderType.getCutoutMipped();
            RenderType cutoutRenderType = RenderType.getCutout();

            // ONLY LEAVES
            RenderTypeLookup.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_LEAVES.get(), transparentRenderType);

            // OTHERS
            RenderTypeLookup.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_SAPLING.get(), cutoutRenderType);
        }
    }
}
