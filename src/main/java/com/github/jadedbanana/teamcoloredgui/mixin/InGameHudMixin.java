package com.github.jadedbanana.teamcoloredgui.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

	@Shadow
	protected static Identifier WIDGETS_TEXTURE;

	// Color Values:
	// null: 16777215
	// aqua: 5636095
	// black: 0
	// blue: 5592575
	// dark aqua: 43690
	// dark blue: 170
	// dark gray: 5592405
	// dark green: 43520
	// dark purple: 11141290
	// dark red: 11141120
	// gold: 16755200
	// gray: 11184810
	// green: 5635925
	// light purple: 16733695
	// red: 16733525
	// white: 16777215
	// yellow: 16777045

	@Shadow
	protected abstract PlayerEntity getCameraPlayer();


	/*
		Redirect for the setShaderTexture calls in renderHotbar.
		Will detect which texture is being replaced and will substitute if needed.
		If not needed, will call the method as normal.
	 */
	@Redirect(method = "renderHotbar", at = @At(value = "INVOKE",
			target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/util/Identifier;)V")
	)
	private void redirectSetShaderTexture_renderHotbar(int texture, Identifier id) {
		// Custom texture injection only occurs if player is on a team AND the team color isn't null.
		Identifier new_id = null;

		// Check for team.
		PlayerEntity playerEntity = this.getCameraPlayer();
		if (playerEntity.getScoreboardTeam() != null) {

			// Check which texture we're replacing and call the appropriate texture replacement function.
			// Hotbar.
			if (id == WIDGETS_TEXTURE) {
				// TODO: create new_id function
				new_id = id;
			}
		}

		// Set the shader texture.
		RenderSystem.setShaderTexture(texture, new_id == null ? id : new_id);
	}

}