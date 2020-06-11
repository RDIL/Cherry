package rocks.rdil.cherry.gui.widgets;

import java.lang.reflect.Field;

import lombok.NoArgsConstructor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;

@NoArgsConstructor
public class FpsWidget {
    public void render(DrawableHelper s, int x, int y) {
        if (!MinecraftClient.isHudEnabled()) {
            return;
        }

        String st = "FPS: " + MinecraftClient.getCurrentFps();
        s.drawCenteredString(FontUtil.INSTANCE.getFont(), st, x, y, 16777215);
    }
}
