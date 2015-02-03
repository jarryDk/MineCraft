package dk.codingpirates.minecraft.mods;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import dk.codingpirates.minecraft.mods.block.PiratBlock;
import dk.codingpirates.minecraft.mods.item.PiratItem;

@Mod(modid = CodingPiratesMod.MODID, version = CodingPiratesMod.VERSION, name = CodingPiratesMod.NAME)
public class CodingPiratesMod {

	public static final String MODID = "codingpirates";
	public static final String VERSION = "1.0";
	public static final String NAME = "Coding Pirates test mod";
	
	public static Block piratBlock;
	public static Item piratItem;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {

		// blocks
		piratBlock = new PiratBlock();
		GameRegistry.registerBlock(piratBlock, "piratBlock");

		// items
		piratItem = new PiratItem();
		GameRegistry.registerItem(piratItem, "piratItem");
		
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		if (event.getSide() == Side.CLIENT) {
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			
			// blocks
			renderItem.getItemModelMesher()
					.register(
							Item.getItemFromBlock(piratBlock),
							0,
							new ModelResourceLocation(
									CodingPiratesMod.MODID
											+ ":"
											+ ((PiratBlock) piratBlock)
													.getName(), "inventory"));

			// items
			renderItem.getItemModelMesher().register(
					piratItem,
					0,
					new ModelResourceLocation(CodingPiratesMod.MODID + ":"
							+ ((PiratItem) piratItem).getName(), "inventory"));

		}

		System.out.println("Jarry.Dk ...");
	}

}
