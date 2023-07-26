package net.mcreator.scbreforged.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BeforehurttestProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		double deathy = 0;
		double deathx = 0;
		double deathz = 0;
		boolean found = false;
	}
}
