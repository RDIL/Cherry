package rocks.rdil.cherry.events;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import rocks.rdil.cherry.config.CherryOptions;

public class RunTickCallback {
    public RunTickCallback() {}

    public static final RunTickCallback INSTANCE = new RunTickCallback();
    private boolean hasAppliedNightVision = false;

    public void run() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        if (player.horizontalCollision || player.isSneaking() || player.isWet() || player.isSubmergedInWater()) {
            return;
        }

        if (player.forwardSpeed > 0 && CherryOptions.INSTANCE.toggleSprint) {
            player.setSprinting(true);
        }

        if (CherryOptions.INSTANCE.fullbright) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 16360, 0, false, false));
        } else if (this.hasAppliedNightVision) {
            player.removeStatusEffect(StatusEffects.NIGHT_VISION);
            this.hasAppliedNightVision = false;
        }
    }
}
