package dk.jarry.minecraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Julekugle extends Block {
	
	public final static String NAME = "julekugle";

	public Julekugle() {
		super(AbstractBlock.Properties.create(Material.WOOD));
	}

}
