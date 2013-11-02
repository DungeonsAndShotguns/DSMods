package org.dungeonsandshotguns.soulstorage;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class SoulSteel extends Enchantment 
{
	public int XPMulti = 0;

	protected SoulSteel(int ID, int XPMultipler) 
	{
		// par1 is Enchantment id
		// par2 is level or weight
		super(ID, 1, EnumEnchantmentType.weapon);
		
		XPMulti = XPMultipler;
		
		this.setName("SoulSteel");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getMinEnchantability(int par1) 
	{
		return 20;
	}
	
	@Override
	public boolean canApplyTogether(Enchantment par1Enchantment) 
	{
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public boolean isAllowedOnBooks() 
	{
		return true;
	}
	
	@Override
	public String getTranslatedName(int par1) 
	{
		return "Fragmentation";
	}
	
	
	
	

}
