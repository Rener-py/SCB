package net.mcreator.scbreforged.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.item.ItemTossEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.scbreforged.init.ScbModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpiritualDefenseOnEffectActiveTickProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event, event.getPlayer(), event.getEntity().getItem());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player && entity.isAlive()) {
			if (itemstack.getItem() == ScbModItems.SPIRITUAL_ARMOR_HELMET.get() || itemstack.getItem() == ScbModItems.SPIRITUAL_ARMOR_CHESTPLATE.get() || itemstack.getItem() == ScbModItems.SPIRITUAL_ARMOR_BOOTS.get()) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
	}
}
