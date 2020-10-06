package rocks.rdil.cherry.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import rocks.rdil.cherry.Startup;
import rocks.rdil.cherry.config.CherryOptions;

import static rocks.rdil.cherry.gui.CherryGui.fromConfig;

public class WidgetSettings extends Screen {
    private final Screen parent;

    public WidgetSettings(Screen parent) {
        super(getTitleTextComponent());
        this.parent = parent;
    }

    protected void init() {
        final int x = this.width / 2 - 100;
        int y = this.height / 7;
        int y2 = y + (this.height / 10);
        int y3 = y2 + (this.height / 10);

        ButtonWidget fps = new ButtonWidget(x, y, 200, 20, new LiteralText("FPS Widget"), button -> MinecraftClient.getInstance().openScreen(new FpsWidgetSettings(this)));
        ButtonWidget potions = new ButtonWidget(x, y2, 200, 20, new LiteralText("Potions Widget"), button -> MinecraftClient.getInstance().openScreen(new PotionWidgetSettings(this)));

        CherryOptions c = CherryOptions.INSTANCE;

        ButtonWidget squareBrace = new ButtonWidget(x, y3, 200, 20, new LiteralText("Use Square Braces: " + fromConfig(c.widgetsUseSquareBraces)), button -> {
            c.widgetsUseSquareBraces = !c.widgetsUseSquareBraces;
            Startup.INSTANCE.saveConfig();
            button.setMessage(new LiteralText("Use Square Braces: " + fromConfig(c.widgetsUseSquareBraces)));
        });

        this.addButton(fps);
        this.addButton(potions);
        this.addButton(squareBrace);
        this.addButton(GuiUtil.makeBackButton(parent));
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {
        renderBackground(matrixStack);
        drawCenteredString(matrixStack, this.textRenderer, this.title.asString(), this.width / 2, 20, 16777215);
        super.render(matrixStack, mouseX, mouseY, delta);
    }

    public static LiteralText getTitleTextComponent() {
        return (LiteralText) new LiteralText("Select a Widget").styled(
                style -> style.withBold(true)
                        .withUnderline(true)
                        .withColor(Formatting.RED));
    }
}
