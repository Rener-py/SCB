
package net.mcreator.scbreforged.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.scbreforged.procedures.SpookyAdvantageEffectProcedure;

public class SpookyAdvantageMobEffect extends MobEffect {
	public SpookyAdvantageMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -509839);
	}

	@Override
	public String getDescriptionId() {
		return "effect.scb.spooky_advantage";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		SpookyAdvantageEffectProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
