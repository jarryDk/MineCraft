package dk.jarry.minecraft.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class VarmKakao extends Item {
	
	public final static String NAME = "varmkakao";
	
	public static VarmKakao getInstance() {
		Food.Builder foodBuilder = new Food.Builder().fastToEat();
		Properties p = new Properties().food(foodBuilder.build());
		return new VarmKakao(p);
	}
	
	public VarmKakao(Properties properties) {
		super(properties);
	}

}
