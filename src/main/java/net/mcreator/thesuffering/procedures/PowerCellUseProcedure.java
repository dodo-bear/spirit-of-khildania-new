package net.mcreator.thesuffering.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesuffering.item.PowerCellItem;
import net.mcreator.thesuffering.ThesufferingModVariables;
import net.mcreator.thesuffering.ThesufferingModElements;
import net.mcreator.thesuffering.ThesufferingMod;

import java.util.Map;

@ThesufferingModElements.ModElement.Tag
public class PowerCellUseProcedure extends ThesufferingModElements.ModElement {
	public PowerCellUseProcedure(ThesufferingModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency entity for procedure PowerCellUse!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ThesufferingModVariables.PlayerVariables())).Bulletsrifle) == 0)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(PowerCellItem.block, (int) (1));
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
			}
			{
				double _setval = (double) (((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ThesufferingModVariables.PlayerVariables())).Bulletsrifle) + 12);
				entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Bulletsrifle = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
