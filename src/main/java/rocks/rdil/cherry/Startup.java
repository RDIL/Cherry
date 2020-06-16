package rocks.rdil.cherry;

import java.io.File;

import lombok.NoArgsConstructor;
import net.fabricmc.api.ModInitializer;
import rocks.rdil.cherry.config.CherryOptions;
import rocks.rdil.simpleconfig.ConfigHandler;

/**
 * Starts the client.
 */
@NoArgsConstructor
public final class Startup implements ModInitializer {
    public ConfigHandler configHandler = new ConfigHandler(new File("cherry-config.json"));
    public static Startup instance;
    private static boolean initialized;

    @Override
    public void onInitialize() {
        if (initialized) {
            throw new RuntimeException("onInitialize() called twice, this SHOULD NOT HAPPEN!!!");
        }

        initialized = true;
        instance = this;

        configHandler.register(CherryOptions.INSTANCE);
    }

    public void saveConfig() {
        this.configHandler.save();
    }
}
