package org.dungeonsandshotguns.soulstorage;

import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CopperCoin extends Item 
{
	@Instance("CopperCoin")
	private final static Item CopperCoin = new CopperCoin(SoulStorage.CopperCoinID);
	
	public CopperCoin(int id) 
	{
        super(id);
        
        setMaxStackSize(50);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("CopperCoin");
        
	}
	
	public int BaseEconValue()
	{
		return 1;
	}

}
