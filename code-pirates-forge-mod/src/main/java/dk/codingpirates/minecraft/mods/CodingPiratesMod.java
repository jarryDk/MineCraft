package dk.codingpirates.minecraft.mods;

import org.devoxx4kids.forge.mods.ChatItems;
import org.devoxx4kids.forge.mods.CreeperSpawnAlert;
import org.devoxx4kids.forge.mods.EnchantmentArrowFast;
import org.devoxx4kids.forge.mods.RainWater;
import org.devoxx4kids.forge.mods.SharpSnowballs;
import org.devoxx4kids.forge.mods.WallClimber;

import dk.codingpirates.minecraft.mods.block.Julehjerte;
import dk.codingpirates.minecraft.mods.block.Julekugle;
import dk.codingpirates.minecraft.mods.block.Julenisse;
import dk.codingpirates.minecraft.mods.block.Juletrae;
import dk.codingpirates.minecraft.mods.block.MorBlock;
import dk.codingpirates.minecraft.mods.block.PiratBoyBlock;
import dk.codingpirates.minecraft.mods.block.PiratGirlBlock;
import dk.codingpirates.minecraft.mods.crafting.Gold2MorCrafting;
import dk.codingpirates.minecraft.mods.crafting.Ground2DimCrafting;
import dk.codingpirates.minecraft.mods.item.TowerItems;
import dk.codingpirates.minecraft.mods.item.PiratItem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
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
	
	public static Block morBlock;

	public static Block julehjerte;
	public static Block julekugle;
	public static Block julenisse;
	public static Block juletrae;

	public static Item piratItem;
	
	public static final Enchantment haste = new EnchantmentArrowFast();

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {

		// blocks
		piratBoyBlock = new PiratBoyBlock();
		GameRegistry.registerBlock(piratBoyBlock, "piratBoyBlock");
		piratGirlBlock = new PiratGirlBlock();
		GameRegistry.registerBlock(piratGirlBlock, "piratGirlBlock");
		
		morBlock = new MorBlock();
		GameRegistry.registerBlock(morBlock, "morBlock");
		
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

		Gold2MorCrafting.register();
		Ground2DimCrafting.register();
		
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		if (event.getSide() == Side.CLIENT) {

			MinecraftForge.EVENT_BUS.register(new TowerItems());
			

			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			ItemModelMesher itemModelMesher = renderItem.getItemModelMesher();

			// blocks
			itemModelMesher.register(Item.getItemFromBlock(piratBoyBlock), 0, new ModelResourceLocation(
					CodingPiratesMod.MODID + ":" + ((PiratBoyBlock) piratBoyBlock).getName(), "inventory"));
			
			itemModelMesher.register(Item.getItemFromBlock(piratGirlBlock), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((PiratGirlBlock) piratGirlBlock).getName(), "inventory"));

			itemModelMesher.register(Item.getItemFromBlock(morBlock), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((MorBlock) morBlock).getName(), "inventory"));

			
			itemModelMesher.register(Item.getItemFromBlock(julehjerte), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((Julehjerte) julehjerte).getName(), "inventory"));

			itemModelMesher.register(Item.getItemFromBlock(julekugle), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((Julekugle) julekugle).getName(), "inventory"));

			itemModelMesher.register(Item.getItemFromBlock(julenisse), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((Julenisse) julenisse).getName(), "inventory"));

			itemModelMesher.register(Item.getItemFromBlock(juletrae), 0,
					new ModelResourceLocation(
							CodingPiratesMod.MODID + ":" + ((Juletrae) juletrae).getName(), "inventory"));
			
			// items
			itemModelMesher.register(piratItem, 0, new ModelResourceLocation(
					CodingPiratesMod.MODID + ":" + ((PiratItem) piratItem).getName(), "inventory"));
			
			/**
			 * Devoxx4kids
			 */
			MinecraftForge.EVENT_BUS.register(new ChatItems());
			MinecraftForge.EVENT_BUS.register(new CreeperSpawnAlert());
			MinecraftForge.EVENT_BUS.register(new SharpSnowballs());
			MinecraftForge.EVENT_BUS.register(new RainWater());
			FMLCommonHandler.instance().bus().register(new WallClimber());
			MinecraftForge.EVENT_BUS.register(new WallClimber());
			MinecraftForge.EVENT_BUS.register(haste);
			Enchantment.REGISTRY.register(100, new ResourceLocation("arrowFast"), haste);
			
		}

		System.out.println("Jarry.Dk ...");
	}

}
