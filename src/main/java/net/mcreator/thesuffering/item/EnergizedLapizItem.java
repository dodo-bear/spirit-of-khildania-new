
package net.mcreator.thesuffering.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.thesuffering.procedures.EnergizedLapizEatProcedure;
import net.mcreator.thesuffering.itemgroup.TheSufferingItemGroup;
import net.mcreator.thesuffering.ThesufferingModElements;

import java.util.Map;
import java.util.HashMap;

@ThesufferingModElements.ModElement.Tag
public class EnergizedLapizItem extends ThesufferingModElements.ModElement {
	@ObjectHolder("thesuffering:energized_lapiz")
	public static final Item block = null;
	public EnergizedLapizItem(ThesufferingModElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(TheSufferingItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(0f).setAlwaysEdible().build()));
			setRegistryName("energized_lapiz");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 15;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				EnergizedLapizEatProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
