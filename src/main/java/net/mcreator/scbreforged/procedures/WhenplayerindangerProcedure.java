package net.mcreator.scbreforged.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.scbreforged.network.ScbModVariables;
import net.mcreator.scbreforged.init.ScbModMobEffects;
import net.mcreator.scbreforged.init.ScbModItems;

import javax.annotation.Nullable;

import java.util.Iterator;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class WhenplayerindangerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
				if (main_json_object.get("Spiritual_Defense_Effect").getAsBoolean() == true) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(ScbModMobEffects.PANICKED_SPIRIT.get()) : false) && entity instanceof Player) {
						if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(ScbModMobEffects.SPIRITUAL_DEFENSE.get(),
									entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ScbModMobEffects.PANICKED_SPIRIT.get()) ? _livEnt.getEffect(ScbModMobEffects.PANICKED_SPIRIT.get()).getDuration() : 0, 0, false, true));
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(ScbModMobEffects.SPIRITUAL_DEFENSE.get()) : false)
								&& (entity.getCapability(ScbModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ScbModVariables.PlayerVariables())).scb_timer <= 0) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("scb:spiritual_armor_get")), SoundSource.PLAYERS, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("scb:spiritual_armor_get")), SoundSource.PLAYERS, 1, 1, false);
								}
							}
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(ScbModItems.SPIRITUAL_ARMOR_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ScbModItems.SPIRITUAL_ARMOR_HELMET.get()));
								}
							}
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(ScbModItems.SPIRITUAL_ARMOR_CHESTPLATE.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ScbModItems.SPIRITUAL_ARMOR_CHESTPLATE.get()));
								}
							}
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(ScbModItems.SPIRITUAL_ARMOR_BOOTS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(ScbModItems.SPIRITUAL_ARMOR_BOOTS.get()));
								}
							}
							if (entity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("scb:adv_2"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									Iterator _iterator = _ap.getRemainingCriteria().iterator();
									while (_iterator.hasNext())
										_player.getAdvancements().award(_adv, (String) _iterator.next());
								}
							}
							{
								double _setval = 100;
								entity.getCapability(ScbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.scb_timer = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							{
								double _setval = (entity.getCapability(ScbModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ScbModVariables.PlayerVariables())).scb_timer - 1;
								entity.getCapability(ScbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.scb_timer = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
