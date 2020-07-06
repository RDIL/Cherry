package rocks.rdil.cherry.mixins;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MinecraftClient.class)
public interface IMixinMinecraftClient {
    @Accessor static int currentFps() {
        throw new Error("Failed to apply IMixinMinecraftClient!");
    }
}
