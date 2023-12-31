package net.mcreator.scbreforged.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.scbreforged.init.ScbModMobEffects;
import net.mcreator.scbreforged.init.ScbModBlocks;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class WeirdUpdateTickProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
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
		File SCB = new File("");
		com.google.gson.JsonObject main_json_object = new com.google.gson.JsonObject();
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
				if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == ScbModBlocks.PLANTBLOCK.get()) {
					world.destroyBlock(new BlockPos(x, y, z), false);
					if (Math.random() <= main_json_object.get("Spooky_Advantage_chance_(%)").getAsDouble() / 100) {
						if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(ScbModMobEffects.SPOOKY_ADVANTAGE.get(), (int) (main_json_object.get("Spooky_Advantage_Duration_(seconds)").getAsDouble() * 20), 0, false, true));
					} else if (Math.random() <= main_json_object.get("Mysterious_force_chance_(%)").getAsDouble() / 100) {
						{
							Entity _ent = entity;
							_ent.teleportTo(x, (y + 13), z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x, (y + 13), z, _ent.getYRot(), _ent.getXRot());
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("scb:breakme_2")), SoundSource.AMBIENT, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("scb:breakme_2")), SoundSource.AMBIENT, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 120, 1, false, false));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
