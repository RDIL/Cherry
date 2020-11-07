package rocks.rdil.cherry.gui;

import java.util.concurrent.atomic.AtomicInteger;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import rocks.rdil.cherry.Cherry;
import rocks.rdil.cherry.config.CherryOptions;

public class AllWidgetsSettings extends Screen {
    private final Screen parent;

    public AllWidgetsSettings(Screen parent) {
        super(getTitleTextComponent());
        this.parent = parent;
    }

    protected void init() {
        final int x = this.width / 2 - 100;
        final AtomicInteger a = new AtomicInteger(0);
        
        Cherry.INSTANCE.getAllWidgets().forEach(widget -> {
            final String widgetName = widget.getName();
            final ButtonWidget b = new ButtonWidget(
                x,
                GuiUtil.getPaddedY(this.height, a.getAndIncrement()),
                200,
                20,
                new LiteralText(widgetName + " Widget"),
                button -> MinecraftClient.getInstance().openScreen(
                    new WidgetSettingsGuiFactory<>(this, widget.getConfig(), widget.getName())
                )
            );
            this.addButton(b);
        });

        CherryOptions c = CherryOptions.INSTANCE;

        ButtonWidget squareBrace = new ButtonWidget(x, GuiUtil.getPaddedY(this.height, a.getAndIncrement()), 200, 20, new LiteralText("Use Square Braces: " + GuiUtil.fromConfig(c.widgetsUseSquareBraces)), button -> {
            c.widgetsUseSquareBraces = !c.widgetsUseSquareBraces;
            Cherry.INSTANCE.saveConfig();
            button.setMessage(new LiteralText("Use Square Braces: " + GuiUtil.fromConfig(c.widgetsUseSquareBraces)));
        });

        this.addButton(squareBrace);
        this.addButton(GuiUtil.makeBackButton(parent));
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {
        renderBackground(matrixStack);
        drawCenteredString(matrixStack, this.textRenderer, this.title.asString(), this.width / 2, 20, 16777215);
        super.render(matrixStack, mouseX, mouseY, delta);
    }

    public static LiteralText getTitleTextComponent() {
        return new LiteralText("Select a Widget");
    }
}
