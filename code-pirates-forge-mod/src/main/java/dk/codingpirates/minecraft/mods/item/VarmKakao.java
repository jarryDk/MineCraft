package dk.codingpirates.minecraft.mods.item;

import dk.codingpirates.minecraft.mods.CodingPiratesMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class VarmKakao extends ItemFood {

	private String name = "varmKakao";
	
	public VarmKakao() {
		super(2, 7f, true);
		setUnlocalizedName(CodingPiratesMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.FOOD);
	}

	public String getName() {
		return name;
	}
	
	
}
