package net.mcreator.thesuffering.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.thesuffering.ThesufferingModVariables;
import net.mcreator.thesuffering.ThesufferingModElements;
import net.mcreator.thesuffering.ThesufferingMod;

import java.util.Map;
import java.util.HashMap;

@ThesufferingModElements.ModElement.Tag
public class DiseaseManagerOnTickProcedure extends ThesufferingModElements.ModElement {
	public DiseaseManagerOnTickProcedure(ThesufferingModElements instance) {
		super(instance, 38);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency entity for procedure DiseaseManagerOnTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double waittime = 0;
		if ((!(((entity.getCapability(ThesufferingModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ThesufferingModVariables.PlayerVariables())).Stage) == 0))) {
			if (((waittime) < 12000)) {
				waittime = (double) ((waittime) + 1);
			} else {
				waittime = (double) 0;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					StartDiseaseEpisodeProcedure.executeProcedure($_dependencies);
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
