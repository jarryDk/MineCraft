package dk.codingpirates.minecraft.mods.block;

import dk.codingpirates.minecraft.mods.CodingPiratesMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Juletrae extends Block {
	
	private final String name = "juletrae";

	public Juletrae() {
		super(Material.WOOD);
		setUnlocalizedName(CodingPiratesMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	public String getName() {
		return name;
	}

}
