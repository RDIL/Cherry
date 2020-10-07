package rocks.rdil.cherry.mixins;

import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConnectScreen.class)
public abstract class MixinConnectScreen extends Screen {
    protected MixinConnectScreen(Text title) {
        super(title);
    }

    private int spinnerFrame = 0;

    @Inject(at = @At(value = "RETURN"), method = "render")
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        final String[] frames = new String[]{"|", "/", "-", "\\"};
        this.spinnerFrame = (this.spinnerFrame == 3 ? 0 : this.spinnerFrame + 1);

        drawCenteredString(matrixStack, this.textRenderer, frames[this.spinnerFrame], this.width / 2, this.height / 2, 16777215);
    }
}
