
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scbreforged.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.scbreforged.potion.SpookyAdvantageMobEffect;
import net.mcreator.scbreforged.potion.SpiritFormEffectMobEffect;
import net.mcreator.scbreforged.ScbMod;

public class ScbModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ScbMod.MODID);
	public static final RegistryObject<MobEffect> SPOOKY_ADVANTAGE = REGISTRY.register("spooky_advantage", () -> new SpookyAdvantageMobEffect());
	public static final RegistryObject<MobEffect> SPIRIT_FORM_EFFECT = REGISTRY.register("spirit_form_effect", () -> new SpiritFormEffectMobEffect());
}
