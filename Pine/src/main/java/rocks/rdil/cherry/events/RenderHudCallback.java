package rocks.rdil.cherry.events;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import rocks.rdil.cherry.Cherry;
import rocks.rdil.cherry.gui.widgets.Widget;

public class RenderHudCallback {
    public static final RenderHudCallback INSTANCE = new RenderHudCallback();

    public void run(MatrixStack matrixStack, DrawableHelper hud) {
        for (Widget w : Cherry.INSTANCE.getAllWidgets()) {
            w.render(matrixStack, hud);
        }
    }
}
