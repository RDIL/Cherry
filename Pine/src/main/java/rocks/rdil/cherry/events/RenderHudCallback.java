package rocks.rdil.cherry.events;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import rocks.rdil.cherry.gui.widgets.FpsWidget;
import rocks.rdil.cherry.gui.widgets.PotionsWidget;

public class RenderHudCallback {
    public static final RenderHudCallback INSTANCE = new RenderHudCallback();

    final FpsWidget fpsWidget;
    final PotionsWidget potionsWidget;
    
    public RenderHudCallback() {
        this.fpsWidget = new FpsWidget();
        this.potionsWidget = new PotionsWidget();
    }

    public void run(MatrixStack matrixStack, DrawableHelper hud) {
        this.fpsWidget.render(matrixStack, hud);
        this.potionsWidget.render(matrixStack, hud);
    }
}
