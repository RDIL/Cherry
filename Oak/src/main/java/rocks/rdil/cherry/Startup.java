package rocks.rdil.cherry;

import java.io.File;

import lombok.NoArgsConstructor;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rocks.rdil.cherry.config.CherryOptions;
import rocks.rdil.simpleconfig.ConfigHandler;

/**
 * Starts the client.
 */
@NoArgsConstructor
public final class Startup implements ModInitializer {
    public final ConfigHandler configHandler = new ConfigHandler(new File("cherry-config.json"));
    public static Startup instance;
    private static boolean initialized;
    public static final Logger LOGGER = LogManager.getLogger("Cherry");

    @Override
    public void onInitialize() {
        if (initialized) {
            throw new RuntimeException("onInitialize() called twice, this SHOULD NOT HAPPEN!!!");
        }

        initialized = true;
        instance = this;

        LOGGER.info("Loaded Cherry!");

        configHandler.register(CherryOptions.INSTANCE);
    }

    public void saveConfig() {
        this.configHandler.save();
    }
}
