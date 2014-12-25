package dk.jarry.minecraft.mods.PlaceEvent;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DragonSpawner {

	@SubscribeEvent
	public void spawnDragon(PlaceEvent event) {
		if (event.block != Blocks.dragon_egg) {
			return;
		}

		event.world.setBlock(event.x, event.y, event.z, Blocks.air);
		EntityDragon dragon = new EntityDragon(event.world);
		dragon.setLocationAndAngles(event.x, event.y, event.z, 0, 0);
		event.world.spawnEntityInWorld(dragon);
	}

}
