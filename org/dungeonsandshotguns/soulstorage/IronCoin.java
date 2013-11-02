package org.dungeonsandshotguns.soulstorage;

import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IronCoin extends Item 
{
	@Instance("IronCoin")
	private final static Item IronCoin = new IronCoin(SoulStorage.IronCoinID);
	
	public IronCoin(int id) 
	{
        super(id);
        
        setMaxStackSize(99);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("IronCoin");
	}

}
