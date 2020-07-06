package rocks.rdil.cherry.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
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

        ButtonWidget fps = new ButtonWidget(x, y, 200, 20, "FPS Widget", button -> MinecraftClient.getInstance().openScreen(new FpsWidgetSettings(this)));
        ButtonWidget potions = new ButtonWidget(x, y2, 200, 20, "Potions Widget", button -> MinecraftClient.getInstance().openScreen(new PotionWidgetSettings(this)));

        CherryOptions c = CherryOptions.INSTANCE;

        ButtonWidget squareBrace = new ButtonWidget(x, y3, 200, 20, "Use Square Braces: " + fromConfig(c.widgetsUseSquareBraces), button -> {
            c.widgetsUseSquareBraces = !c.widgetsUseSquareBraces;
            Startup.instance.saveConfig();
            button.setMessage("Use Square Braces: " + fromConfig(c.widgetsUseSquareBraces));
        });

        this.addButton(fps);
        this.addButton(potions);
        this.addButton(squareBrace);
        this.addButton(GuiUtil.makeBackButton(parent));
    }

    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        this.drawCenteredString(this.font, this.title.asFormattedString(), this.width / 2, 20, 16777215);
        super.render(mouseX, mouseY, delta);
    }

    public static LiteralText getTitleTextComponent() {
        Style titleStyle = new Style()
                .setBold(true)
                .setUnderline(true)
                .setColor(Formatting.RED);
        return (LiteralText) new LiteralText("Select a Widget").setStyle(titleStyle);
    }
}
