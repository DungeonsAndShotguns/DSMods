package org.dungeonsandshotguns.soulstorage;

import java.util.Map;

import com.google.common.collect.Multiset.Entry;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class EventSoul 
{
	@ForgeSubscribe
	public void AttackCheck(LivingAttackEvent event)
	{
		EntityLivingBase attacked = event.entityLiving;
		DamageSource sourceEnt = event.source;
		EntityPlayer player = null;
		EntityPlayer playerAttacked = null;
		
		if (sourceEnt.getEntity() instanceof EntityPlayer && (attacked instanceof EntityPlayer) == false)
		{
			player = (EntityPlayer)sourceEnt.getEntity();
			
			if (player.getHeldItem() != null)
			{
				if(player.getCurrentItemOrArmor(0).isItemEnchanted() == true) //inventoryContainer.getSlot(player.inventory.currentItem).getStack().isItemEnchanted())
				{
					Map EnNames = EnchantmentHelper.getEnchantments(player.getCurrentItemOrArmor(0));
					for(int i= 0; i < EnNames.size(); i++)
					{
						if((Integer)EnNames.keySet().toArray()[i] == SoulStorage.Steel.effectId)
						{
							player.addExperience(((SoulSteel)SoulStorage.Steel).XPMulti);
							player.attackEntityFrom(DamageSource.generic, (float)0.5);
						}
					}
				}
			}
		}
		
		if (sourceEnt.getEntity() instanceof EntityPlayer && attacked instanceof EntityPlayer && SoulStorage.PVPSoulSteel == true)
		{
			player = (EntityPlayer)sourceEnt.getEntity();
			playerAttacked = (EntityPlayer)attacked;
			
			if (player.getHeldItem() != null)
			{
				if(player.getCurrentItemOrArmor(0).isItemEnchanted() == true)
				{
					Map EnNames = EnchantmentHelper.getEnchantments(player.getCurrentItemOrArmor(0));
					for(int i= 0; i < EnNames.size(); i++)
					{
						if((Integer)EnNames.keySet().toArray()[i] == SoulStorage.Steel.effectId)
						{
							if(playerAttacked.experienceTotal > ((SoulSteel)SoulStorage.Steel).XPMulti)
							{
								int XPTaken = ((SoulSteel)SoulStorage.Steel).XPMulti;
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
