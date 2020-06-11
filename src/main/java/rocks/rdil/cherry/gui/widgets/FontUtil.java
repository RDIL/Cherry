package rocks.rdil.cherry.gui.widgets;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class FontUtil extends Screen {
    public static final FontUtil INSTANCE = new FontUtil(null);

    protected FontUtil(Text title) {
        super(title);
    }

    public TextRenderer getFont() {
        return this.font;
    }
}
