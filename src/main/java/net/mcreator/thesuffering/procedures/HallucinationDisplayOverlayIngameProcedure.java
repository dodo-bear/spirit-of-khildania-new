package net.mcreator.thesuffering.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesuffering.potion.SeerPotion;
import net.mcreator.thesuffering.ThesufferingModVariables;
import net.mcreator.thesuffering.ThesufferingModElements;
import net.mcreator.thesuffering.ThesufferingMod;

import java.util.Map;
import java.util.Collection;

@ThesufferingModElements.ModElement.Tag
public class HallucinationDisplayOverlayIngameProcedure extends ThesufferingModElements.ModElement {
	public HallucinationDisplayOverlayIngameProcedure(ThesufferingModElements instance) {
		super(instance, 30);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency entity for procedure HallucinationDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean effect = false;
		if (((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ThesufferingModVariables.PlayerVariables())).Hastakentonic)) {
			if ((new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == SeerPotion.potion)
								return true;
						}
					}
					return false;
				}
			}.check(entity))) {
				effect = (boolean) (true);
			} else {
				effect = (boolean) (false);
			}
		}
		return (effect);
	}
}
