package org.dungeonsandshotguns.soulstorage;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.DispenserBehaviors;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class SpikedSnowBall extends ItemSnowball
{

	public SpikedSnowBall(int par1) 
	{
		super(par1);
		this.maxStackSize = 16;
	    this.setCreativeTab(CreativeTabs.tabMisc);
	    DispenserBehaviors.registerDispenserBehaviours();
	}
	
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        if (!par3EntityPlayer.capabilities.isCreativeMode)
	        {
	            --par1ItemStack.stackSize;
	        }

	        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	        //if (!par2World.isRemote)
	        //{
	            par2World.spawnEntityInWorld(new EntitySpikedSnowball(par2World, par3EntityPlayer));
	        //}

	        return par1ItemStack;
	    }
}
