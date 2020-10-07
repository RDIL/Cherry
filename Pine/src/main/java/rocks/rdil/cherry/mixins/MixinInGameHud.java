package rocks.rdil.cherry.mixins;

import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import rocks.rdil.cherry.config.CherryOptions;
import rocks.rdil.cherry.events.RenderHudCallback;

@Mixin(InGameHud.class)
public class MixinInGameHud extends DrawableHelper {
    @Inject(at = @At("RETURN"), method = "render")
    public void render(MatrixStack matrixStack, float tickDelta, CallbackInfo ci) {
        RenderHudCallback.INSTANCE.run(matrixStack,this);
    }

    @Inject(at = @At("HEAD"), method = "renderStatusEffectOverlay", cancellable = true)
    public void renderStatusEffectOverlay(CallbackInfo ci) {
        if (CherryOptions.INSTANCE.enablePotionsWidget) {
            ci.cancel();
        }
    }
}
