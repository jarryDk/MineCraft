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
	public void onBlockDestroyedByPlayer(World worldIn, 
											BlockPos pos, 
											IBlockState state) {
		super.onBlockDestroyedByPlayer(worldIn, pos, state);

		List<EntityPlayer> playerEntities = worldIn.playerEntities;

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		Block tnt = Blocks.TNT;
		IBlockState defaultState = tnt.getDefaultState();
		Block redstone = Blocks.REDSTONE_BLOCK;
		IBlockState defaultState2 = redstone.getDefaultState();
		
		if (worldIn.isRemote) {

			for (EntityPlayer player : playerEntities) {
				player.addChatComponentMessage(
						new TextComponentString(
								TextFormatting.GREEN 
								+ "Nogen har ødelagt en mor blok!"
								+"x:" + x 
								+ " - y:" + y
								+ " - z:" + z));
			}
			
			BlockPos position = new BlockPos(x,y+1, z);
			worldIn.setBlockState(position, defaultState);
				
			BlockPos position2 = new BlockPos(x,y+2, z);
			worldIn.setBlockState(position2, defaultState2);
			
		}

	}


}
