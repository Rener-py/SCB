package net.mcreator.scbreforged.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.BlockPos;

import net.mcreator.scbreforged.init.ScbModMobEffects;
import net.mcreator.scbreforged.init.ScbModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CleaneffectproximityProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -3;
		found = false;
		for (int index0 = 0; index0 < 8; index0++) {
			sy = -3;
			for (int index1 = 0; index1 < 8; index1++) {
				sz = -3;
				for (int index2 = 0; index2 < 8; index2++) {
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == ScbModBlocks.PLANTBLOCK.get()) {
						found = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (found == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(ScbModMobEffects.PANICKED_SPIRIT.get());
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.SLOW_FALLING);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(ScbModMobEffects.SPIRITUAL_DEFENSE.get());
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.FIRE_RESISTANCE);
		}
	}
}
