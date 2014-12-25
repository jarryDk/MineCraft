package dk.jarry.minecraft.mods.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import dk.jarry.minecraft.mods.JarryMod;

/**
 * 
 * http://www.orangetutorial.com/basic-block/#sthash.go8xdFGs.dpbs
 * http://www.minecraftforge.net/wiki/Your_first_block
 * https://www.youtube.com/watch?v=Aeb3IkrBhGY
 * 
 * @author Michael Bornholdt Nielsen <mni@jarry.dk>
 *
 */
public class JarryBlock extends Block {
	
	public JarryBlock(){
        super(Material.gourd);
        
        this.setHardness(89.3F);
		this.setResistance(89.5F);
		this.setStepSound(Block.soundTypeMetal);
        this.setLightOpacity(2);
        
        this.setBlockName("jarryBlock");
        this.setBlockTextureName(JarryMod.MODID + ":jarry");
        
        
	}
	
	
}
