package org.dungeonsandshotguns.soulstorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CoinCraftHandler implements ICraftingHandler
{

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) 
	{
		
		if(item.getItem() == SoulStorage.CopperCoin50)
		{
			boolean CoinsTaken = false;
			
			for(int currentSlot = 0; currentSlot < craftMatrix.getSizeInventory(); currentSlot++)
			{
				if(craftMatrix.getStackInSlot(currentSlot) != null && craftMatrix.getStackInSlot(currentSlot).getItem() == SoulStorage.CopperCoin)
				{
					craftMatrix.setInventorySlotContents(currentSlot, null);
				}
			}
		}
		
		if(item.getItem() == SoulStorage.GoldCoin)
		{
			boolean CoinsTaken = false;
			
			for(int currentSlot = 0; currentSlot < craftMatrix.getSizeInventory(); currentSlot++)
			{
				if(craftMatrix.getStackInSlot(currentSlot) != null && craftMatrix.getStackInSlot(currentSlot).getItem() == SoulStorage.CopperCoin50)
				{
					craftMatrix.setInventorySlotContents(currentSlot, null);
				}
			}
		}
		
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) 
	{
		// TODO Auto-generated method stub
		
	}

}
