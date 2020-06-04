package rocks.rdil.cherry.mixins;

import net.minecraft.container.Property;
import net.minecraft.container.StonecutterContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(StonecutterContainer.class)
public class MixinStonecutterContainer {
    /**
     * Avoid resetting the selected item on stonecutters,
     * to persist the block selection between uses.
     * 
     * Taken from https://github.com/Draylar/stonecutter-tweaks
     * 
     * @param property
     * @param value
     */
    @Redirect(
        method = "updateInput",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/container/Property;set(I)V")
    )
    public void beforeReturn(Property property, int value) {}
}
