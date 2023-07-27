package net.mcreator.scbreforged.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.scbreforged.init.ScbModParticleTypes;

public class PartickleupdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double posY = 0;
		world.addParticle((SimpleParticleType) (ScbModParticleTypes.WEIRDPAR.get()), (x + 0.5), (y + 0.5), (z + 0.5), 0, 1, 0);
	}
}
