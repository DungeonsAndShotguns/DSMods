package org.dungeonsandshotguns.soulstorage;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoulCoinFull extends Item
{
	@Instance("SoulCoinFull")
	private final static Item SoulCoinFull = new SoulCoinFull(SoulStorage.SoulCoinID);
	
	public SoulCoinFull(int id) 
	{
        super(id);
        
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("SoulCoin");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
	{
		if(par1ItemStack.getItemDamage() > 0)
		{
			par3EntityPlayer.addExperience(par1ItemStack.getItemDamage());
			return new ItemStack(SoulStorage.EmptySoulCoin);
		}
		
		return par1ItemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack, int pass) 
	{
		return true;
		//return super.hasEffect(par1ItemStack, pass);
	}
}
