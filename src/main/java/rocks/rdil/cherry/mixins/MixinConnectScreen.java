package rocks.rdil.cherry.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ConnectScreen.class)
public abstract class MixinConnectScreen extends Screen {
    @SuppressWarnings("unused")
    protected MixinConnectScreen(Text title) {
        super(title);
    }

    private int spinnerFrame = 0;
    @Shadow private Text status;

    /**
     * Render the screen.
     * 
     * @author Reece Dunham and Mojang
     * @reason Add the spinner while connecting.
     */
    @Overwrite
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();

        final String[] frames = new String[]{"|", "/", "-", "\\"};
        this.spinnerFrame = (this.spinnerFrame == 3? 0 : this.spinnerFrame + 1);

        this.drawCenteredString(this.font, this.status.asFormattedString(), this.width / 2, this.height / 2 - 50, 16777215);
        this.drawCenteredString(this.font, frames[this.spinnerFrame], this.width / 2, this.height / 2, 16777215);

        super.render(mouseX, mouseY, delta);
    }
}
