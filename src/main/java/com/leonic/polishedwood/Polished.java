/**
 * 
 */
package com.leonic.polishedwood;

import com.leonic.polishedwood.init.PolishedBlocks;
import com.leonic.polishedwood.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

/**
 * The main class for Polished Wood.
 * 
 * @author ZanyLeonic
 * @version 0.1
 */
@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class Polished {
	
	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
	public static CommonProxy leonicProxy;

	@Instance(References.MODID)
	public static Polished instance;
	
	//Custom creative tab
	public static CreativeTabs Polished = new CreativeTabs("PolishedWoodMod")
	{
		public Item getTabIconItem()
		{
			return Items.clock;
		}
	};
		
	 @EventHandler
	    public void preInit(FMLPreInitializationEvent event)
	    {	
		    //Configuration file
	    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	    	
	    	config.load();
	    	
	    	//Update config
	    	Property NOTIFYFORNEWVERSION = config.get("UPDATE_OPTIONS", "NOTFIY_FOR_NEW_VERSION", true);
	    	Property CHECKFORUPDATES = config.get("UPDATE_OPTIONS", "CHECK_FOR_UPDATES", true);
	    	
	    	CHECKFORUPDATES.comment = "Checks for updates on start.";
	    	References.CHECK_FOR_UPDATES = CHECKFORUPDATES.getBoolean();
	    	
	    	NOTIFYFORNEWVERSION.comment = "Notifies the user on login if an update is available.";
	    	References.NOTIFY_FOR_NEW_VERSION = NOTIFYFORNEWVERSION.getBoolean();
	    	
	    	config.addCustomCategoryComment("UPDATE_OPTIONS", "Sets options for the updater,");
	    	
	    	config.setCategoryRequiresMcRestart("UPDATE_OPTIONS", true);
	    	
	    	//Blocks, Items and Recipes
	    	PolishedBlocks.registerBlocks();
	    }
	 
	 @EventHandler
	    public void init(FMLInitializationEvent event)
	    {
		 
	    }
	 
	 @EventHandler
	    public void postInit(FMLPostInitializationEvent event)
	    {
	    
	    }
}
