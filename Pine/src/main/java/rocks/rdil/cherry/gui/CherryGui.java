package rocks.rdil.cherry.gui;

import java.util.concurrent.atomic.AtomicInteger;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

public class CherryGui extends Screen {
    private final Screen parent;

    public CherryGui(Screen parent) {
        super(getTitleTextComponent());
        this.parent = parent;
    }

    protected void init() {
        final int x = this.width / 2 - 100;
        final AtomicInteger a = new AtomicInteger(0);

        ButtonWidget general = new ButtonWidget(x, GuiUtil.getPaddedY(this.height, a.getAndIncrement()), 200, 20, new LiteralText("General Settings"), button -> MinecraftClient.getInstance().openScreen(new GeneralSettings(this)));
        ButtonWidget widgets = new ButtonWidget(x, GuiUtil.getPaddedY(this.height, a.getAndIncrement()), 200, 20, new LiteralText("HUD Widgets Settings"), button -> MinecraftClient.getInstance().openScreen(new AllWidgetsSettings(this)));

        this.addButton(general);
        this.addButton(widgets);
        this.addButton(GuiUtil.makeBackButton(this.parent));
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {
        renderBackground(matrixStack);
        drawCenteredString(matrixStack, this.textRenderer, this.title.asString(), this.width / 2, 20, 16777215);
        super.render(matrixStack, mouseX, mouseY, delta);
    }

    public static LiteralText getTitleTextComponent() {
        return new LiteralText("Cherry Settings");
    }
}
