package rocks.rdil.cherry.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

public class CherryGui extends Screen {
    public CherryGui() {
        super(getTitleTextComponent());
    }

    protected void init() {
        final int x = this.width / 2 - 100;
        int y = this.height / 7;
        int y2 = y + (this.height / 10);

        ButtonWidget general = new ButtonWidget(x, y, 200, 20, new LiteralText("General Settings"), button -> MinecraftClient.getInstance().openScreen(new GeneralSettings(this)));
        ButtonWidget widgets = new ButtonWidget(x, y2, 200, 20, new LiteralText("HUD Widget Settings"), button -> MinecraftClient.getInstance().openScreen(new WidgetSettings(this)));

        this.addButton(general);
        this.addButton(widgets);
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {
        renderBackground(matrixStack);
        drawCenteredString(matrixStack, this.textRenderer, this.title.asString(), this.width / 2, 20, 16777215);
        super.render(matrixStack, mouseX, mouseY, delta);
    }

    public static LiteralText getTitleTextComponent() {
        return new LiteralText("Cherry Options");
    }
}
