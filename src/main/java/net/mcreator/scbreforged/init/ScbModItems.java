
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.scbreforged.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.scbreforged.item.SpiritualArmorItem;
import net.mcreator.scbreforged.ScbMod;

public class ScbModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ScbMod.MODID);
	public static final RegistryObject<Item> WEIRD = block(ScbModBlocks.WEIRD, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> SPIRITUAL_ARMOR_HELMET = REGISTRY.register("spiritual_armor_helmet", () -> new SpiritualArmorItem.Helmet());
	public static final RegistryObject<Item> SPIRITUAL_ARMOR_CHESTPLATE = REGISTRY.register("spiritual_armor_chestplate", () -> new SpiritualArmorItem.Chestplate());
	public static final RegistryObject<Item> SPIRITUAL_ARMOR_BOOTS = REGISTRY.register("spiritual_armor_boots", () -> new SpiritualArmorItem.Boots());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
