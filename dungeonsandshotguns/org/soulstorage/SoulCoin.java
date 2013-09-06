package dungeonsandshotguns.org.soulstorage;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SoulCoin extends Item 
{
	public SoulCoin(int id)
	{
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		this.setItemName("SoulCoin"); //setUnlocalizedName("genericItem");
		this.setIconIndex(1);
	}
	
	
	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}
	
	
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) 
	{
		//par1ItemStack.damageItem(par3EntityPlayer.experienceTotal, par3EntityPlayer);
		if(par1ItemStack.getItemDamage() < 1)
		{
			par1ItemStack.setItemDamage(par3EntityPlayer.experienceTotal);
			par3EntityPlayer.experienceTotal = 0;
			par3EntityPlayer.experienceLevel = 0;
			par1ItemStack.setItemName("Soul Coin " + Integer.toString(par1ItemStack.getItemDamage()));
			//par1ItemStack. .setIconIndex(1);
			
			
		}
		else
		{
			par3EntityPlayer.addExperience(par1ItemStack.getItemDamage());
			par1ItemStack.setItemName("Soul Coin");
			par1ItemStack.setItemDamage(0);
			//this.setIconIndex(0);
		}
		
		return par1ItemStack;
		//return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
}
