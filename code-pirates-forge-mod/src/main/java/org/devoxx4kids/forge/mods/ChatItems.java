package org.devoxx4kids.forge.mods;


import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * https://github.com/devoxx4kids/materials/blob/master/workshops/minecraft/src/main/java/org/devoxx4kids/forge/mods/ChatItems
 *
 */
public class ChatItems {

	@SubscribeEvent
	public void giveItems(ServerChatEvent event) {
		if (event.getMessage().contains("potato")) {
			event.getPlayer().inventory.addItemStackToInventory(new ItemStack(
					Items.POTATO, 64));
		}
	}
}