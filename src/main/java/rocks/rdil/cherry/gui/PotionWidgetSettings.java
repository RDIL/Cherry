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

public class PotionWidgetSettings extends Screen {
    private final Screen parent;

    public PotionWidgetSettings(Screen parent) {
        super(getTitleTextComponent());
        this.parent = parent;
    }

    protected void init() {
        final int x = this.width / 2 - 100;
        int y = this.height / 7;
        int y2 = y + (this.height / 10);
        int y3 = y2 + (this.height / 10);

        CherryOptions c = CherryOptions.INSTANCE;

        ButtonWidget back = new ButtonWidget(20, 20, 60, 20, "<-- Back", button -> MinecraftClient.getInstance().openScreen(this.parent));

        ButtonWidget enabled = new ButtonWidget(x, y, 200, 20, fromConfig(c.enablePotionsWidget), button -> {
            c.enablePotionsWidget = !c.enablePotionsWidget;
            Startup.instance.saveConfig();
            button.setMessage(fromConfig(c.enablePotionsWidget));
        });

        ButtonWidget moveLeft = new ButtonWidget(x - 5, y2, 100, 20, "Move Left", button -> {
            CherryOptions.INSTANCE.potWidgetX -= 5;
            Startup.instance.saveConfig();
        });

        ButtonWidget moveRight = new ButtonWidget(x + 105, y2, 100, 20, "Move Right", button -> {
            CherryOptions.INSTANCE.potWidgetX += 5;
            Startup.instance.saveConfig();
        });

        ButtonWidget moveUp = new ButtonWidget(x - 5, y3, 100, 20, "Move Up", button -> {
            CherryOptions.INSTANCE.potWidgetY -= 5;
            Startup.instance.saveConfig();
        });

        ButtonWidget moveDown = new ButtonWidget(x + 105, y3, 100, 20, "Move Down", button -> {
            CherryOptions.INSTANCE.potWidgetY += 5;
            Startup.instance.saveConfig();
        });

        this.addButton(back);
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
        return (LiteralText) new LiteralText("Potions Widget").setStyle(titleStyle);
    }
}
