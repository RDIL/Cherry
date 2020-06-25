package rocks.rdil.cherry.mixins;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public abstract class MixinPlayerEntityRenderer extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public MixinPlayerEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, PlayerEntityModel<AbstractClientPlayerEntity> entityModel, float f) {
        super(entityRenderDispatcher, entityModel, f);
    }

    @Inject(
            method = {"<init>(Lnet/minecraft/client/render/entity/EntityRenderDispatcher;Z)V"},
            at = {@At("RETURN")}
    )
    private void construct(EntityRenderDispatcher entityRenderDispatcher, boolean alex, CallbackInfo info) {
        this.addFeature(new LayerRender(this));
        this.addFeature(new ElytraLayer.LayerRender(this));

        this.features.removeIf(feat -> feat instanceof ElytraFeatureRenderer);
    }
}
