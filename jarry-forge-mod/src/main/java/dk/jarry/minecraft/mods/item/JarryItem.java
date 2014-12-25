package dk.jarry.minecraft.mods.item;

import dk.jarry.minecraft.mods.JarryMod;
import net.minecraft.item.Item;

public class JarryItem extends Item {

	public JarryItem() {
		
		this.setUnlocalizedName("jarryItem");
		this.setTextureName(JarryMod.MODID + ":jarry");
	}
}
