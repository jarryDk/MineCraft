package dk.codingpirates.minecraft.mods.block;

import dk.codingpirates.minecraft.mods.CodingPiratesMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PiratBoyBlock extends Block {
	
	private final String name = "piratBoyBlock";

	public PiratBoyBlock() {
		super(Material.GOURD);
		// GameRegistry.registerBlock(this, name);
		setUnlocalizedName(CodingPiratesMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	public String getName() {
		return name;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockDestroyedByPlayer(worldIn, pos, state);

		List<EntityPlayer> playerEntities = worldIn.playerEntities;

		if (worldIn.isRemote) {

			for (EntityPlayer player : playerEntities) {
				player.addChatComponentMessage(
						new TextComponentString(TextFormatting.GREEN + "Nogen har ødelagt en mor blok!"));
			}

		}

	}

}
