package rocks.rdil.cherry.events;

import lombok.NoArgsConstructor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import rocks.rdil.cherry.config.CherryOptions;

@NoArgsConstructor
public class RunTickCallback implements ICallback {
    public static final RunTickCallback instance = new RunTickCallback();

    @Override
    public void run() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        if (player.horizontalCollision || player.isSneaking() || player.isWet() || player.isSubmergedInWater()) {
            return;
        }

        if (player.forwardSpeed > 0 && CherryOptions.INSTANCE.toggleSprint) {
            player.setSprinting(true);
        }

        // todo: implement with config
        if (false) {
            MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 16360, 0, false, false));
        }
    }
}
