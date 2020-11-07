package rocks.rdil.cherry.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import rocks.rdil.cherry.Cherry;
import rocks.rdil.cherry.gui.widgets.WidgetSettings;

public class WidgetSettingsGuiFactory<C extends WidgetSettings> extends Screen {
    private final Screen parent;
    private final C widgetSettings;

    public WidgetSettingsGuiFactory(Screen parent, C widgetSettings, String name) {
        super(getTitleTextComponent(name));
        this.parent = parent;
        this.widgetSettings = widgetSettings;
    }

    protected void init() {
        final int x = this.width / 2 - 100;
        int y = this.height / 7;
        int y2 = y + (this.height / 10);
        int y3 = y2 + (this.height / 10);

        C c = this.widgetSettings;

        ButtonWidget enabled = new ButtonWidget(x, y, 200, 20, new LiteralText(GuiUtil.fromConfig(c.isEnabled)), button -> {
            c.isEnabled = !c.isEnabled;
            Cherry.INSTANCE.saveConfig();
            button.setMessage(new LiteralText(GuiUtil.fromConfig(c.isEnabled)));
        });

        ButtonWidget moveLeft = new ButtonWidget(x - 5, y2, 100, 20, new LiteralText("Move Left"), button -> {
           c.xPos -= 5;
           Cherry.INSTANCE.saveConfig();
        });

        ButtonWidget moveRight = new ButtonWidget(x + 105, y2, 100, 20, new LiteralText("Move Right"), button -> {
            c.xPos += 5;
            Cherry.INSTANCE.saveConfig();
        });

        ButtonWidget moveUp = new ButtonWidget(x - 5, y3, 100, 20, new LiteralText("Move Up"), button -> {
            c.yPos -= 5;
            Cherry.INSTANCE.saveConfig();
        });

        ButtonWidget moveDown = new ButtonWidget(x + 105, y3, 100, 20, new LiteralText("Move Down"), button -> {
            c.yPos += 5;
            Cherry.INSTANCE.saveConfig();
        });

        this.addButton(GuiUtil.makeBackButton(parent));
        this.addButton(moveLeft);
        this.addButton(moveRight);
        this.addButton(moveDown);
        this.addButton(moveUp);
        this.addButton(enabled);
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {
        renderBackground(matrixStack);
        drawCenteredString(matrixStack, this.textRenderer, this.title.asString(), this.width / 2, 20, 16777215);
        super.render(matrixStack, mouseX, mouseY, delta);
    }

    public static LiteralText getTitleTextComponent(String name) {
        return new LiteralText(name + " Widget Settings");
    }
}
