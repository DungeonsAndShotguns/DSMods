package org.dungeonsandshotguns.dsmods.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class SpikedSnowBall extends ItemSnowball
{
	public static SpikedSnowBall SpikeSnowBall;
	
	public SpikedSnowBall()
	{
		this.maxStackSize = 16;
	    this.setCreativeTab(CreativeTabs.tabMisc);
	    this.setUnlocalizedName("spikedsnowball");
	    //DispenserBehaviors.registerDispenserBehaviours(); what is this in 1.7.10?????
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_,
			EntityPlayer p_77659_3_) 
	{
		//if (!p_77659_3_.capabilities.isCreativeMode)
        //{
		//	--p_77659_1_.stackSize;
        //}
		
		p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
	}
	
	
}
