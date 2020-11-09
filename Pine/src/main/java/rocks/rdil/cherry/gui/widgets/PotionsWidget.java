package rocks.rdil.cherry.gui.widgets;

import com.google.common.collect.Ordering;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import rocks.rdil.simpleconfig.Option;

import java.util.Collection;

public class PotionsWidget extends Widget<PotionsWidget.Configuration> {
    public PotionsWidget() {
        super(Configuration.INSTANCE);
    }

    @Override
    public String getName() {
        return "Potion Effects";
    }

    @Override
    public void render(MatrixStack matrixStack, DrawableHelper s) {
        if (MinecraftClient.isHudEnabled() && PotionsWidget.Configuration.INSTANCE.isEnabled) {
            // we add 10 to this each time we render a new effect so it doesn't overlap effects
            int y = 0;
            Collection<StatusEffectInstance> collection = MinecraftClient.getInstance().player.getStatusEffects();
            if (!collection.isEmpty()) {
                for (StatusEffectInstance statusEffectInstance : Ordering.natural().reverse().sortedCopy(collection)) {
                    StatusEffect statusEffect = statusEffectInstance.getEffectType();
                    DrawableHelper.drawCenteredString(matrixStack, MinecraftClient.getInstance().textRenderer, I18n.translate(statusEffect.getTranslationKey()) + " - " + StatusEffectUtil.durationToString(statusEffectInstance, 1.0F), PotionsWidget.Configuration.INSTANCE.xPos, PotionsWidget.Configuration.INSTANCE.yPos + y, 16777215);
                    y += 10;
                }
            }
        }
    }

    public static class Configuration extends WidgetSettings {
        public static final PotionsWidget.Configuration INSTANCE = new PotionsWidget.Configuration();

        @Option public boolean isEnabled = false;
        @Option public int xPos = 10;
        @Option public int yPos = 10;
    }
}
