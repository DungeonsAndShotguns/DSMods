package org.dungeonsandshotguns.dsmods.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class Fragment extends Enchantment
{
	public static int XPMulti = 3;
	
	public Fragment(int p_i1926_1_, int p_i1926_2_,
			EnumEnchantmentType p_i1926_3_) 
	{
		super(p_i1926_1_, 1, EnumEnchantmentType.weapon);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getMinEnchantability(int p_77321_1_) 
	{
		// TODO Auto-generated method stub
		return super.getMinEnchantability(20);
	}
	
	@Override
	public boolean canApplyTogether(Enchantment p_77326_1_) 
	{
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isAllowedOnBooks() 
	{
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String getTranslatedName(int p_77316_1_) 
	{
		// TODO Auto-generated method stub
		return "Fragmentation";
	}

}
