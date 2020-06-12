package rocks.rdil.cherry.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;

public class CherryGui extends Screen {
    public CherryGui() {
        super(getTitleTextComponent());
    }

    protected void init() {
        final int x = this.width / 2 - 100;
        int y = this.height / 7;
        int y2 = y + (this.height / 10);

        ButtonWidget general = new ButtonWidget(x, y, 200, 20, "General Settings", button -> MinecraftClient.getInstance().openScreen(new GeneralSettings(this)));
        ButtonWidget widgets = new ButtonWidget(x, y2, 200, 20, "HUD Widget Settings", button -> MinecraftClient.getInstance().openScreen(new WidgetSettings(this)));

        this.addButton(general);
        this.addButton(widgets);
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
        return (LiteralText) new LiteralText("Cherry Client").setStyle(titleStyle);
    }
}
