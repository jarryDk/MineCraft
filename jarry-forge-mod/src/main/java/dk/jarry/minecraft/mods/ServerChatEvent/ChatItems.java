package dk.jarry.minecraft.mods.ServerChatEvent;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ServerChatEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ChatItems {

	@SubscribeEvent
	public void giveItems(ServerChatEvent event) {
		
		System.out.println("Player " + event.player.getDisplayName() + " say : " + event.message);
		
		if (!(event.message.contains("potato"))) {
			return;
		}

		event.player.inventory.addItemStackToInventory(new ItemStack(
				Items.diamond, 64));
	}
}
