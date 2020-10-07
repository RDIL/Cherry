package rocks.rdil.cherry.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import rocks.rdil.cherry.Startup;
import rocks.rdil.cherry.config.CherryOptions;

public class GeneralSettings extends Screen {
    private final Screen parent;

    public GeneralSettings(Screen parent) {
        super(getTitleTextComponent());
        this.parent = parent;
    }

    protected void init() {
        final int x = this.width / 2 - 100;
        int y = this.height / 7;
        int y2 = y + (this.height / 10);
        int y3 = y2 + (this.height / 10);
        int y4 = y3 + (this.height / 10);
        int y5 = y4 + (this.height / 10);

        CherryOptions c = CherryOptions.INSTANCE;

        ButtonWidget toggleSprint = new ButtonWidget(x, y, 200, 20, new LiteralText("ToggleSprint: " + GuiUtil.fromConfig(c.toggleSprint)), button -> {
            c.toggleSprint = !c.toggleSprint;
            Startup.INSTANCE.saveConfig();
            button.setMessage(new LiteralText("ToggleSprint: " + GuiUtil.fromConfig(c.toggleSprint)));
        });

        ButtonWidget enableTutorialPopups = new ButtonWidget(x, y2, 200, 20, new LiteralText("Tutorial Popups: " + GuiUtil.fromConfig(c.enableTutorialPopups)), button -> {
            c.enableTutorialPopups = !c.enableTutorialPopups;
            Startup.INSTANCE.saveConfig();
            button.setMessage(new LiteralText("Tutorial Popups: " + GuiUtil.fromConfig(c.enableTutorialPopups)));
        });

        ButtonWidget fullbright = new ButtonWidget(x, y3, 200, 20, new LiteralText("Fullbright: " + GuiUtil.fromConfig(c.fullbright)), button -> {
            c.fullbright = !c.fullbright;
            Startup.INSTANCE.saveConfig();
            button.setMessage(new LiteralText("Fullbright: " + GuiUtil.fromConfig(c.fullbright)));
        });

        ButtonWidget hideBats = new ButtonWidget(x, y4, 200, 20, new LiteralText("Hide Bats: " + GuiUtil.fromConfig(c.hideBats)), button -> {
            c.hideBats = !c.hideBats;
            Startup.INSTANCE.saveConfig();
            button.setMessage(new LiteralText("Hide Bats: " + GuiUtil.fromConfig(c.hideBats)));
        });

        ButtonWidget bossbarEnabled = new ButtonWidget(x, y5, 200, 20, new LiteralText("BossBar: " + GuiUtil.fromConfig(c.enableBossbar)), button -> {
            c.enableBossbar = !c.enableBossbar;
            Startup.INSTANCE.saveConfig();
            button.setMessage(new LiteralText("BossBar: " + GuiUtil.fromConfig(c.hideBats)));
        });

        this.addButton(GuiUtil.makeBackButton(parent));
        this.addButton(toggleSprint);
        this.addButton(enableTutorialPopups);
        this.addButton(fullbright);
        this.addButton(hideBats);
        this.addButton(bossbarEnabled);
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float delta) {
        renderBackground(matrixStack);
        drawCenteredString(matrixStack, this.textRenderer, this.title.asString(), this.width / 2, 20, 16777215);
        super.render(matrixStack, mouseX, mouseY, delta);
    }

    public static LiteralText getTitleTextComponent() {
        return new LiteralText("General Settings");
    }
}
