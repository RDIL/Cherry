package rocks.rdil.cherry.gui.widgets;

import com.google.common.collect.Ordering;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import rocks.rdil.cherry.config.CherryOptions;

import java.util.Collection;

public class PotionsWidget extends Widget {
    @Override
    public String getPrefix() {
        return null;
    }

    @Override
    public String getSuffix() {
        return null;
    }

    @Override
    public int getConfigX() {
        return CherryOptions.INSTANCE.potWidgetX;
    }

    @Override
    public int getConfigY() {
        return CherryOptions.INSTANCE.potWidgetY;
    }

    @Override
    public boolean getEnabled() {
        return CherryOptions.INSTANCE.enablePotionsWidget;
    }

    @Override
    public void render(MatrixStack matrixStack, DrawableHelper s) {
        if (MinecraftClient.isHudEnabled() && this.getEnabled()) {
            int y = 0;
            Collection<StatusEffectInstance> collection = MinecraftClient.getInstance().player.getStatusEffects();
            if (!collection.isEmpty()) {
                for (StatusEffectInstance statusEffectInstance : Ordering.natural().reverse().sortedCopy(collection)) {
                    StatusEffect statusEffect = statusEffectInstance.getEffectType();
                    DrawableHelper.drawCenteredString(matrixStack, MinecraftClient.getInstance().textRenderer, I18n.translate(statusEffect.getTranslationKey()) + " - " + StatusEffectUtil.durationToString(statusEffectInstance, 1.0F), this.getConfigX(), this.getConfigY() + y, 16777215);
                    y += 10;
                }
            }
        }
    }
}
