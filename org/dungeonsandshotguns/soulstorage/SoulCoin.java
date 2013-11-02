package org.dungeonsandshotguns.soulstorage;

import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SoulCoin extends Item 
{
	@Instance("SoulCoin")
	private final static Item SoulCoin = new SoulCoin(SoulStorage.EmptySoulCoinID);
	
	public SoulCoin(int id) 
	{
        super(id);
        
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("EmptySoulCoin");
        
        
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
	{
		//int CurrentItemSlot = par3EntityPlayer.inventory.currentItem;
		//par3EntityPlayer.inventory.setInventorySlotContents(CurrentItemSlot, null);
		//par3EntityPlayer.inventory.setInventorySlotContents(CurrentItemSlot, new ItemStack(SoulStorage.SoulCoin));
		if (par1ItemStack.getItemDamage() < 1 && par3EntityPlayer.experienceTotal > 0)
		{
			ItemStack Coin = new ItemStack(SoulStorage.SoulCoin);
			Coin.setItemDamage(par3EntityPlayer.experienceTotal);
			Coin.setItemName("Soul Coin " +Integer.toString(par3EntityPlayer.experienceLevel)+ " " + Integer.toString(par3EntityPlayer.experienceTotal));
			par3EntityPlayer.experienceTotal = 0;
			par3EntityPlayer.experienceLevel = 0;
			par3EntityPlayer.experience = 0;
			return Coin;
		}
		//Coin.setItemName("Soul Coin " + Integer.toString(par3EntityPlayer.experienceTotal));
		//ItemStack Coin = ItemStack.
		
		return par1ItemStack;
	}
	
	
}
