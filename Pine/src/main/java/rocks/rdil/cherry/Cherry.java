package rocks.rdil.cherry;

import java.io.File;
import java.util.List;

import com.google.common.collect.Lists;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rocks.rdil.cherry.config.CherryOptions;
import rocks.rdil.cherry.gui.widgets.FpsWidget;
import rocks.rdil.cherry.gui.widgets.PotionsWidget;
import rocks.rdil.cherry.gui.widgets.Widget;
import rocks.rdil.simpleconfig.ConfigurationSystem;

/**
 * The main class.
 */
public final class Cherry implements ModInitializer {
    /**
     * Our logger instance.
     */
    public static final Logger LOGGER = LogManager.getLogger("Cherry");

    /**
     * The publically usable instance of Cherry.
     */
    public static Cherry INSTANCE = new Cherry();

    /**
     * The configuration system instance.
     */
    public final ConfigurationSystem configurationSystem = new ConfigurationSystem(new File("cherry-config.json"));

    /**
     * If Cherry has been loaded yet.
     */
    public boolean isInitialized = false;

    private final List<Widget<?>> widgets = Lists.newArrayList();

    public Cherry() {
        // stub to make intellij not complain
    }

    @Override
    public void onInitialize() {
        if (Cherry.INSTANCE.isInitialized) {
            Cherry.LOGGER.error("Cherry has been initialized more then once. This has either caused by a mod that depends on Cherry, or Fabric Loader.");
            Cherry.LOGGER.error("Please report this at https://github.com/RDIL/Cherry/issues - thanks in advance.");
            throw new RuntimeException("onInitialize() called twice.");
        }

        Cherry.INSTANCE.isInitialized = true;

        LOGGER.info("[1/2] Registering configuration...");
        configurationSystem.register(CherryOptions.INSTANCE);

        LOGGER.info("[2/2] Registering widgets...");
        Cherry.INSTANCE.registerDefaultWidgets();

        LOGGER.info("Finished bootstrapping Cherry.");
    }

    /**
     * Saves the configuration options to the JSON file.
     */
    public void saveConfig() {
        this.configurationSystem.save();
    }

    /**
     * Registers a widget.
     * 
     * @param widget The widget.
     */
    public void registerWidget(Widget<?> widget) {
        this.widgets.add(widget);
    }

    private void registerDefaultWidgets() {
        this.registerWidget(new FpsWidget());
        this.registerWidget(new PotionsWidget());
    }

    /**
     * This is used internally to get all the registered widgets.
     * 
     * @return The widgets as a {@link java.util.ArrayList}.
     */
    public List<Widget<?>> getAllWidgets() {
        return this.widgets;
    }
}
