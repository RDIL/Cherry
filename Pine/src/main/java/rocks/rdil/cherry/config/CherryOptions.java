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
    @Option public boolean enableBossbar = true;
}
