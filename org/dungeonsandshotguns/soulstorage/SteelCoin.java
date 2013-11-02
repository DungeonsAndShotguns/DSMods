package org.dungeonsandshotguns.soulstorage;

import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SteelCoin extends Item 
{
	@Instance("SteelCoin")
	private final static Item SteelCoin = new SteelCoin(SoulStorage.SteelCoinID);
	
	public SteelCoin(int id) 
	{
        super(id);
        
        setMaxStackSize(99);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("SteelCoin");
	}

}
