package net.daqem.daqemsbiomes.client;

import net.daqem.daqemsbiomes.DAQEMsBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.*;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Optional;

@Mod.EventBusSubscriber(modid = DAQEMsBiomes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class ModWorldTypeGUI {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onGuiOpen(GuiOpenEvent event) {
//        Screen gui = event.getGui();
//        Minecraft minecraft = Minecraft.getInstance();
//        Screen screen = minecraft.currentScreen;
//
//        if (gui instanceof CreateWorldScreen && screen instanceof WorldSelectionScreen) {
//            WorldOptionsScreen optionsScreen = ((CreateWorldScreen)gui).field_238934_c_;
//            optionsScreen.field_239040_n_ = Optional.of(findBiomeGeneratorTypeScreen());
//            optionsScreen.field_239039_m_ = optionsScreen.field_239040_n_.get().func_241220_a_(optionsScreen.field_239038_l_, optionsScreen.field_239039_m_.getSeed(), optionsScreen.field_239039_m_.doesGenerateFeatures(), optionsScreen.field_239039_m_.hasBonusChest());
//        }
    }

    private static BiomeGeneratorTypeScreens findBiomeGeneratorTypeScreen()
    {
        for (BiomeGeneratorTypeScreens screen : BiomeGeneratorTypeScreens.field_239068_c_)
        {
            TranslationTextComponent desc = (TranslationTextComponent)screen.field_239076_k_;

            if (desc.getKey().equals("generator.minecraft.daqemsbiomes"))
            {
                return screen;
            }
        }

        throw new RuntimeException("Cannot find DAQEM's Biomes biome generator type!");
    }
}
