package dk.jarry.minecraft.mods;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dk.jarry.minecraft.mods.EntityJoinWorldEvent.CreeperSpawnAlert;
import dk.jarry.minecraft.mods.EntityJoinWorldEvent.OverpoweredIronGolems;
import dk.jarry.minecraft.mods.EntityJoinWorldEvent.SharpSnowballs;
import dk.jarry.minecraft.mods.LivingUpdateEvent.RainWater;
import dk.jarry.minecraft.mods.PlaceEvent.DragonSpawner;
import dk.jarry.minecraft.mods.ServerChatEvent.ChatItems;
import dk.jarry.minecraft.mods.block.JarryBlock;
import dk.jarry.minecraft.mods.item.JarryItem;

/**
 * @author Michael Bornholdt Nielsen <mni@jarry.dk>
 *
 */
@Mod(modid = JarryMod.MODID, version = JarryMod.VERSION, name = JarryMod.NAME)
public class JarryMod {

	public static final String MODID = "JarryMod";
	public static final String VERSION = "1.0";
	public static final String NAME = "Jarry.dk test mod";

	public static Block jarryBlock;
	public static Item jarryItem;
	

	public static CreativeTabs jarryTab = new CreativeTabs("JarryDkTab") {
		@Override
		public Item getTabIconItem() {
			return Items.emerald;
		}
	};

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		
		jarryItem = new JarryItem().setCreativeTab(jarryTab);
		GameRegistry.registerItem(jarryItem, "jarryItem");
		
		jarryBlock = new JarryBlock().setCreativeTab(jarryTab);
		GameRegistry.registerBlock(jarryBlock, "jarryBlock");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		System.out.println(JarryMod.MODID + "(" + JarryMod.VERSION
				+ ") is on !");

		/**
		 * Purpose: To make the player receive items when he/she says a certain
		 * word or phrase in a chat message.
		 */
		MinecraftForge.EVENT_BUS.register(new ChatItems());

		/**
		 * Purpose: To spawn an Ender Dragon every time a player places a Dragon
		 * Egg block.
		 */
		MinecraftForge.EVENT_BUS.register(new DragonSpawner());

		/**
		 * Purpose: To add helpful potion effects to Iron Golems when they spawn
		 * in the world.
		 */
		MinecraftForge.EVENT_BUS.register(new OverpoweredIronGolems());

		/**
		 * Purpose: To alert all players when a creeper spawns.
		 */
		MinecraftForge.EVENT_BUS.register(new CreeperSpawnAlert());

		/**
		 * Purpose: To turn all snowballs into arrows so that they can hurt
		 * entites.
		 */
		MinecraftForge.EVENT_BUS.register(new SharpSnowballs());

		/**
		 * Purpose: To place water at the feet of entities when it is raining.
		 */
		MinecraftForge.EVENT_BUS.register(new RainWater());
	}

}
