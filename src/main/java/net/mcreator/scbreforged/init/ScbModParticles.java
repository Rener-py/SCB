
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scbreforged.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.scbreforged.client.particle.WeirdparParticle;
import net.mcreator.scbreforged.client.particle.SpiritarmorParticleParticle;
import net.mcreator.scbreforged.client.particle.PlantparticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ScbModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(ScbModParticleTypes.WEIRDPAR.get(), WeirdparParticle::provider);
		event.register(ScbModParticleTypes.SPIRITARMOR_PARTICLE.get(), SpiritarmorParticleParticle::provider);
		event.register(ScbModParticleTypes.PLANTPARTICLE.get(), PlantparticleParticle::provider);
	}
}
