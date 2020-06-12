package rocks.rdil.cherry.gui.widgets;

import net.minecraft.client.MinecraftClient;
import rocks.rdil.cherry.config.CherryOptions;

public class FpsWidget extends Widget {
    @Override
    public String getPrefix() {
        return "FPS";
    }

    @Override
    public String getSuffix() {
        return String.valueOf(MinecraftClient.getCurrentFps());
    }

    @Override
    public int getConfigX() {
        return CherryOptions.INSTANCE.fpsWidgetX;
    }

    @Override
    public int getConfigY() {
        return CherryOptions.INSTANCE.fpsWidgetY;
    }

    @Override
    public boolean getEnabled() {
        return CherryOptions.INSTANCE.fpsWidgetEnabled;
    }
}
