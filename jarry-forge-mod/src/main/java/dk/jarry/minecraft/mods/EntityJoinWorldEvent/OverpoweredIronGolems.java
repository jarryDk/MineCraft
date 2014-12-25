package dk.jarry.minecraft.mods.EntityJoinWorldEvent;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class OverpoweredIronGolems {

	@SubscribeEvent
	public void golemMagic(EntityJoinWorldEvent event) {
		if (!(event.entity instanceof EntityIronGolem)) {
			return;
		}

		EntityLiving entity = (EntityLiving) event.entity;
		entity.addPotionEffect(new PotionEffect(1, 1000000, 5));
		entity.addPotionEffect(new PotionEffect(5, 1000000, 5));
		entity.addPotionEffect(new PotionEffect(10, 1000000, 5));
		entity.addPotionEffect(new PotionEffect(11, 1000000, 5));
	}

}