package rocks.rdil.cherry.integrations;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import com.mojang.blaze3d.platform.GlStateManager;

public class PlayerCapeRenderer extends FeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public PlayerCapeRenderer(FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> context) {
        super(context);
    }

    public void render(AbstractClientPlayerEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        Identifier rl = new Identifier("2011.png");
        if (!entitylivingbaseIn.isInvisible() && entitylivingbaseIn.isPartVisible(PlayerModelPart.CAPE) && rl != null) {
            ItemStack itemstack = entitylivingbaseIn.getEquippedStack(EquipmentSlot.CHEST);
            if (itemstack.getItem() != Items.ELYTRA) {
                float capeFloat = 0.250F;
                float capeHeight = 0.0F;
                if (entitylivingbaseIn.isInSneakingPose()) {
                    capeFloat -= 0.1F;
                    capeHeight += 0.10F;
                } else {
                    capeFloat -= 0.1F;
                    capeHeight += 0.05F;
                }

                GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.bindTexture(rl);
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.0F, capeHeight, capeFloat);
                double d0 = MathHelper.lerp(partialTicks, entitylivingbaseIn.field_7524, entitylivingbaseIn.field_7500) - MathHelper.lerp(partialTicks, entitylivingbaseIn.prevX, entitylivingbaseIn.x);
                double d1 = MathHelper.lerp(partialTicks, entitylivingbaseIn.field_7502, entitylivingbaseIn.field_7521) - MathHelper.lerp(partialTicks, entitylivingbaseIn.prevY, entitylivingbaseIn.y);
                double d2 = MathHelper.lerp(partialTicks, entitylivingbaseIn.field_7522, entitylivingbaseIn.field_7499) - MathHelper.lerp(partialTicks, entitylivingbaseIn.prevZ, entitylivingbaseIn.z);
                float f = entitylivingbaseIn.field_6220 + (entitylivingbaseIn.field_6283 - entitylivingbaseIn.field_6220);
                double d3 = MathHelper.sin(f * 0.017453292F);
                double d4 = -MathHelper.cos(f * 0.017453292F);
                float f1 = (float) d1 * 10.0F;
                f1 = MathHelper.clamp(f1, -6.0F, 32.0F);
                float f2 = (float) (d0 * d3 + d2 * d4) * 100.0F;
                f2 = MathHelper.clamp(f2, 0.0F, 150.0F);
                float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
                f3 = MathHelper.clamp(f3, -20.0F, 20.0F);
                if (f2 < 0.0F) {
                   f2 = 0.0F;
                }

                float f4 = MathHelper.lerp(partialTicks, entitylivingbaseIn.field_7505, entitylivingbaseIn.field_7483);
                f1 += MathHelper.sin(MathHelper.lerp(partialTicks, entitylivingbaseIn.prevHorizontalSpeed, entitylivingbaseIn.horizontalSpeed) * 6.0F) * 32.0F * f4;
                if (entitylivingbaseIn.isInSneakingPose()) {
                    f1 += 25.0F;
                }

                GlStateManager.rotatef(6.0F + f2 / 2.0F + f1, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotatef(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
                GlStateManager.rotatef(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
                GlStateManager.rotatef(180.0F, 0.0F, 1.0F, 0.0F);
                this.getContextModel().renderCape(0.0625F);
                GlStateManager.popMatrix();
            }
        }
    }

    @Override
    public boolean hasHurtOverlay() {
        return false;
    }
}
