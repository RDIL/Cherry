package rocks.rdil.cherry.gui.widgets;

import net.minecraft.client.MinecraftClient;
import rocks.rdil.cherry.mixins.IMixinMinecraftClient;
import rocks.rdil.simpleconfig.Option;

public class FpsWidget extends Widget<FpsWidget.Configuration> {
    public FpsWidget() {
        super(Configuration.INSTANCE);
    }

    @Override
    public String getPrefix() {
        return "FPS";
    }

    @Override
    public String getSuffix() {
        return String.valueOf(((IMixinMinecraftClient) MinecraftClient.getInstance()).getCurrentFps());
    }

    public static class Configuration extends WidgetSettings {
        public static final FpsWidget.Configuration INSTANCE = new FpsWidget.Configuration();

        @Option public boolean isEnabled = false;
        @Option public int xPos = 10;
        @Option public int yPos = 10;
    }
}
