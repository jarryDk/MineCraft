package org.devoxx4kids.forge.mods;


import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * https://github.com/devoxx4kids/materials/blob/master/workshops/minecraft/src/main/java/org/devoxx4kids/forge/mods/RainWater.java
 *
 */
public class RainWater {

	@SubscribeEvent
	public void makeWater(LivingUpdateEvent event) {
		Entity entity = event.getEntity();
		World world = entity.worldObj;
		int x = (int) Math.floor(entity.posX);
		int y = (int) Math.floor(entity.posY);
		int z = (int) Math.floor(entity.posZ);

		if (!world.isRaining()) {
			return;
		}

		for (int i = y; i < 256; i++) {
			if (world.getBlockState(new BlockPos(x, i, z)) != Blocks.AIR
					.getBlockState().getBaseState()) {
				return;
			}
		}

		if (world.isRemote
				|| !world.getBlockState(new BlockPos(x, y - 1, z)).isFullCube()) {
			return;
		}

		world.setBlockState(new BlockPos(x, y, z), Blocks.WATER.getBlockState()
				.getBaseState());
	}
}