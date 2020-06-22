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

        ButtonWidget back = new ButtonWidget(20, 20, 60, 20, "<-- Back", button -> MinecraftClient.getInstance().openScreen(this.parent));

        ButtonWidget toggleSprint = new ButtonWidget(x, y, 200, 20, "ToggleSprint: " + fromConfig(c.toggleSprint), button -> {
            c.toggleSprint = !c.toggleSprint;
            Startup.instance.saveConfig();
            button.setMessage("ToggleSprint: " + fromConfig(c.toggleSprint));
        });

        ButtonWidget enableTutorialPopups = new ButtonWidget(x, y2, 200, 20, "Tutorial Popups: " + fromConfig(c.enableTutorialPopups), button -> {
            c.enableTutorialPopups = !c.enableTutorialPopups;
            Startup.instance.saveConfig();
            button.setMessage("Tutorial Popups: " + fromConfig(c.enableTutorialPopups));
        });

        ButtonWidget fullbright = new ButtonWidget(x, y3, 200, 20, "Fullbright: " + fromConfig(c.fullbright), button -> {
            c.fullbright = !c.fullbright;
            Startup.instance.saveConfig();
            button.setMessage("Fullbright: " + fromConfig(c.fullbright));
        });

        ButtonWidget hideBats = new ButtonWidget(x, y4, 200, 20, "Hide Bats: " + fromConfig(c.hideBats), button -> {
            c.hideBats = !c.hideBats;
            Startup.instance.saveConfig();
            button.setMessage("Hide Bats: " + fromConfig(c.hideBats));
        });

        ButtonWidget bossbarEnabled = new ButtonWidget(x, y5, 200, 20, "BossBar: " + fromConfig(c.enableBossbar), button -> {
            c.enableBossbar = !c.enableBossbar;
            Startup.instance.saveConfig();
            button.setMessage("BossBar: " + fromConfig(c.hideBats));
        });

        this.addButton(back);
        this.addButton(toggleSprint);
        this.addButton(enableTutorialPopups);
        this.addButton(fullbright);
        this.addButton(hideBats);
        this.addButton(bossbarEnabled);
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
        return (LiteralText) new LiteralText("General Settings").setStyle(titleStyle);
    }
}
