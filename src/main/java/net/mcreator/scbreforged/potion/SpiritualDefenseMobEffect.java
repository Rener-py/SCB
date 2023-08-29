
package net.mcreator.scbreforged.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.scbreforged.procedures.WhenplayerindangerProcedure;
import net.mcreator.scbreforged.procedures.SpiritFormEffectEffectExpiresProcedure;

public class SpiritualDefenseMobEffect extends MobEffect {
	public SpiritualDefenseMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16207752);
	}

	@Override
	public String getDescriptionId() {
		return "effect.scb.spiritual_defense";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		WhenplayerindangerProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
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
