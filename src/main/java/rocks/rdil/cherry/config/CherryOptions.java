package rocks.rdil.cherry.config;

import lombok.NoArgsConstructor;
import rocks.rdil.simpleconfig.Config;
import rocks.rdil.simpleconfig.Configuration;

@NoArgsConstructor
public class CherryOptions extends Config {
    public static final CherryOptions INSTANCE = new CherryOptions();

    @Configuration public boolean toggleSprint = false;
    @Configuration public boolean enableTutorialPopups = true;
    @Configuration public boolean fullbright = false;
    @Configuration public boolean hideBats = false;
    @Configuration public boolean widgetsUseSquareBraces = false;
    @Configuration public boolean fpsWidgetEnabled = false;
    @Configuration public int fpsWidgetX = 0;
    @Configuration public int fpsWidgetY = 0;
}
