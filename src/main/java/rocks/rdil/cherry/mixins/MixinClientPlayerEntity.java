package rocks.rdil.cherry.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.network.ClientPlayerEntity;
import rocks.rdil.cherry.events.RunTickCallback;

@Mixin(ClientPlayerEntity.class)
public class MixinClientPlayerEntity {
    private static final RunTickCallback cherryRunTick = new RunTickCallback();

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;tick()V", ordinal = 0), method = "tick()V")
    private void onTick(CallbackInfo ci) {
        cherryRunTick.run();
    }
}
