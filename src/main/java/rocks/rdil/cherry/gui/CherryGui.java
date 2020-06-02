package rocks.rdil.cherry.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import rocks.rdil.cherry.config.ConfigManager;
import rocks.rdil.cherry.config.Config;

public class CherryGui extends Screen {
    public CherryGui() {
        super(getTitleTextComponent());
    }

    protected void init() {
        final int x = this.width / 2 - 100;
        int y = this.height / 6;

        System.out.println(this.height);

        Config c = ConfigManager.instance.config;

        ButtonWidget toggleSprint = new ButtonWidget(x, y, 200, 20, "ToggleSprint: " + fromConfig(c.getToggleSprint()), button -> {
            c.setToggleSprint(c.getToggleSprint().equals("true") ? "false" : "true");
            ConfigManager.instance.save();
            button.setMessage("ToggleSprint: " + fromConfig(c.getToggleSprint()));
        });

        int y2 = y + (this.height / 8);

        ButtonWidget enableTutorialPopups = new ButtonWidget(x, y2, 200, 20, "Tutorial Popups: " + fromConfig(c.getEnableTutorialPopups()), button -> {
            c.setEnableTutorialPopups(c.getEnableTutorialPopups().equals("true") ? "false" : "true");
            ConfigManager.instance.save();
            button.setMessage("Tutorial Popups: " + fromConfig(c.getEnableTutorialPopups()));
        });

        this.addButton(toggleSprint);
        this.addButton(enableTutorialPopups);
    }

    private String fromConfig(String s) {
        return s.equals("true") ? "Enabled" : "Disabled";
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
