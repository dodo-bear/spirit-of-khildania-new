
package net.mcreator.thesuffering.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

import net.mcreator.thesuffering.block.DryTurfBlock;
import net.mcreator.thesuffering.ThesufferingModElements;

@ThesufferingModElements.ModElement.Tag
public class OrdonianWastesBiome extends ThesufferingModElements.ModElement {
	@ObjectHolder("thesuffering:ordonian_wastes")
	public static final CustomBiome biome = null;
	public OrdonianWastesBiome(ThesufferingModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 10));
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(DryTurfBlock.block.getDefaultState(),
							DryTurfBlock.block.getDefaultState(), DryTurfBlock.block.getDefaultState())));
			setRegistryName("ordonian_wastes");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addFreezeTopLayer(this);
		}
	}
}
