package org.dungeonsandshotguns.soulstorage;

import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GoldCoin50 extends Item
{
	@Instance("GoldCoin50")
	private final static Item GoldCoin50 = new CopperCoin(SoulStorage.GoldCoin50ID);

	public GoldCoin50(int id) 
	{
        super(id);
        
        setMaxStackSize(50);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("GoldCoin50");
        
	}
	
	public int BaseEconValue()
	{
		return 500;
	}
}
