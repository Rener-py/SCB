package net.mcreator.scbreforged.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.scbreforged.init.ScbModMobEffects;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class SpiritFormRespawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main_json_object = new com.google.gson.JsonObject();
		File SCB = new File("");
		SCB = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "SpiritualComeBack_config.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(SCB));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				main_json_object = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if (main_json_object.get("Panicked_Spirit_Speed").getAsBoolean() == true) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,
								entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ScbModMobEffects.PANICKED_SPIRIT.get()) ? _livEnt.getEffect(ScbModMobEffects.PANICKED_SPIRIT.get()).getDuration() : 0,
								(int) (main_json_object.get("Panicked_Spirit_Speed_level").getAsDouble() - 1), false, false));
				}
				if (main_json_object.get("Panicked_Spirit_Slow_falling").getAsBoolean() == true) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING,
								entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ScbModMobEffects.PANICKED_SPIRIT.get()) ? _livEnt.getEffect(ScbModMobEffects.PANICKED_SPIRIT.get()).getDuration() : 0,
								(int) (main_json_object.get("Panicked_Spirit_Slow_falling_level").getAsDouble() - 1), false, false));
				}
				if (main_json_object.get("Panicked_Spirit_Fire_resistance").getAsBoolean() == true) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,
								entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ScbModMobEffects.PANICKED_SPIRIT.get()) ? _livEnt.getEffect(ScbModMobEffects.PANICKED_SPIRIT.get()).getDuration() : 0,
								(int) (main_json_object.get("Panicked_Spirit_Fire_resistance_level").getAsDouble() - 1), false, false));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
