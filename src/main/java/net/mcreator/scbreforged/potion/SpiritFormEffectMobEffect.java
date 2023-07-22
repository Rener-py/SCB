
package net.mcreator.scbreforged.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.scbreforged.procedures.SpiritFormRespawnProcedure;

public class SpiritFormEffectMobEffect extends MobEffect {
	public SpiritFormEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16724788);
	}

	@Override
	public String getDescriptionId() {
		return "effect.scb.spirit_form_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		SpiritFormRespawnProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
