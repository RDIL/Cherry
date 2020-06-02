package rocks.rdil.cherry.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import rocks.rdil.cherry.config.ConfigManager;
import rocks.rdil.cherry.config.Config;

public class CherryGui extends Screen {
    public CherryGui(Screen parent) {
        super(getTitleTextComponent());
    }

    protected void init() {
        int j = this.width / 2 - 155 + 0 % 2 * 160;
        int k = this.height / 6 + 24 * (0 >> 1);

        Config c = ConfigManager.instance.config;

        ButtonWidget toggleSprint = new ButtonWidget(j, k, 200, 20, "ToggleSprint: " + fromConfig(c.getToggleSprint()), button -> {
            c.setToggleSprint(c.getToggleSprint() == "true" ? "false" : "true");
            ConfigManager.instance.save();
            button.setMessage("ToggleSprint: " + fromConfig(c.getToggleSprint()));
        });

        j = this.width / 2 - 155 + 1 % 2 * 160;
        k = this.height / 6 + 24 * (1 >> 1);

        ButtonWidget enableTutorialPopups = new ButtonWidget(j, k, 200, 20, "Tutorial Popups: " + fromConfig(c.getEnableTutorialPopups()), button -> {
            c.setEnableTutorialPopups(c.getEnableTutorialPopups() == "true" ? "false" : "true");
            ConfigManager.instance.save();
            button.setMessage("Tutorial Popups: " + fromConfig(c.getEnableTutorialPopups()));
        });

        this.addButton(toggleSprint);
        this.addButton(enableTutorialPopups);

        this.addButton(new ButtonWidget(this.width / 2 - 100, this.height - 300, 200, 20, I18n.translate("gui.done"), (buttonWidget) -> {
            this.minecraft.openScreen(null);
        }));
    }

    private String fromConfig(String s) {
        return s == "true" ? "Enabled" : "Disabled";
    }

    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        this.drawCenteredString(this.font, this.title.asFormattedString(), this.width / 2, 20, 16777215);
        super.render(mouseX, mouseY, delta);
    }

    public static LiteralText getTitleTextComponent() {
        Style titleStyle = new Style();
        titleStyle.setBold(true);
        titleStyle.setUnderline(true);
        titleStyle.setColor(Formatting.DARK_RED);
        LiteralText title = new LiteralText("Cherry Client");
        title.setStyle(titleStyle);
        return title;
    }
}
