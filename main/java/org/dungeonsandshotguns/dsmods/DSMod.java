package org.dungeonsandshotguns.dsmods;

import com.sun.org.apache.xml.internal.security.keys.content.SPKIData;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.registry.GameRegistry;
import org.dungeonsandshotguns.dsmods.items.*;
import org.dungeonsandshotguns.dsmods.Enchantments.Fragment;
import org.dungeonsandshotguns.dsmods.Events.SoulStorageEvents;
import org.dungeonsandshotguns.dsmods.crafting.*;

@Mod(modid = DSMod.MODID, version = DSMod.VERSION)
public class DSMod 
{
	public static final String MODID = "dsmods";
    public static final String VERSION = "1.0";
    
    // Old way of doing this King L. please add something better than this
    public static Enchantment soulSteal;
    
    boolean LoadSoulStorage = true;
    boolean LoadOther = true;
    
    @Instance(value = "dsmods")
    public static DSMod instance;
    
    @SidedProxy(clientSide="org.dungeonsandshotguns.dsmods.client.ClientProxy", 
    		serverSide="org.dungeonsandshotguns.dsmods.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
        // Register all items based on what is loaded in the config
    	
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) 
    {
        proxy.registerRenderers();
        
        ItemStack dirtStack = new ItemStack(Blocks.dirt);
        ItemStack gravelStack = new ItemStack(Blocks.gravel);
        GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone), 
        		"xy", "yx",
                'x', dirtStack, 'y', gravelStack);

        
        if(LoadSoulStorage == true)
    	{
        	
    		EmptySoulCoin.SoulCoin = new EmptySoulCoin();
    		EmptySoulCoin.SoulCoin.setTextureName("dsmods:SoulCoin");
    		GameRegistry.registerItem(EmptySoulCoin.SoulCoin,
    				"emptysoulcoin");
    		SoulStorage.Register();
    		
    		DSMod.soulSteal = new Fragment(101, 0, EnumEnchantmentType.all);
    		SoulStorageEvents events = new SoulStorageEvents();
    		// this is the wrong bus
    		MinecraftForge.EVENT_BUS.register(events);
    		//FMLCommonHandler.instance().bus().register(events);
    	}
    	
    	if(LoadOther == true)
    	{
    		SpikedSnowBall.SpikeSnowBall = new SpikedSnowBall();
    		SpikedSnowBall.SpikeSnowBall.setTextureName("dsmods:SpikedSnowBall");
    		GameRegistry.registerItem(SpikedSnowBall.SpikeSnowBall , "spikedsnowball");
    		Other.Register();
    	}
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	if(LoadSoulStorage == true)
    	{
    		
    	}
        
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	// Stub Method
    }

    
    
    
}    
