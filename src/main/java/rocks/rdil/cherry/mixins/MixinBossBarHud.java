package rocks.rdil.cherry.mixins;

import net.minecraft.client.gui.hud.BossBarHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rocks.rdil.cherry.config.CherryOptions;

@Mixin(BossBarHud.class)
public class MixinBossBarHud {
    @Inject(at = @At(value = "HEAD"), method = "render")
    public void render(CallbackInfo ci) {
        if (!CherryOptions.INSTANCE.enableBossbar) {
            ci.cancel();
        }
    }
}
