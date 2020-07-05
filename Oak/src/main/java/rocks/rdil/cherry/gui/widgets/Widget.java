package rocks.rdil.cherry.gui.widgets;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
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

    public void render(DrawableHelper s) {
        if (!MinecraftClient.isHudEnabled() || !this.getEnabled()) {
            return;
        }

        s.drawCenteredString(MinecraftClient.getInstance().textRenderer, this.getDisplay(), this.getConfigX(), this.getConfigY(), 16777215);
    }
}
