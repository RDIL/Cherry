package rocks.rdil.cherry.config;

import rocks.rdil.simpleconfig.Config;
import rocks.rdil.simpleconfig.Configuration;

public class CherryOptions extends Config {
    public static final CherryOptions INSTANCE = new CherryOptions();

    @Configuration public boolean toggleSprint = false;
    @Configuration public boolean enableTutorialPopups = true;
    @Configuration public boolean fullbright = false;
    @Configuration public boolean hideBats = false;
}
