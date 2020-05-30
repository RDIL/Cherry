package rocks.rdil.cherry.events;

import lombok.NoArgsConstructor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

@NoArgsConstructor
public class RunTickCallback implements ICallback {
    @Override
    public void run() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        if (player.horizontalCollision || player.isSneaking() || player.isWet() || player.isSubmergedInWater()) {
            return;
        }

        if (player.forwardSpeed > 0) {
            player.setSprinting(true);
        }
    }
}
