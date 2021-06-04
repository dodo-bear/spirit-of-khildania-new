
package net.mcreator.thesuffering.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.thesuffering.procedures.VoltBurstRifleCanFireProcedure;
import net.mcreator.thesuffering.ThesufferingModVariables;
import net.mcreator.thesuffering.ThesufferingModElements;

import com.google.common.collect.ImmutableMap;

@ThesufferingModElements.ModElement.Tag
public class BulletsinrifleOverlay extends ThesufferingModElements.ModElement {
	public BulletsinrifleOverlay(ThesufferingModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (true) {
				if (VoltBurstRifleCanFireProcedure.executeProcedure(ImmutableMap.of("entity", entity)))
					Minecraft.getInstance().fontRenderer.drawString(
							"" + (int) ((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ThesufferingModVariables.PlayerVariables())).Bulletsrifle) + " charges left.",
							posX + 98, posY + 103, -16730130);
			}
		}
	}
}
