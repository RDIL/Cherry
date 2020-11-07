package rocks.rdil.cherry.gui.widgets;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import rocks.rdil.cherry.Cherry;
import rocks.rdil.cherry.config.CherryOptions;

/**
 * The typical widget implementation.
 */
public abstract class Widget<C extends WidgetSettings> {
    public C config;

    /**
     * Returns the config object for this widget;
     */
    public C getConfig() {
        return config;
    }

    /**
     * Creates a new Widget instance, and registers the given configuration.
     * 
     * @param config The configuration object.
     */
    public Widget(C config) {
        this.config = config;
        Cherry.INSTANCE.configurationSystem.register(config);
    }

    /**
     * Default name value.
     */
    public String getName() {
        return this.getPrefix();
    }

    /**
     * Get the prefix of the widget.
     * 
     * @return The prefix.
     */
    public String getPrefix() {
        return "My Epic Widget";
    }

    /**
     * Get the suffix of the widget.
     * 
     * @return The suffix.
     */
    public String getSuffix() {
        return "Some data";
    }

    /**
     * Get the display string of the widget.
     *
     * @see {@link rocks.rdil.cherry.gui.widgets.Widget#getPrefix()}
     * @see {@link rocks.rdil.cherry.gui.widgets.Widget#getSuffix()}
     * @return The string to display.
     */
    public String getDisplay() {
        if (CherryOptions.INSTANCE.widgetsUseSquareBraces) {
            return "[" + this.getPrefix() + "] " + this.getSuffix();
        }
        return this.getPrefix() + ": " + this.getSuffix();
    }

    /**
     * Render the widget on screen.
     * 
     * @param matrixStack The MatrixStack.
     * @param hud The DrawableHelper that allows you to draw to the HUD.
     */
    public void render(MatrixStack matrixStack, DrawableHelper hud) {
        if (!MinecraftClient.isHudEnabled() || !this.config.isEnabled) {
            return;
        }

        DrawableHelper.drawCenteredString(matrixStack, MinecraftClient.getInstance().textRenderer, this.getDisplay(), this.config.xPos, this.config.yPos, 16777215);
    }
}
