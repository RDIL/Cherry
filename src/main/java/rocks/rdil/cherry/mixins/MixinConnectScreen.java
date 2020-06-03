package rocks.rdil.cherry.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;

@Mixin(ConnectScreen.class)
public abstract class MixinConnectScreen extends Screen {
    protected MixinConnectScreen(Text title) {
        super(title);
    }

    private int spinnerFrame = 0;
    @Shadow Text status = null;
    @Shadow long field_19097 = (long) 0F;

    /**
     * Render the screen.
     * 
     * @author Reece Dunham and Mojang
     * @reason Add the spinner while connecting.
     */
    @Overwrite
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        long l = Util.getMeasuringTimeMs();
        if (l - this.field_19097 > 2000L) {
            this.field_19097 = l;
            NarratorManager.INSTANCE.narrate((new TranslatableText("narrator.joining", new Object[0])).getString());
        }

        String[] frames = new String[]{"|", "/", "-", "\\"};
        this.spinnerFrame = (this.spinnerFrame == 3? 0 : this.spinnerFrame + 1);

        this.drawCenteredString(this.font, this.status.asFormattedString(), this.width / 2, this.height / 2 - 50, 16777215);
        this.drawCenteredString(this.font, frames[this.spinnerFrame], this.width / 2, this.height / 2, 16777215);

        super.render(mouseX, mouseY, delta);
    }
}
