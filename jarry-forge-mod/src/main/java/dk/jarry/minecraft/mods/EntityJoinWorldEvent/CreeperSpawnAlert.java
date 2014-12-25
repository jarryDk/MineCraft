package dk.jarry.minecraft.mods.EntityJoinWorldEvent;

import java.util.List;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CreeperSpawnAlert {

	@SubscribeEvent
	public void sendAlert(EntityJoinWorldEvent event) {
		if (!(event.entity instanceof EntityCreeper)) {
			return;
		}

		List players = event.entity.worldObj.playerEntities;

		for (int i = 0; i < players.size(); i++) {
			EntityPlayer player = (EntityPlayer) players.get(i);
			player.addChatMessage(new ChatComponentText(
					EnumChatFormatting.GREEN + "A creeper has spawned!"));
		}
	}

}
