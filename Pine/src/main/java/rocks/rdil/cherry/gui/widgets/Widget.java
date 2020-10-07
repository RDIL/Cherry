package rocks.rdil.cherry.gui.widgets;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import rocks.rdil.cherry.config.CherryOptions;

public abstract class Widget {
    public abstract String getPrefix();
    public abstract String getSuffix();
    public abstract int getConfigX();
    public abstract int getConfigY();
    public abstract boolean getEnabled();

    public String getDisplay() {
        if (CherryOptions.INSTANCE.widgetsUseSquareBraces) {
            return "[" + this.getPrefix() + "] " + this.getSuffix();
        }
        return this.getPrefix() + ": " + this.getSuffix();
    }

    public void render(MatrixStack matrixStack, DrawableHelper s) {
        if (!MinecraftClient.isHudEnabled() || !this.getEnabled()) {
            return;
        }

        DrawableHelper.drawCenteredString(matrixStack, MinecraftClient.getInstance().textRenderer, this.getDisplay(), this.getConfigX(), this.getConfigY(), 16777215);
    }
}
