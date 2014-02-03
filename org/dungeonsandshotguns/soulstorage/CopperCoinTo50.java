package org.dungeonsandshotguns.soulstorage;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class CopperCoinTo50 implements IRecipe 
{

	public static CopperCoinTo50 CraftingRec = new CopperCoinTo50();
	
	@Override
	public boolean matches(InventoryCrafting inventorycrafting, World world) 
	{
		//boolean oneSetOf50Coins = false;
		int CoinStack50 = 0;
		
		for(int currentSlot = 0; currentSlot < inventorycrafting.getSizeInventory(); currentSlot++)
		{
			if(inventorycrafting.getStackInSlot(currentSlot) != null)
			{
				if(inventorycrafting.getStackInSlot(currentSlot).isItemEqual( new ItemStack(SoulStorage.CopperCoin, 50)) && inventorycrafting.getStackInSlot(currentSlot).stackSize == 50)
				{
					CoinStack50++;
				}
			}
		}
		
		if (CoinStack50 == 1)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) 
	{
		return new ItemStack(SoulStorage.CopperCoin50);
	}

	@Override
	public int getRecipeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() 
	{
		return new ItemStack(SoulStorage.CopperCoin50);
	}

}
