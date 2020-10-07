package rocks.rdil.cherry;

import java.io.File;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rocks.rdil.cherry.config.CherryOptions;
import rocks.rdil.simpleconfig.ConfigurationSystem;

/**
 * Starts the client.
 */
public final class Startup implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("Cherry");
    public final ConfigurationSystem configurationSystem = new ConfigurationSystem(new File("cherry-config.json"));
    public static Startup INSTANCE;
    private static boolean initialized;

    public Startup() {}

    @Override
    public void onInitialize() {
        if (initialized) {
            throw new RuntimeException("onInitialize() called twice, this SHOULD NOT HAPPEN!!!");
        }

        initialized = true;
        INSTANCE = this;

        LOGGER.info("Loaded Cherry!");

        configurationSystem.register(CherryOptions.INSTANCE);
    }

    public void saveConfig() {
        this.configurationSystem.save();
    }
}
