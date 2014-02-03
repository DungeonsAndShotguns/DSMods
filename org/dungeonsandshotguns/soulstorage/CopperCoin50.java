package org.dungeonsandshotguns.soulstorage;

import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CopperCoin50 extends Item
{
	@Instance("CopperCoin50")
	private final static Item CopperCoin50 = new CopperCoin(SoulStorage.CopperCoin50ID);

	public CopperCoin50(int id) 
	{
        super(id);
        
        setMaxStackSize(50);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("CopperCoin50");
        
	}
	
	public int BaseEconValue()
	{
		return 50;
	}
}
