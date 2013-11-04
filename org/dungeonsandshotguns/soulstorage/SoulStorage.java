package org.dungeonsandshotguns.soulstorage;

import java.util.Stack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="SoulStorage", name="Soul Storage", version="1.6.4.2")
@NetworkMod(clientSideRequired=true)
public class SoulStorage 
{
	@Instance(value = "SoulStorageID")
	public static SoulStorage instance;
	
	public static EnumToolMaterial SoulMat;
	
	public static Item EmptySoulCoin;
	public static Item SoulCoin;
	public static Item CopperCoin;
	public static Item IronCoin;
	public static Item GoldCoin;
	public static Item SteelCoin;
	//public static Item SoulSword;
	public static Enchantment Steel;
	
	public static int SoulCoinID;
	public static int EmptySoulCoinID;
	public static int CopperCoinID;
	public static int IronCoinID;
	public static int GoldCoinID;
	public static int SteelCoinID;
	
	public static boolean PVPSoulSteel;
	public static int SoulSteelID;
	
	public static Item SpikedSnow;
	public static int SpikedSnowID;
	
	@SidedProxy(clientSide="org.dungeonsandshotguns.soulstorage.client.ClientProxy", serverSide="org.dungeonsandshotguns.soulstorage.CommonProxy")
    public static CommonProxy proxy;
	
	@EventHandler // used in 1.6.2
	public void preInit(FMLPreInitializationEvent event) 
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		
		//Add my events
		//AddEvents();
		MinecraftForge.EVENT_BUS.register(new EventSoul());
		
		// Add new matrial
		//CreateMaterial();
		SoulMat = new EnumHelper().addToolMaterial("Soul", 3, 1000, 6.7F, 5, 0);
		
		// load config file
		//LoadConfigs(config);
		config.load();
		SoulCoinID = config.get(Configuration.CATEGORY_ITEM, "SoulCoin", 6001).getInt();
		EmptySoulCoinID = config.get(Configuration.CATEGORY_ITEM, "EmptySoulCoin", 6000).getInt();
		CopperCoinID = config.get(Configuration.CATEGORY_ITEM, "CopperCoin", 6002).getInt();
		IronCoinID = config.get(Configuration.CATEGORY_ITEM, "IronCoin", 6003).getInt();
		GoldCoinID = config.get(Configuration.CATEGORY_ITEM, "GoldCoin", 6004).getInt();
		SteelCoinID = config.get(Configuration.CATEGORY_ITEM, "SteelCoin", 6005).getInt();
		SpikedSnowID = config.get(Configuration.CATEGORY_ITEM, "SpikedSnow", 6007).getInt();
		int SoulSwordID = config.get(Configuration.CATEGORY_ITEM, "SoulSword", 6006).getInt();
		int SoulSteelID = config.get("Enchantments", "SoulSteelID", 201).getInt();
		int SoulSteel = config.get("Enchantments", "SoulSteelMultipler", 1).getInt();
		PVPSoulSteel = config.get("Enchantments", "SoulSteelPVP", true).getBoolean(true); 
		config.save();
		
		// Initilize Items
		//InitItems();
		EmptySoulCoin = new SoulCoin(EmptySoulCoinID).setTextureName("soulstorage:SoulCoin");
        SoulCoin = new SoulCoinFull(SoulCoinID).setTextureName("soulstorage:SoulCoinFull");
        CopperCoin = new CopperCoin(CopperCoinID).setTextureName("soulstorage:CopperCoin");
        IronCoin = new IronCoin(IronCoinID).setTextureName("soulstorage:IronCoin");
        GoldCoin = new GoldCoin(GoldCoinID).setTextureName("soulstorage:GoldCoin");
        SteelCoin = new SteelCoin(SteelCoinID).setTextureName("soulstorage:SteelCoin");
        //SoulSword = new SoulSword(SoulSwordID).setTextureName("Soulstorage:SoulSword");
        Steel = new SoulSteel(SoulSteelID, 1);
        SpikedSnow = new SpikedSnowBall(SpikedSnowID).setTextureName("soulstorage:SpikedSnowBall");
        
