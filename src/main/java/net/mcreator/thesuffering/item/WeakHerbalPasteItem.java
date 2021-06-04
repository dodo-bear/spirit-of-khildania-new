
package net.mcreator.thesuffering.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.thesuffering.itemgroup.TheSufferingItemGroup;
import net.mcreator.thesuffering.ThesufferingModElements;

@ThesufferingModElements.ModElement.Tag
public class WeakHerbalPasteItem extends ThesufferingModElements.ModElement {
	@ObjectHolder("thesuffering:weak_herbal_paste")
	public static final Item block = null;
	public WeakHerbalPasteItem(ThesufferingModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TheSufferingItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("weak_herbal_paste");
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
