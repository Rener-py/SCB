
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scbreforged.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.scbreforged.ScbMod;

public class ScbModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ScbMod.MODID);
	public static final RegistryObject<SimpleParticleType> WEIRDPAR = REGISTRY.register("weirdpar", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SPIRITARMOR_PARTICLE = REGISTRY.register("spiritarmor_particle", () -> new SimpleParticleType(true));
}
