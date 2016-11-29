package dk.codingpirates.minecraft.mods.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import dk.codingpirates.minecraft.mods.CodingPiratesMod;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class Ground2DimCrafting {

	public static void register() {
		GameRegistry.addShapedRecipe(
				new ItemStack(Items.DIAMOND), 
				"DDD", 
				"X X", 
				"III", 
				'D', 
				Blocks.DIRT, 
				'X', 
				Blocks.PUMPKIN, 
				'I', 
				Items.FISH);

	}

}



