
package net.mcreator.scbreforged.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.scbreforged.procedures.SpiritFormRespawnProcedure;
import net.mcreator.scbreforged.procedures.SpiritFormEffectEffectExpiresProcedure;

public class SpiritFormEffectMobEffect extends MobEffect {
	public SpiritFormEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -14636138);
	}

	@Override
	public String getDescriptionId() {
		return "effect.scb.panicked_spirit";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		SpiritFormRespawnProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		SpiritFormEffectEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
