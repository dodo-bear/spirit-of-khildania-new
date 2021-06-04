package net.mcreator.thesuffering.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesuffering.ThesufferingModVariables;
import net.mcreator.thesuffering.ThesufferingModElements;
import net.mcreator.thesuffering.ThesufferingMod;

import java.util.Map;
import java.util.HashMap;

@ThesufferingModElements.ModElement.Tag
public class RunDiseaseEpisodeProcedure extends ThesufferingModElements.ModElement {
	public RunDiseaseEpisodeProcedure(ThesufferingModElements instance) {
		super(instance, 40);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency entity for procedure RunDiseaseEpisode!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double waittime = 0;
		if (((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ThesufferingModVariables.PlayerVariables())).IsInEpisode)) {
			if ((((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ThesufferingModVariables.PlayerVariables())).Stage) == 1)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 2, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 2, (int) 2, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 2, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 2, (int) 1, (false), (false)));
			} else if ((((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ThesufferingModVariables.PlayerVariables())).Stage) == 2)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 2, (int) 2, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 2, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 2, (int) 2, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 2, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 2, (int) 1, (false), (false)));
			} else if ((((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ThesufferingModVariables.PlayerVariables())).Stage) == 3)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 2, (int) 3, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 2, (int) 2, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 2, (int) 3, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 2, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 2, (int) 1, (false), (false)));
			}
			if (((waittime) < 2400)) {
				waittime = (double) ((waittime) + 1);
			} else {
				waittime = (double) 0;
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IsInEpisode = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
