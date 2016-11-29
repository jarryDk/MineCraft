package dk.codingpirates.minecraft.mods.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import dk.codingpirates.minecraft.mods.CodingPiratesMod;
import dk.codingpirates.minecraft.mods.block.PiratBoyBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class Gold2MorCrafting {
	
	public static void register() {
		GameRegistry.addShapedRecipe(
				new ItemStack(CodingPiratesMod.piratBoyBlock), 
				"GGG", 
				"GGG", 
				"GGG", 
				'G',
				Blocks.GOLD_BLOCK);

	}

}