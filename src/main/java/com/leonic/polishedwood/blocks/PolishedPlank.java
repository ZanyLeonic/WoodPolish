package com.leonic.polishedwood.blocks;

import java.util.List;

import com.leonic.polishedwood.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * Class for the Polished wooden planks.
 * 
 * @author Leonic
 * @version 0.1
 */
public class PolishedPlank extends Block{
	
	public static final String[] woodnames = new String[] {"oak", "spruce", "birch", "jungle", "acacia", "big_oak"};
    @SideOnly(Side.CLIENT)
    private IIcon[] icon;
	
	public PolishedPlank(Material material) {
		super(material);
        setHardness(2.0F);
        setResistance(6.0F);
        setStepSound(soundTypeStone);
	}

	@Override
	 @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister meta)
	    {
	        this.icon = new IIcon[woodnames.length];

	        for (int i = 0; i < this.icon.length; ++i)
	        {
	            this.icon[i] = meta.registerIcon(References.MODID + ":" + this.getTextureName() + "_" + woodnames[i]);
	        }
	    }

	/**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta < 0 || meta >= this.icon.length)
        {
            meta = 0;
        }

        return this.icon[meta];
    }
    
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int meta)
    {
        return meta;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */

	@Override
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab,  List list) {
        for (int i = 0; i < 6; i ++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

}