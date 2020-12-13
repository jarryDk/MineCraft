package dk.jarry.minecraft;

import dk.jarry.minecraft.block.Julehjerte;
import dk.jarry.minecraft.block.Julekugle;
import dk.jarry.minecraft.block.Julenisse;
import dk.jarry.minecraft.block.Juletrae;
import dk.jarry.minecraft.item.VarmKakao;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HelloMod.MODID);

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HelloMod.MODID);
	

	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	    ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	
	public static final RegistryObject<Block> JULE_HJERTE = BLOCKS.register(Julehjerte.NAME,
			() -> new Julehjerte());

	public static final RegistryObject<Block> JULE_KUGLE = BLOCKS.register(Julekugle.NAME,
			() -> new Julekugle());
	
	public static final RegistryObject<Block> JULE_NISSE = BLOCKS.register(Julenisse.NAME,
			() -> new Julenisse());
	
	public static final RegistryObject<Block> JULE_TRAE = BLOCKS.register(Juletrae.NAME,
			() -> new Juletrae());
	
	
	public static final RegistryObject<Item> JULE_HJERTE_ITEM = ITEMS.register(Julehjerte.NAME,
			() -> new BlockItem(JULE_HJERTE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> JULE_KUGLE_ITEM = ITEMS.register(Julekugle.NAME,
			() -> new BlockItem(JULE_KUGLE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> JULE_NISSE_ITEM = ITEMS.register(Julenisse.NAME,
			() -> new BlockItem(JULE_NISSE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> JULE_TRAE_ITEM = ITEMS.register(Juletrae.NAME,
			() -> new BlockItem(JULE_TRAE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	
	
	public static final RegistryObject<Item> VARM_KAKAO = ITEMS.register(VarmKakao.NAME,
	 		() ->  VarmKakao.getInstance());
	

}
