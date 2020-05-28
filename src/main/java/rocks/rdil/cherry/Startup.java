package rocks.rdil.cherry;

import net.fabricmc.api.ModInitializer;

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
    }
}
