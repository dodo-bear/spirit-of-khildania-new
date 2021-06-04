
package net.mcreator.thesuffering.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.thesuffering.itemgroup.TheSufferingItemGroup;
import net.mcreator.thesuffering.ThesufferingModElements;

@ThesufferingModElements.ModElement.Tag
public class GelatinCasingItem extends ThesufferingModElements.ModElement {
	@ObjectHolder("thesuffering:gelatin_casing")
	public static final Item block = null;
	public GelatinCasingItem(ThesufferingModElements instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TheSufferingItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("gelatin_casing");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
