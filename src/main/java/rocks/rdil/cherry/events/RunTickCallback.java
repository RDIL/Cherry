package rocks.rdil.cherry.events;

import lombok.NoArgsConstructor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import rocks.rdil.cherry.config.ConfigManager;

@NoArgsConstructor
public class RunTickCallback implements ICallback {
    @Override
    public void run() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        if (player.horizontalCollision || player.isSneaking() || player.isWet() || player.isSubmergedInWater()) {
            return;
        }

        if (player.forwardSpeed > 0 && ConfigManager.instance.config.getToggleSprint().equals("true")) {
            player.setSprinting(true);
        }
    }
}
