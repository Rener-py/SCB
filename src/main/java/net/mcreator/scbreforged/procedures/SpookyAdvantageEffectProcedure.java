package net.mcreator.scbreforged.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.scbreforged.init.ScbModMobEffects;

import java.io.File;

public class SpookyAdvantageEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		File SCB = new File("");
		com.google.gson.JsonObject main_json_object = new com.google.gson.JsonObject();
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,
					entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ScbModMobEffects.SPOOKY_ADVANTAGE.get()) ? _livEnt.getEffect(ScbModMobEffects.SPOOKY_ADVANTAGE.get()).getDuration() : 0, 0, false, false));
	}
}
