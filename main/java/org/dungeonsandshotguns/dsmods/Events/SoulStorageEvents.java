package org.dungeonsandshotguns.dsmods.Events;

import java.util.Map;

import org.dungeonsandshotguns.dsmods.DSMod;
import org.dungeonsandshotguns.dsmods.Enchantments.Fragment;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class SoulStorageEvents 
{
	@SubscribeEvent
	public void OnPlayerAttack(AttackEntityEvent event)
	{
		EntityLivingBase attacked = event.entityLiving;
		//DamageSource sourceEnt = event.
		EntityPlayer player =event.entityPlayer;
		EntityPlayer playerAttacked = null;
		
		if (!(attacked instanceof EntityPlayer) == false)
		{	
			if (player.getHeldItem() != null)
			{
				if(player.getHeldItem().isItemEnchanted() == true) //inventoryContainer.getSlot(player.inventory.currentItem).getStack().isItemEnchanted())
				{
					Map EnNames = EnchantmentHelper.getEnchantments(player.getHeldItem() );
					for(int i= 0; i < EnNames.size(); i++)
					{
						if((Integer)EnNames.keySet().toArray()[i] == DSMod.soulSteal.effectId)
						{
							player.addExperience(((Fragment)DSMod.soulSteal).XPMulti);
							player.attackEntityFrom(DamageSource.generic, (float)0.5);
						}
					}
				}
			}
		}
		
		if (attacked instanceof EntityPlayer)
		{
			playerAttacked = (EntityPlayer)attacked;
			
			if (player.getHeldItem() != null)
			{
				if(player.getHeldItem().isItemEnchanted() == true)
				{
					Map EnNames = EnchantmentHelper.getEnchantments(player.getHeldItem());
					for(int i= 0; i < EnNames.size(); i++)
					{
						if((Integer)EnNames.keySet().toArray()[i] == DSMod.soulSteal.effectId)
						{
							if(playerAttacked.experienceTotal > ((Fragment)DSMod.soulSteal).XPMulti)
							{
								int XPTaken = ((Fragment)DSMod.soulSteal).XPMulti;
								int ToGiveBack = playerAttacked.experienceTotal - XPTaken;
							
								playerAttacked.experienceLevel = 0;
								playerAttacked.experience = 0;
								playerAttacked.experienceTotal = 0;
								playerAttacked.addExperience(ToGiveBack);
							
								player.addExperience(XPTaken);
							}
						}
					}
				}
			}
		}
	}

}
