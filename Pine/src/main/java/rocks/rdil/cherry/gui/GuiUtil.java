package rocks.rdil.cherry.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;

public class GuiUtil {
    public static ButtonWidget makeBackButton(Screen parent) {
        return new ButtonWidget(20, 20, 60, 20, new LiteralText("<-- Back"), button -> MinecraftClient.getInstance().openScreen(parent));
    }

    public static String fromConfig(boolean b) {
        return b ? "Enabled" : "Disabled";
    }
}
