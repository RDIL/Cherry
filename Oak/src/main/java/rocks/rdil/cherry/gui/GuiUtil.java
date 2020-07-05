package rocks.rdil.cherry.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;

public class GuiUtil {
    public static ButtonWidget makeBackButton(Screen parent) {
        return new ButtonWidget(20, 20, 60, 20, "<-- Back", button -> MinecraftClient.getInstance().openScreen(parent));
    }
}
