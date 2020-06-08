package rocks.rdil.cherry;

import java.io.File;

import net.fabricmc.api.ModInitializer;
import rocks.rdil.cherry.config.CherryOptions;
import rocks.rdil.simpleconfig.ConfigHandler;

/**
 * Starts the client.
 */
public final class Startup implements ModInitializer {
    private static boolean initialized;

    @Override
    public void onInitialize() {
        if (initialized) {
            throw new RuntimeException("onInitialize() called twice, this SHOULD NOT HAPPEN!!!");
        }

        initialized = true;

        ConfigHandler configHandler = new ConfgHandler(new File("cherry-config.json"));
        configHandler.register(CherryOptions.INSTANCE);
    }
}