        //BlockDispenser.dispenseBehaviorRegistry.putObject(SpikedSnow, new EntitySpikedSnowball());
     }
	
	@EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event) 
	{
        RegisterNames();
        proxy.registerRenderers();
        
        // Crafting
        CraftingRecp();
    }
	
	@EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) 
	{
            // Stub Method
    }
	
	private void AddEvents()
	{
		MinecraftForge.EVENT_BUS.register(new EventSoul());
	}
	
	private void CreateMaterial()
	{
		// Soul has roughly the durabilty of Diamond and Attack Power of Gold
		// It can also mine up to obsidion
		// the special property of this matrial is coverting damage in to xp
		SoulMat = new EnumHelper().addToolMaterial("Soul", 3, 1000, 6.7F, 5, 0);
	}

	private void LoadConfigs(Configuration config)
	{
		config.load();
		SoulCoinID = config.get(Configuration.CATEGORY_ITEM, "SoulCoin", 6001).getInt();
		EmptySoulCoinID = config.get(Configuration.CATEGORY_ITEM, "EmptySoulCoin", 6000).getInt();
		CopperCoinID = config.get(Configuration.CATEGORY_ITEM, "CopperCoin", 6002).getInt();
		IronCoinID = config.get(Configuration.CATEGORY_ITEM, "IronCoin", 6003).getInt();
		GoldCoinID = config.get(Configuration.CATEGORY_ITEM, "GoldCoin", 6004).getInt();
		SteelCoinID = config.get(Configuration.CATEGORY_ITEM, "SteelCoin", 6005).getInt();
		SpikedSnowID = config.get(Configuration.CATEGORY_ITEM, "SpikedSnow", 6007).getInt();
		int SoulSwordID = config.get(Configuration.CATEGORY_ITEM, "SoulSword", 6006).getInt();
		int SoulSteelID = config.get("Enchantments", "SoulSteelID", 201).getInt();
		int SoulSteel = config.get("Enchantments", "SoulSteelMultipler", 1).getInt();
		PVPSoulSteel = config.get("Enchantments", "SoulSteelPVP", true).getBoolean(true); 
		config.save();
	}

	private void InitItems()
	{
		EmptySoulCoin = new SoulCoin(EmptySoulCoinID).setTextureName("soulstorage:SoulCoin");
        SoulCoin = new SoulCoinFull(SoulCoinID).setTextureName("soulstorage:SoulCoinFull");
        CopperCoin = new CopperCoin(CopperCoinID).setTextureName("soulstorage:CopperCoin");
        IronCoin = new IronCoin(IronCoinID).setTextureName("soulstorage:IronCoin");
        GoldCoin = new GoldCoin(GoldCoinID).setTextureName("soulstorage:GoldCoin");
        SteelCoin = new SteelCoin(SteelCoinID).setTextureName("soulstorage:SteelCoin");
        //SoulSword = new SoulSword(SoulSwordID).setTextureName("Soulstorage:SoulSword");
        Steel = new SoulSteel(SoulSteelID, 1);
        SpikedSnow = new SpikedSnowBall(SpikedSnowID).setTextureName("soulstorage:SpikedSnowBall");
	}

	private void RegisterNames()
	{
		LanguageRegistry.addName(EmptySoulCoin, "Empty Soul Coin");
        LanguageRegistry.addName(SoulCoin, "Soul Coin");
        LanguageRegistry.addName(CopperCoin, "Copper Coin");
        LanguageRegistry.addName(IronCoin, "Iron Coin");
        LanguageRegistry.addName(GoldCoin, "Gold Coin");
        LanguageRegistry.addName(SteelCoin, "Steel Coin");
        //LanguageRegistry.addName(SoulSword, "Soul Blade");
        LanguageRegistry.addName(SpikedSnow, "Spiked Snow Ball");
	}

	private void CraftingRecp()
	{
		ItemStack QuatrzC = new ItemStack(Item.netherQuartz);
        ItemStack IronI = new ItemStack(Item.blazePowder);
        ItemStack NethBrick = new ItemStack(Item.netherrackBrick);
        GameRegistry.addShapedRecipe(new ItemStack(EmptySoulCoin), "BIB", "IQI", "BIB", 'B', NethBrick, 'I', IronI, 'Q', QuatrzC);
        
        //Soul Stealer Sword Crafting
        //ItemStack NeStart = new ItemStack(Item.netherStar);
        //ItemStack SoulCoinMat = new ItemStack(EmptySoulCoin);
        //ItemStack Leath = new ItemStack(Block.slowSand);
        //ItemStack Obs = new ItemStack(Block.obsidian);
        //GameRegistry.addShapedRecipe(new ItemStack(SoulSword), " C ", " S ", "LOL", 'C', SoulCoinMat, 'S', NeStart, 'L', Leath, 'O', Obs);
        
        //Copper to Iron
        ItemStack CopCoin = new ItemStack(CopperCoin);
        GameRegistry.addShapedRecipe(new ItemStack(IronCoin), "CCC", "CCC", "CCC", 'C', CopCoin);
        
        //Iron To Gold
        ItemStack IroCoin = new ItemStack(IronCoin);
        GameRegistry.addShapedRecipe(new ItemStack(GoldCoin), "CCC", "CCC", "CCC", 'C', IroCoin);
        
        //Gold to Steel
        ItemStack GolCoin = new ItemStack(GoldCoin);
        GameRegistry.addShapedRecipe(new ItemStack(SteelCoin), "CCC", "CCC", "CCC", 'C', GolCoin);
        
        ItemStack SnowB = new ItemStack(Item.snowball);
        ItemStack CobbleS = new ItemStack(Block.cobblestone);
        GameRegistry.addShapedRecipe(new ItemStack(SpikedSnow, 16), "SSS", "SCS", "SSS", 'S', SnowB, 'C', CobbleS);
	}
}

