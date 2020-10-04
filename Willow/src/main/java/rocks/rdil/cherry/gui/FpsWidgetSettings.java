package rocks.rdil.cherry.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import rocks.rdil.cherry.Startup;
import rocks.rdil.cherry.config.CherryOptions;

import static rocks.rdil.cherry.gui.CherryGui.fromConfig;

public class FpsWidgetSettings extends Screen {
    private final Screen parent;

    public FpsWidgetSettings(Screen parent) {
        super(getTitleTextComponent());
        this.parent = parent;
    }

    protected void init() {
        final int x = this.width / 2 - 100;
        int y = this.height / 7;
        int y2 = y + (this.height / 10);
        int y3 = y2 + (this.height / 10);

        CherryOptions c = CherryOptions.INSTANCE;

        ButtonWidget enabled = new ButtonWidget(x, y, 200, 20, fromConfig(c.fpsWidgetEnabled), button -> {
            c.fpsWidgetEnabled = !c.fpsWidgetEnabled;
            Startup.INSTANCE.saveConfig();
            button.setMessage(fromConfig(c.fpsWidgetEnabled));
        });

        ButtonWidget moveLeft = new ButtonWidget(x - 5, y2, 100, 20, "Move Left", button -> {
           CherryOptions.INSTANCE.fpsWidgetX -= 5;
           Startup.INSTANCE.saveConfig();
        });

        ButtonWidget moveRight = new ButtonWidget(x + 105, y2, 100, 20, "Move Right", button -> {
            CherryOptions.INSTANCE.fpsWidgetX += 5;
            Startup.INSTANCE.saveConfig();
        });

        ButtonWidget moveUp = new ButtonWidget(x - 5, y3, 100, 20, "Move Up", button -> {
            CherryOptions.INSTANCE.fpsWidgetY -= 5;
            Startup.INSTANCE.saveConfig();
        });

        ButtonWidget moveDown = new ButtonWidget(x + 105, y3, 100, 20, "Move Down", button -> {
            CherryOptions.INSTANCE.fpsWidgetY += 5;
            Startup.INSTANCE.saveConfig();
        });

        this.addButton(GuiUtil.makeBackButton(parent));
        this.addButton(moveLeft);
        this.addButton(moveRight);
        this.addButton(moveDown);
        this.addButton(moveUp);
        this.addButton(enabled);
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
        return (LiteralText) new LiteralText("FPS Widget").setStyle(titleStyle);
    }
}
