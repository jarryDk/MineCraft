package dk.jarry.minecraft.mods.LivingUpdateEvent;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RainWater {

	@SubscribeEvent
	public void makeWater(LivingUpdateEvent event) {
		try {
			Entity entity = event.entity;
			World world = entity.worldObj;
			int x = (int) Math.floor(entity.posX);
			int y = (int) Math.floor(entity.posY);
			int z = (int) Math.floor(entity.posZ);

			if (!entity.worldObj.isRaining()) {
				return;
			}

			for (int i = y; i < 256; i++) {
				if (world.getBlock(x, i, z) != Blocks.air) {
					return;
				}
			}
			
			if (world.isRemote && !world.getBlock(x, y - 1, z).isBlockNormalCube()) {
				return;
			}
			
			if (!world.isRemote) {
				world.setBlock(x, y, z, Blocks.water, 5, 1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}