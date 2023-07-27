
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scbreforged.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.scbreforged.block.PlantblockBlock;
import net.mcreator.scbreforged.ScbMod;

public class ScbModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ScbMod.MODID);
	public static final RegistryObject<Block> PLANTBLOCK = REGISTRY.register("plantblock", () -> new PlantblockBlock());
}
