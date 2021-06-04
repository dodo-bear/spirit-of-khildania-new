package net.mcreator.thesuffering.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thesuffering.ThesufferingModVariables;
import net.mcreator.thesuffering.ThesufferingModElements;
import net.mcreator.thesuffering.ThesufferingMod;

import java.util.Map;

@ThesufferingModElements.ModElement.Tag
public class VoltBurstRifleFireProcedure extends ThesufferingModElements.ModElement {
	public VoltBurstRifleFireProcedure(ThesufferingModElements instance) {
		super(instance, 26);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency entity for procedure VoltBurstRifleFire!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ThesufferingModVariables.PlayerVariables())).Bulletsrifle) > 0)) {
			{
				double _setval = (double) (((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ThesufferingModVariables.PlayerVariables())).Bulletsrifle) - 1);
				entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Bulletsrifle = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
