package rocks.rdil.cherry.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.client.input.Input;
import net.minecraft.client.tutorial.TutorialManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rocks.rdil.cherry.config.CherryOptions;

@Mixin(TutorialManager.class)
public class MixinTutorialManager {
    @Inject(at = @At("HEAD"), method = "onBlockAttacked", cancellable = true)
    public void onBlockAttacked(ClientWorld world, BlockPos pos, BlockState state, float f, CallbackInfo ci) {
        if (!CherryOptions.INSTANCE.enableTutorialPopups) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "onSlotUpdate", cancellable = true)
    public void onSlotUpdate(ItemStack itemStack, CallbackInfo ci) {
        if (!CherryOptions.INSTANCE.enableTutorialPopups) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "onInventoryOpened", cancellable = true)
    public void onInventoryOpened(CallbackInfo ci) {
        if (!CherryOptions.INSTANCE.enableTutorialPopups) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "onUpdateMouse", cancellable = true)
    public void onUpdateMouse(double deltaX, double deltaY, CallbackInfo ci) {
        if (!CherryOptions.INSTANCE.enableTutorialPopups) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "onMovement", cancellable = true)
    public void onMovement(Input input, CallbackInfo ci) {
        if (!CherryOptions.INSTANCE.enableTutorialPopups) {
            ci.cancel();
        }
    }

    @Inject(at = @At("HEAD"), method = "tick()V", cancellable = true)
    public void tick(CallbackInfo ci) {
        if (!CherryOptions.INSTANCE.enableTutorialPopups) {
            ci.cancel();
        }
    }
}
