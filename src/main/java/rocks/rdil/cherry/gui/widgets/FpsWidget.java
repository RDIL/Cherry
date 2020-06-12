package rocks.rdil.cherry.gui.widgets;

import lombok.NoArgsConstructor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;

@NoArgsConstructor
public class FpsWidget {
    public void render(DrawableHelper s, int x, int y) {
        if (!MinecraftClient.isHudEnabled()) {
            return;
        }

        String st = "FPS: " + MinecraftClient.getCurrentFps();
        s.drawCenteredString(MinecraftClient.getInstance().textRenderer, st, x, y, 16777215);
    }
}
