package dk.codingpirates.minecraft.mods.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import dk.codingpirates.minecraft.mods.CodingPiratesMod;

public class PiratItem extends Item {
	
	private final String name = "piratItem";

	public PiratItem() {
		// GameRegistry.registerItem(this, name);
		setUnlocalizedName(CodingPiratesMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMisc);
	}

	public String getName() {
		return name;
	}

}
