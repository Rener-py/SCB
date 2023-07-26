
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scbreforged.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.scbreforged.potion.SpookyAdvantageMobEffect;
import net.mcreator.scbreforged.potion.SpiritualDefenseMobEffect;
import net.mcreator.scbreforged.potion.SpiritFormEffectMobEffect;
import net.mcreator.scbreforged.ScbMod;

public class ScbModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ScbMod.MODID);
	public static final RegistryObject<MobEffect> SPOOKY_ADVANTAGE = REGISTRY.register("spooky_advantage", () -> new SpookyAdvantageMobEffect());
	public static final RegistryObject<MobEffect> PANICKED_SPIRIT = REGISTRY.register("panicked_spirit", () -> new SpiritFormEffectMobEffect());
	public static final RegistryObject<MobEffect> SPIRITUAL_DEFENSE = REGISTRY.register("spiritual_defense", () -> new SpiritualDefenseMobEffect());
}
