package net.mcreator.thesuffering.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thesuffering.ThesufferingModVariables;
import net.mcreator.thesuffering.ThesufferingModElements;
import net.mcreator.thesuffering.ThesufferingMod;

import java.util.Map;

@ThesufferingModElements.ModElement.Tag
public class VoltBurstRifleCanFireProcedure extends ThesufferingModElements.ModElement {
	public VoltBurstRifleCanFireProcedure(ThesufferingModElements instance) {
		super(instance, 26);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency entity for procedure VoltBurstRifleCanFire!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean canfire = false;
		if ((((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ThesufferingModVariables.PlayerVariables())).Bulletsrifle) > 0)) {
			canfire = (boolean) (true);
		} else {
			canfire = (boolean) (false);
		}
		return (canfire);
	}
}
