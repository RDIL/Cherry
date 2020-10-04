package rocks.rdil.cherry.config;

import rocks.rdil.simpleconfig.Option;

public class CherryOptions {
    public CherryOptions() {}

    public static final CherryOptions INSTANCE = new CherryOptions();

    @Option public boolean toggleSprint = false;
    @Option public boolean enableTutorialPopups = true;
    @Option public boolean fullbright = false;
    @Option public boolean hideBats = false;
    @Option public boolean widgetsUseSquareBraces = false;
    @Option public boolean fpsWidgetEnabled = false;
    @Option public int fpsWidgetX = 0;
    @Option public int fpsWidgetY = 0;
    @Option public boolean enableBossbar = true;
    @Option public boolean enablePotionsWidget = false;
    @Option public int potWidgetX = 0;
    @Option public int potWidgetY = 0;
}
