package rocks.rdil.cherry.config;

import rocks.rdil.simpleconfig.Configuration;

public class CherryOptions {
    public static final CherryOptions INSTANCE = new CherryOptions();

    @Configuration public boolean toggleSprint;
    @Configuration public boolean enableTutorialPopups;
}
