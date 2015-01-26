package org.dungeonsandshotguns.dsmods.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.dungeonsandshotguns.dsmods.items.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FullSoulCoin extends Item 
{
	public static Item FilledSoulCoin;
	
	// TODO: To be removed
	public FullSoulCoin()
	{
		setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("FullSoulCoin");
        //setTextureName("dsmods:SoulCoinFull");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_,
			EntityPlayer p_77659_3_) 
	{
		if(p_77659_1_.getItemDamage() > 0)
		{
			p_77659_3_.addExperience(p_77659_1_.getItemDamage());
			
			ItemStack coinStack = new ItemStack(EmptySoulCoin.SoulCoin);
			return super.onItemRightClick(coinStack, p_77659_2_, p_77659_3_);
		}
		
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack, int pass) 
	{
		return true;
	}

}
