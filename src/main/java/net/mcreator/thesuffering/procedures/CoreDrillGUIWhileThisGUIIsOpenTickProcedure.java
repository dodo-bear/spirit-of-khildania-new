package net.mcreator.thesuffering.procedures;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thesuffering.ThesufferingModElements;
import net.mcreator.thesuffering.ThesufferingMod;

import java.util.function.Supplier;
import java.util.Map;

@ThesufferingModElements.ModElement.Tag
public class CoreDrillGUIWhileThisGUIIsOpenTickProcedure extends ThesufferingModElements.ModElement {
	public CoreDrillGUIWhileThisGUIIsOpenTickProcedure(ThesufferingModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ThesufferingMod.LOGGER.warn("Failed to load dependency entity for procedure CoreDrillGUIWhileThisGUIIsOpenTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.3)) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI, (int) (1));
						_setstack.setCount((int) ((new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof ServerPlayerEntity) {
									Container _current = ((ServerPlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
											if (stack != null)
												return stack.getCount();
										}
									}
								}
								return 0;
							}
						}.getAmount((int) (0))) + 1));
						((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		}
	}
}
