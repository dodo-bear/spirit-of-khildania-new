package net.mcreator.thesuffering.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.thesuffering.ThesufferingModVariables;
import net.mcreator.thesuffering.ThesufferingModElements;
import net.mcreator.thesuffering.ThesufferingMod;

import java.util.Random;
import java.util.Map;

@ThesufferingModElements.ModElement.Tag
public class OnCapsuleUsedProcedure extends ThesufferingModElements.ModElement {
	public OnCapsuleUsedProcedure(ThesufferingModElements instance) {
		super(instance, 38);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency entity for procedure OnCapsuleUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency itemstack for procedure OnCapsuleUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			boolean _setval = (boolean) (false);
			entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.IsInEpisode = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			ItemStack _ist = (itemstack);
			if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
	}
}
