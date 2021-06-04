
package net.mcreator.thesuffering.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.thesuffering.item.SmallCapsuleItem;
import net.mcreator.thesuffering.ThesufferingModElements;

@ThesufferingModElements.ModElement.Tag
public class TheSufferingItemGroup extends ThesufferingModElements.ModElement {
	public TheSufferingItemGroup(ThesufferingModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabthe_suffering") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SmallCapsuleItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
