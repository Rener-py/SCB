
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scbreforged.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.scbreforged.ScbMod;

public class ScbModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ScbMod.MODID);
	public static final RegistryObject<SoundEvent> BREAKMESONG = REGISTRY.register("breakmesong", () -> new SoundEvent(new ResourceLocation("scb", "breakmesong")));
	public static final RegistryObject<SoundEvent> BREAKME_2 = REGISTRY.register("breakme_2", () -> new SoundEvent(new ResourceLocation("scb", "breakme_2")));
}
