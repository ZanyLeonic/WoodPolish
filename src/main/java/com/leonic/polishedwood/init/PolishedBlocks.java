package com.leonic.polishedwood.init;

import com.leonic.polishedwood.Polished;
import com.leonic.polishedwood.blocks.ItemBlockPolishedPlank;
import com.leonic.polishedwood.blocks.PolishedPlank;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * A class which calls the RegisterHelper to register the blocks on startup.
 * For custom model blocks we don't use RegisterHelper.
 * @author ZanyLeonic
 * @version 0.1
 * 
 */
public class PolishedBlocks {
	
	//Polished Wood blocks
	public static Block blockPolishedPlank = new PolishedPlank(Material.rock).setCreativeTab(Polished.Polished).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeGlass).setBlockName("polishedplanks").setBlockTextureName("polished_planks");
	
    /**
     * Uses RegisterHelper to register all the blocks. (Not for custom model blocks.)
     */
	public static void registerBlocks()
    {	
		//Registering with polishedwood with GameRegistry
		GameRegistry.registerBlock(blockPolishedPlank, ItemBlockPolishedPlank.class, "polishedwoodenplanks");


    }
}
