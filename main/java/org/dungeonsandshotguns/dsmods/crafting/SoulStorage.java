package org.dungeonsandshotguns.dsmods.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import org.dungeonsandshotguns.dsmods.items.*;

public class SoulStorage 
{
	public static void Register()
	{
		ItemStack QuatrzC = new ItemStack(Items.quartz);
        ItemStack IronI = new ItemStack(Items.blaze_powder);
        ItemStack NethBrick = new ItemStack(Items.netherbrick);
        GameRegistry.addShapedRecipe(new ItemStack(EmptySoulCoin.SoulCoin),
        		"BIB", "IQI", "BIB", 'B', NethBrick, 'I', IronI, 'Q', QuatrzC);
	}
}
