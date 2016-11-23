package dk.codingpirates.minecraft.mods;

import dk.codingpirates.minecraft.mods.block.Julehjerte;
import dk.codingpirates.minecraft.mods.block.Julekugle;
import dk.codingpirates.minecraft.mods.block.Julenisse;
import dk.codingpirates.minecraft.mods.block.Juletrae;
import dk.codingpirates.minecraft.mods.block.PiratBoyBlock;
import dk.codingpirates.minecraft.mods.block.PiratGirlBlock;
import dk.codingpirates.minecraft.mods.item.TowerItems;
import dk.codingpirates.minecraft.mods.item.PiratItem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = CodingPiratesMod.MODID, version = CodingPiratesMod.VERSION, name = CodingPiratesMod.NAME)
public class CodingPiratesMod {

	public static final String MODID = "codingpirates";
	public static final String VERSION = "0.3";
	public static final String NAME = "Coding Pirates mod";

	public static Block piratBoyBlock;
	public static Block piratGirlBlock;

	public static Block julehjerte;
	public static Block julekugle;
	public static Block julenisse;
	public static Block juletrae;

	public static Item piratItem;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {

		// blocks
		piratBoyBlock = new PiratBoyBlock();
		GameRegistry.registerBlock(piratBoyBlock, "piratBoyBlock");
		piratGirlBlock = new PiratGirlBlock();
		GameRegistry.registerBlock(piratGirlBlock, "piratGirlBlock");
		julehjerte = new Julehjerte();
		GameRegistry.registerBlock(julehjerte, "julehjerte");
		julekugle = new Julekugle();
		GameRegistry.registerBlock(julekugle, "julekugle");
		julenisse = new Julenisse();
		GameRegistry.registerBlock(julenisse, "julenisse");
		juletrae = new Juletrae();
		GameRegistry.registerBlock(juletrae, "juletrae");

		// items
		piratItem = new PiratItem();
		GameRegistry.registerItem(piratItem, "piratItem");

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		if (event.getSide() == Side.CLIENT) {

			MinecraftForge.EVENT_BUS.register(new TowerItems());

			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

			// blocks
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(piratBoyBlock), 0, new ModelResourceLocation(
					CodingPiratesMod.MODID + ":" + ((PiratBoyBlock) piratBoyBlock).getName(), "inventory"));
			
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(piratGirlBlock), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((PiratGirlBlock) piratGirlBlock).getName(), "inventory"));

			renderItem.getItemModelMesher().register(Item.getItemFromBlock(julehjerte), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((Julehjerte) julehjerte).getName(), "inventory"));

			renderItem.getItemModelMesher().register(Item.getItemFromBlock(julekugle), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((Julekugle) julekugle).getName(), "inventory"));

			renderItem.getItemModelMesher().register(Item.getItemFromBlock(julenisse), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((Julenisse) julenisse).getName(), "inventory"));

			renderItem.getItemModelMesher().register(Item.getItemFromBlock(juletrae), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((Juletrae) juletrae).getName(), "inventory"));
			
			// items
			renderItem.getItemModelMesher().register(piratItem, 0, new ModelResourceLocation(
					CodingPiratesMod.MODID + ":" + ((PiratItem) piratItem).getName(), "inventory"));

		}

		System.out.println("Jarry.Dk ...");
	}

}
