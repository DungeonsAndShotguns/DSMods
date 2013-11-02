package org.dungeonsandshotguns.soulstorage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SoulSword extends Item 
{

	public SoulSword(int ID) 
	{
		super(ID);
		this.maxStackSize = 1;
		this.setMaxDamage(SoulStorage.SoulMat.getMaxUses());
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setUnlocalizedName("SoulSword");
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) 
	{
		//float TotalDamagev = getDamageVsEntity(entity, stack);
		
		player.addExperience((int)Math.round(SoulStorage.SoulMat.getDamageVsEntity()));
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack, int pass) 
	{
		return true;
	}
	
}
