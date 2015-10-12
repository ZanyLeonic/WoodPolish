package com.leonic.polishedwood.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

/**
 * The class that gives the polished wooden planks Meta data.
 * 
 * @author Leonic
 * @version 0.1
 */
public class ItemBlockPolishedPlank extends ItemBlockWithMetadata {

	public ItemBlockPolishedPlank(Block block) {
		super(block, block);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

}
