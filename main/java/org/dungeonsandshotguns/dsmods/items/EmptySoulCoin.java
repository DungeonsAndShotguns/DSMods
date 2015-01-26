package org.dungeonsandshotguns.dsmods.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import java.lang.String;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EmptySoulCoin extends Item 
{
	public static Item SoulCoin;
	//public static String TexturePath = "EEW"; 
	
	public EmptySoulCoin()
	{
		setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("EmptySoulCoin");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_,
			EntityPlayer p_77659_3_) 
	{
		if (p_77659_1_.getItemDamage() < 1 && p_77659_3_.experienceTotal > 0)
		{
			//FullSoulCoin coinToReturn = new FullSoulCoin();
			//coinToReturn.setTextureName("smods:SoulCoinFull");
			//FullSoulCoin coinToReturn = 
			//ItemStack Coin = new ItemStack(coinToReturn);
			//Coin.setItemDamage(0);
			p_77659_1_.setItemDamage(0);
			//Coin.setItemDamage(Math.round(p_77659_3_.experienceTotal));
			p_77659_1_.setItemDamage(Math.round(p_77659_3_.experienceTotal));
			// HACK: I'm not sure this is the right function to us in 1.7+
			//Coin.setStackDisplayName("Soul Coin " +Integer.toString(p_77659_3_.experienceLevel)+ " " + 
			//		Integer.toString(p_77659_3_.experienceTotal));
			p_77659_1_.setStackDisplayName("Soul Coin " +Integer.toString(p_77659_3_.experienceLevel)+ " " + 
					Integer.toString(p_77659_3_.experienceTotal));
			p_77659_3_.experienceTotal = 0;
			p_77659_3_.experienceLevel = 0;
			p_77659_3_.experience = 0;
			
			return p_77659_1_;
		}
		else
		{
			if(p_77659_1_.getItemDamage() > 0)
			{
				p_77659_3_.addExperience(p_77659_1_.getItemDamage());
				p_77659_1_.setItemDamage(0);
				p_77659_1_.setStackDisplayName("Soul Coin");
			}
		
		}
		
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
		if(par1ItemStack.getItemDamage() > 0)
		{
			return true;
		}
		
		return false;
    }
}
