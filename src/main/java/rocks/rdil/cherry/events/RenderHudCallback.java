package rocks.rdil.cherry.events;

import net.minecraft.client.gui.DrawableHelper;
import rocks.rdil.cherry.gui.widgets.FpsWidget;

public class RenderHudCallback {
    public static final RenderHudCallback INSTANCE = new RenderHudCallback();

    FpsWidget fpsWidget;
    
    public RenderHudCallback() {
        this.fpsWidget = new FpsWidget();
    }

    public void run(DrawableHelper hud) {
        this.fpsWidget.render(hud, 100, 100);
    }
}
