package rocks.rdil.cherry.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.client.ClientBrandRetriever;

@Mixin(ClientBrandRetriever.class)
public class MixinClientBrandRetriever {
    /**
     * Set the client brand to Cherry.
     * 
     * @author Reece Dunham
     * @reason Have it noted in crash reports.
     */
    @Overwrite
    public String getClientModName() {
        return "Cherry";
    }
}
