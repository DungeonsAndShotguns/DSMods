package org.dungeonsandshotguns.dsmods.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import org.dungeonsandshotguns.dsmods.items.*;

public class Other 
{
	public static void Register()
	{
		ItemStack SnowB = new ItemStack(Items.snowball);
        ItemStack CobbleS = new ItemStack(Blocks.cobblestone);
        //SpikedSnowBall tempItem = new SpikedSnowBall();
        //GameRegistry.addShapedRecipe(new ItemStack(tempItem, 16), "SSS", "SCS", "SSS", 'S', SnowB, 'C', CobbleS);
        GameRegistry.addShapedRecipe(new ItemStack(SpikedSnowBall.SpikeSnowBall, 16), "SSS", "SCS", "SSS", 'S', SnowB, 'C', CobbleS);
	}
}
