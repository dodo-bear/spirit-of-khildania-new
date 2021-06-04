
package net.mcreator.thesuffering.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.thesuffering.itemgroup.TheSufferingItemGroup;
import net.mcreator.thesuffering.ThesufferingModElements;

import java.util.List;
import java.util.Collections;

@ThesufferingModElements.ModElement.Tag
public class MetalStairsBlock extends ThesufferingModElements.ModElement {
	@ObjectHolder("thesuffering:metal_stairs")
	public static final Block block = null;
	public MetalStairsBlock(ThesufferingModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(TheSufferingItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1f, 10f).lightValue(0)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE)).getDefaultState(),
					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(2)
							.harvestTool(ToolType.PICKAXE));
			setRegistryName("metal_stairs");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
