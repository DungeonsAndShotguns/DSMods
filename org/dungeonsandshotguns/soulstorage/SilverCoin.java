package org.dungeonsandshotguns.soulstorage;

import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SilverCoin extends Item
{
	@Instance("SilverCoin")
	private final static Item SilverCoin = new SilverCoin(SoulStorage.SilverCoinID);
	
	public SilverCoin(int id) 
	{
        super(id);
        
        setMaxStackSize(99);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("SilverCoinCoin");
	}
	
	public int BaseEconValue()
	{
		return 1000;
	}
}
