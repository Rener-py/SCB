package net.mcreator.scbreforged.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.scbreforged.init.ScbModItems;
import net.mcreator.scbreforged.init.ScbModBlocks;

import javax.annotation.Nullable;

import java.util.Map;

@Mod.EventBusSubscriber
public class DeadblockProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((entity instanceof Player || entity instanceof ServerPlayer) && ScbModBlocks.PLANTBLOCK.get().defaultBlockState().canSurvive(world, new BlockPos(x, y, z))) {
			{
				BlockPos _pos = new BlockPos(x + 1, y + 2, z);
				Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
			{
				BlockPos _pos = new BlockPos(x + 1, y + 3, z);
				Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
			{
				BlockPos _pos = new BlockPos(x + 1, y + 4, z);
				Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
			{
				BlockPos _bp = new BlockPos(x + 1, y + 5, z);
				BlockState _bs = ScbModBlocks.PLANTBLOCK.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(ScbModItems.SPIRITUAL_ARMOR_HELMET.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 45, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(ScbModItems.SPIRITUAL_ARMOR_CHESTPLATE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 45, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(ScbModItems.SPIRITUAL_ARMOR_BOOTS.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 45, _player.inventoryMenu.getCraftSlots());
			}
			if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DIRT_PATH || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.FARMLAND
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.TORCH || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.REDSTONE_TORCH
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.SOUL_TORCH
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x + sx, y + sy, z + sz)) == PlantType.PLAINS : false)
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x + sx, y + sy, z + sz)) == PlantType.DESERT : false)
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x + sx, y + sy, z + sz)) == PlantType.BEACH : false)
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x + sx, y + sy, z + sz)) == PlantType.CAVE : false)
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x + sx, y + sy, z + sz)) == PlantType.WATER : false)
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x + sx, y + sy, z + sz)) == PlantType.NETHER : false)
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)).getBlock() instanceof IPlantable _plant ? _plant.getPlantType(world, new BlockPos(x + sx, y + sy, z + sz)) == PlantType.CROP : false)
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.KELP || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.KELP_PLANT
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_TUBE_CORAL || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_TUBE_CORAL_FAN
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_TUBE_CORAL_WALL_FAN || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_BRAIN_CORAL
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_BRAIN_CORAL_FAN || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_BRAIN_CORAL_WALL_FAN
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_BUBBLE_CORAL || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_BUBBLE_CORAL_FAN
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_BUBBLE_CORAL_WALL_FAN || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_FIRE_CORAL
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_FIRE_CORAL_FAN || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_FIRE_CORAL_WALL_FAN
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_HORN_CORAL || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_HORN_CORAL_FAN
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.DEAD_HORN_CORAL_WALL_FAN || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.TUBE_CORAL
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.TUBE_CORAL_FAN || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.TUBE_CORAL_WALL_FAN
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.BRAIN_CORAL || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.BRAIN_CORAL_FAN
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.BRAIN_CORAL_WALL_FAN || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.BUBBLE_CORAL
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.BUBBLE_CORAL_FAN || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.BUBBLE_CORAL_WALL_FAN
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.FIRE_CORAL || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.FIRE_CORAL_FAN
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.FIRE_CORAL_WALL_FAN || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.HORN_CORAL
					|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.HORN_CORAL_FAN || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.HORN_CORAL_WALL_FAN) {
				{
					BlockPos _pos = new BlockPos(x + 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
		}
	}
}
