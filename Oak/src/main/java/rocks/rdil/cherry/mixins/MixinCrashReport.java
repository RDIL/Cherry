package rocks.rdil.cherry.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;
import rocks.rdil.cherry.Startup;

@Mixin(CrashReport.class)
public abstract class MixinCrashReport {
	@Shadow public abstract CrashReportSection getSystemDetailsSection();

	@Inject(at = @At("RETURN"), method = "fillSystemDetails")
	private void addCherryDetails(CallbackInfo info) {
		getSystemDetailsSection().add("Cherry Config", () -> Startup.instance.configHandler.getCfg().toString());
	}
}
