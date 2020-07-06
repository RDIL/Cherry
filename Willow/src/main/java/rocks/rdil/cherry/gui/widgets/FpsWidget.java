package rocks.rdil.cherry.gui.widgets;

import net.minecraft.client.MinecraftClient;
import rocks.rdil.cherry.config.CherryOptions;

import java.lang.reflect.Field;

public class FpsWidget extends Widget {
    @Override
    public String getPrefix() {
        return "FPS";
    }

    @Override
    public String getSuffix() {
        int fps = 0;

        try {
            Field f = MinecraftClient.getInstance().getClass().getDeclaredField("currentFps");
            if (!f.isAccessible()) {
                f.setAccessible(true);
            }
            fps = f.getInt(MinecraftClient.getInstance());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return String.valueOf(fps);
    }

    @Override
    public int getConfigX() {
        return CherryOptions.INSTANCE.fpsWidgetX;
    }

    @Override
    public int getConfigY() {
        return CherryOptions.INSTANCE.fpsWidgetY;
    }

    @Override
    public boolean getEnabled() {
        return CherryOptions.INSTANCE.fpsWidgetEnabled;
    }
}
