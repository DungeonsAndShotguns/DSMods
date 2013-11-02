package org.dungeonsandshotguns.soulstorage;

import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GoldCoin extends Item 
{
	@Instance("GoldCoin")
	private final static Item GoldCoin = new GoldCoin(SoulStorage.GoldCoinID);
	
	public GoldCoin(int id) 
	{
        super(id);
        
        setMaxStackSize(99);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("GoldCoin");
	}

}
