package rocks.rdil.cherry.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.render.VisibleRegion;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.BatEntity;
import rocks.rdil.cherry.config.CherryOptions;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer<T extends Entity> {
    @Inject(at = @At("HEAD"), method = "isVisible", cancellable = true)
    public void isVisible(T entity, VisibleRegion visibleRegion, double d, double e, double f, CallbackInfoReturnable<Boolean> cir) {
        if ((entity instanceof BatEntity) && CherryOptions.INSTANCE.hideBats) {
            cir.setReturnValue(false);
        }
    }
}
