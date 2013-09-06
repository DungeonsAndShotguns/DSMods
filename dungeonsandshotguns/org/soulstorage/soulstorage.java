package dungeonsandshotguns.org.soulstorage;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="SoulStorage", name="Soul Storage", version="0.0.0")
@NetworkMod(clientSideRequired=true)
public class soulstorage 
{
	@Instance(value = "SoulStorage")
    public static soulstorage instance;
	
	 @SidedProxy(clientSide="dungeonsandshotguns.org.soulstorage.ClientProxy", serverSide="dungeonsandshotguns.org.soulstorage.CommonProxy")
     public static CommonProxy proxy;
	 
	 private final static Item soulCoin = new SoulCoin(5000);
	 
	 @PreInit
	 public void preInit(FMLPreInitializationEvent event) 
	 {
			// Stub Method
		
	 }
	 
	 @Init
	 public void load(FMLInitializationEvent event) 
	 {
		 LanguageRegistry.addName(soulCoin, "Soul Coin");
		 
		 // Crafting
		 ItemStack soulSand = new ItemStack(Block.slowSand);
		 ItemStack goldNug = new ItemStack(Item.goldenCarrot);
		 ItemStack neatherStar = new ItemStack(Item.netherStar);
		 
		 GameRegistry.addRecipe(new ItemStack(soulCoin), "sgs", "gng", "sgs", 's', soulSand, 'g', goldNug, 'n', neatherStar);
	 }
		
	 @PostInit
	 public void postInit(FMLPostInitializationEvent event) 
	 {
			// Stub Method
	 }

}
