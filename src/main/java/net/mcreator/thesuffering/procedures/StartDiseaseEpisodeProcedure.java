package net.mcreator.thesuffering.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.thesuffering.ThesufferingModVariables;
import net.mcreator.thesuffering.ThesufferingModElements;
import net.mcreator.thesuffering.ThesufferingMod;

import java.util.Map;

@ThesufferingModElements.ModElement.Tag
public class StartDiseaseEpisodeProcedure extends ThesufferingModElements.ModElement {
	public StartDiseaseEpisodeProcedure(ThesufferingModElements instance) {
		super(instance, 39);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency entity for procedure StartDiseaseEpisode!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (boolean) (true);
			entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.IsInEpisode = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
