package dk.codingpirates.minecraft.mods.block;

import java.util.List;

import dk.codingpirates.minecraft.mods.CodingPiratesMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MorBlock extends Block {

	private final String name = "morBlock";

	public MorBlock() {
		super(Material.GROUND);
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
			
		}

	}

}
