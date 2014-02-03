package org.dungeonsandshotguns.soulstorage;

import cpw.mods.fml.common.Optional.Method;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class PriceCommand extends CommandBase 
{

	@Override
	public String getCommandName() 
	{
		return "Price";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "Hold an Item and use this command to get the price of the object";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) 
	{
		if(((EntityPlayer)icommandsender).inventory.getCurrentItem() != null)
		{
			String ItemName = ((EntityPlayer)icommandsender).inventory.getCurrentItem().getItem().getUnlocalizedName();
			String ItemNiceName = ((EntityPlayer)icommandsender).inventory.getCurrentItem().getItem().getStatName();
			
			if(SoulStorage.PriceIndex.containsKey(ItemName) == true)
			{
				((EntityPlayer)icommandsender).addChatMessage("Current price of " + ItemNiceName + " is " + SoulStorage.PriceIndex.get(ItemName));
			}
			else
			{
				((EntityPlayer)icommandsender).addChatMessage("No price was found for " + ItemNiceName + " at this time");
			}
		}
	}

}
