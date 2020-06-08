package rocks.rdil.cherry;

import java.io.File;

import net.fabricmc.api.ModInitializer;
import rocks.rdil.cherry.config.CherryOptions;
import rocks.rdil.simpleconfig.ConfigHandler;

/**
 * Starts the client.
 */
public final class Startup implements ModInitializer {
    public static Startup instance;
    private static boolean initialized;
    public ConfigHandler configHandler = new ConfgHandler(new File("cherry-config.json"));

    @Override
    public void onInitialize() {
        if (initialized) {
            throw new RuntimeException("onInitialize() called twice, this SHOULD NOT HAPPEN!!!");
        }

        initialized = true;
        instance = this;

        configHandler.register(CherryOptions.INSTANCE);
    }
}
