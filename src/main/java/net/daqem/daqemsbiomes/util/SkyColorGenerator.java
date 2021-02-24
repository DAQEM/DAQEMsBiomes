package net.daqem.daqemsbiomes.util;

import net.minecraft.util.math.MathHelper;

public class SkyColorGenerator {

    public static int getSkyColorWithTemperatureModifier(float temperature) {
        float dont_look_u_idiot = temperature / 3.0F;
        dont_look_u_idiot = MathHelper.clamp(dont_look_u_idiot, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - dont_look_u_idiot * 0.05F, 0.5F + dont_look_u_idiot * 0.1F, 1.0F);
    }
}
