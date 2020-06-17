package rocks.rdil.cherry.events;

import net.minecraft.client.gui.DrawableHelper;
import rocks.rdil.cherry.gui.widgets.FpsWidget;
import rocks.rdil.cherry.gui.widgets.PotionsWidget;

public class RenderHudCallback {
    public static final RenderHudCallback INSTANCE = new RenderHudCallback();

    FpsWidget fpsWidget;
    PotionsWidget potionsWidget;
    
    public RenderHudCallback() {
        this.fpsWidget = new FpsWidget();
        this.potionsWidget = new PotionsWidget();
    }

    public void run(DrawableHelper hud) {
        this.fpsWidget.render(hud);
        this.potionsWidget.render(hud);
    }
}
