package rocks.rdil.cherry.mixins;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rocks.rdil.cherry.Startup;

@Mixin(TitleScreen.class)
public class MixinTitleScreen extends Screen {
    protected MixinTitleScreen(Text title) {
        super(title);
    }

    @Inject(at = @At(value = "HEAD"), method = "init")
    public void init(CallbackInfo ci) {
        if (Startup.instance.hasUpdate) {
            this.addButton(new ButtonWidget(this.width / 2 - 100, (int) (this.height * 0.9), 200, 20, "Cherry is out of date!! See cherry.rdil.rocks", (buttonWidget) -> {}));
        }
    }
}
