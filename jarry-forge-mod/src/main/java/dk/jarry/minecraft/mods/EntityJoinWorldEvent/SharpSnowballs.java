package dk.jarry.minecraft.mods.EntityJoinWorldEvent;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SharpSnowballs {

	@SubscribeEvent
	public void replaceSnowballWithArrow(EntityJoinWorldEvent event) {
		Entity entity = event.entity;
		World world = entity.worldObj;

		if (!(entity instanceof EntitySnowball)) {
			return;
		}

		if (!world.isRemote) {
			EntityArrow arrow = new EntityArrow(world);
			arrow.setLocationAndAngles(entity.posX, entity.posY, entity.posZ,
					0, 0);
			arrow.motionX = entity.motionX;
			arrow.motionY = entity.motionY;
			arrow.motionZ = entity.motionZ;

			arrow.posX += arrow.motionX;
			arrow.posY += arrow.motionY;
			arrow.posZ += arrow.motionZ;

			world.spawnEntityInWorld(arrow);
			entity.setDead();
		}
	}

}
