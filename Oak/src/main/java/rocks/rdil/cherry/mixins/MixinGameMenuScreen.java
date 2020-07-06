package rocks.rdil.cherry.mixins;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import rocks.rdil.cherry.gui.CherryGui;

@Mixin(GameMenuScreen.class)
public class MixinGameMenuScreen extends Screen {
    protected MixinGameMenuScreen(Text title) {
        super(title);
    }

    @Inject(at = @At(value = "RETURN"), method = "initWidgets")
    public void initWidgetsTail(CallbackInfo ci) {
        this.addButton(new ButtonWidget(10, 10, 100, 20, "Cherry Settings", buttonWidget -> MinecraftClient.getInstance().openScreen(new CherryGui())));
    }
}
