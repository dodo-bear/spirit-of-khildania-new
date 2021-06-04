package net.mcreator.thesuffering.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesuffering.potion.SeerPotion;
import net.mcreator.thesuffering.ThesufferingModVariables;
import net.mcreator.thesuffering.ThesufferingModElements;
import net.mcreator.thesuffering.ThesufferingMod;

import java.util.Map;

@ThesufferingModElements.ModElement.Tag
public class EnergizedLapizEatProcedure extends ThesufferingModElements.ModElement {
	public EnergizedLapizEatProcedure(ThesufferingModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency entity for procedure EnergizedLapizEat!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ThesufferingModVariables.PlayerVariables())).Hastakentonic)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SeerPotion.potion, (int) 200, (int) 1));
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 1));
		}
	}
}
