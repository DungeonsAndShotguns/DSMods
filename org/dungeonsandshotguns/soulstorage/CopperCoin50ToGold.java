package org.dungeonsandshotguns.soulstorage;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class CopperCoin50ToGold implements IRecipe 
{
	public static CopperCoin50ToGold CraftingRec = new CopperCoin50ToGold();
	
	@Override
	public boolean matches(InventoryCrafting inventorycrafting, World world) 
	{
		int CoinStack2 = 0;
		
		for(int currentSlot = 0; currentSlot < inventorycrafting.getSizeInventory(); currentSlot++)
		{
			if(inventorycrafting.getStackInSlot(currentSlot) != null)
			{
				if(inventorycrafting.getStackInSlot(currentSlot).isItemEqual(new ItemStack(SoulStorage.CopperCoin50, 2)) && inventorycrafting.getStackInSlot(currentSlot).stackSize == 2)
				{
					CoinStack2++;
				}
			}
		}
		
		if (CoinStack2 == 1)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) 
	{
		return new ItemStack(SoulStorage.GoldCoin);
	}

	@Override
	public int getRecipeSize() 
	{
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() 
	{
		return new ItemStack(SoulStorage.GoldCoin);
	}

}
