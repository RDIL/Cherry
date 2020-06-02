package rocks.rdil.cherry;

import net.fabricmc.api.ModInitializer;
import rocks.rdil.cherry.commands.CherryCommand;

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

        new CherryCommand();
    }
}
