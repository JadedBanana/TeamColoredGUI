package com.github.jadedbanana.teamindicatorsplus.mixin;

import com.github.jadedbanana.teamindicatorsplus.TeamIndicatorsPlus;
import com.github.jadedbanana.teamindicatorsplus.TeamTextureFinder;
import net.minecraft.client.render.entity.SpectralArrowEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpectralArrowEntityRenderer.class)
public abstract class SpectralArrowEntityRendererMixin {

    /*
    Redirect for getTexture.
    Will simply see if the person who fired the arrow has a team, and if so, recolors the arrow to have that team.
     */
    @Inject(method = "getTexture(Lnet/minecraft/entity/projectile/SpectralArrowEntity;)Lnet/minecraft/util/Identifier;",
            at = @At("HEAD"), cancellable = true)
    private void injectGetTexture(SpectralArrowEntity arrowEntity, CallbackInfoReturnable<Identifier> cir) {
        // Only run this method if the mod is enabled. If not, just do the normal intended call.
        if (TeamIndicatorsPlus.CONFIG.ENABLED) {

            // Check for team.
            Entity arrowOwner = arrowEntity.getOwner();
            if (arrowOwner != null && arrowOwner.getScoreboardTeam() != null) {
                Identifier new_id = TeamTextureFinder.getSpectralArrowTexture(arrowOwner.getScoreboardTeam());
                if (new_id != null)
                    cir.setReturnValue(new_id);
            }
        }
    }

}
