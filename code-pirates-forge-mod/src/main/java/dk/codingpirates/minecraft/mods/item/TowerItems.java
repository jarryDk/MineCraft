package dk.codingpirates.minecraft.mods.item;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TowerItems {

	@SubscribeEvent
	public void buildTower(ServerChatEvent event) {
		
		if (event.getMessage().contains("tower")) {

			World world = event.getPlayer().getEntityWorld();

			BlockPos position = event.getPlayer().getPosition();
			
			Block blk = Blocks.DIAMOND_BLOCK;
			IBlockState defaultState = blk.getDefaultState();
			
			int startX = position.getX();
			int startY = position.getY();
			int startZ = position.getZ();
			BlockPos position1 = null;

			System.out.println("BlockPos pos=" + position.toString());
			
			for (int z = 0 ; z < 10 ; z++){
			
				for (int y = 0 ; y < 10 ; y++){
					for (int x = 0 ; x < 10 ; x++){
						position1 = new BlockPos(position.getX() + x, position.getY() + y, position.getZ() + z);
						world.setBlockState(position1, defaultState);
						System.out.println("BlockPos pos0=" + position1.toString());
					}	
				}				
			}
				
			

			

				
			
		}

	}
}