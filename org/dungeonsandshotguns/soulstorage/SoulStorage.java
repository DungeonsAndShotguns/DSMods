package org.dungeonsandshotguns.soulstorage;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="SoulStorage", name="Soul Storage", version="1.6.4.4")
@NetworkMod(clientSideRequired=true)
public class SoulStorage 
{
	@Instance(value = "SoulStorageID")
	public static SoulStorage instance;
	
	public static Map<String, Integer> PriceIndex = new HashMap<String, Integer>();
	
	public static EnumToolMaterial SoulMat;
	
	// Items
	public static Item EmptySoulCoin;
	public static Item SoulCoin;
	public static Item CopperCoin;
	public static Item CopperCoin50;
	public static Item GoldCoin;
	public static Item GoldCoin50;
	public static Item SteelCoin;
	public static Item SilverCoin;
	public static Item SpikedSnow;
	
	// Enchantments
	public static Enchantment Steel;
	
	// Item IDS 
	public static int SoulCoinID;
	public static int EmptySoulCoinID;
	public static int CopperCoinID;
	public static int CopperCoin50ID;
	public static int GoldCoinID;
	public static int GoldCoin50ID;
	public static int SteelCoinID;
	public static int SilverCoinID;
	public static int SpikedSnowID;
	
	// Enchament Options
	public static boolean PVPSoulSteel;
	public static int SoulSteelID;
	public static int SSMultipler;
	
	@SidedProxy(clientSide="org.dungeonsandshotguns.soulstorage.client.ClientProxy", serverSide="org.dungeonsandshotguns.soulstorage.CommonProxy")
    public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		//Add my events
		MinecraftForge.EVENT_BUS.register(new EventSoul());
		GameRegistry.registerCraftingHandler(new CoinCraftHandler());
		
		// Add new material
		CreateMaterial();
		
		// load config file
		LoadConfigs(config);
		
		// Initialize Items
		InitItems();
        
        //BlockDispenser.dispenseBehaviorRegistry.putObject(SpikedSnow, new EntitySpikedSnowball());
     }
	
	@EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event) 
	{
        RegisterNames();
        proxy.registerRenderers();
        
        // Crafting
        CraftingRecp();
        RegisterPrices();
    }
	
	@EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) 
	{
            // Stub Method
    }
	
	@EventHandler
	public void serverStart(FMLServerStartingEvent event)
	{
		// Registering new commands for the console
	         MinecraftServer server = MinecraftServer.getServer();
	         // Get's the current server instance
	         
	         ServerCommandManager manager = (ServerCommandManager)server.getCommandManager();
	         manager.registerCommand(new PriceCommand());
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
		CopperCoin50ID = config.get(Configuration.CATEGORY_ITEM, "CopperCoin50", 6009).getInt();
		GoldCoinID = config.get(Configuration.CATEGORY_ITEM, "GoldCoin", 6004).getInt();
		GoldCoin50ID = config.get(Configuration.CATEGORY_ITEM, "GoldCoin50", 6010).getInt();
		SilverCoinID = config.get(Configuration.CATEGORY_ITEM, "SilverCoin", 6008).getInt();
		SpikedSnowID = config.get(Configuration.CATEGORY_ITEM, "SpikedSnow", 6007).getInt();
		int SoulSwordID = config.get(Configuration.CATEGORY_ITEM, "SoulSword", 6006).getInt();
		SoulSteelID = config.get("Enchantments", "SoulSteelID", 201).getInt();
		SSMultipler = config.get("Enchantments", "SoulSteelMultipler", 1).getInt();
		PVPSoulSteel = config.get("Enchantments", "SoulSteelPVP", true).getBoolean(true); 
		config.save();
	}

	private void InitItems()
	{
		EmptySoulCoin = new SoulCoin(EmptySoulCoinID).setTextureName("soulstorage:SoulCoin");
        SoulCoin = new SoulCoinFull(SoulCoinID).setTextureName("soulstorage:SoulCoinFull");
        CopperCoin = new CopperCoin(CopperCoinID).setTextureName("soulstorage:CopperCoin1");
        CopperCoin50 = new CopperCoin50(CopperCoin50ID).setTextureName("soulstorage:CopperCoin2");
        GoldCoin = new GoldCoin(GoldCoinID).setTextureName("soulstorage:GoldCoin1");
        GoldCoin50 = new GoldCoin50(GoldCoin50ID).setTextureName("soulstorage:GoldCoin2");
        SilverCoin = new  SilverCoin(SilverCoinID).setTextureName("Soulstorage:SilverCoin1");
        Steel = new SoulSteel(SoulSteelID, SSMultipler);
        SpikedSnow = new SpikedSnowBall(SpikedSnowID).setTextureName("soulstorage:SpikedSnowBall");
	}

	private void RegisterNames()
	{
		LanguageRegistry.addName(EmptySoulCoin, "Empty Soul Coin");
        LanguageRegistry.addName(SoulCoin, "Soul Coin");
        LanguageRegistry.addName(CopperCoin, "Copper Coin");
        LanguageRegistry.addName(CopperCoin50, "50 Copper Coins");
        LanguageRegistry.addName(GoldCoin, "Gold Coin");
        LanguageRegistry.addName(GoldCoin50, "50 Gold Coins");
        //LanguageRegistry.addName(SoulSword, "Soul Blade");
        LanguageRegistry.addName(SpikedSnow, "Spiked Snow Ball");
	}

	private void RegisterPrices()
	{
		PriceIndex.put(Block.dirt.getUnlocalizedName(), 1);
		PriceIndex.put(GoldCoin.getUnlocalizedName(), ((GoldCoin)GoldCoin).BaseEconValue());
	}
	
	private void CraftingRecp()
	{
		ItemStack QuatrzC = new ItemStack(Item.netherQuartz);
        ItemStack IronI = new ItemStack(Item.blazePowder);
        ItemStack NethBrick = new ItemStack(Item.netherrackBrick);
        GameRegistry.addShapedRecipe(new ItemStack(EmptySoulCoin), "BIB", "IQI", "BIB", 'B', NethBrick, 'I', IronI, 'Q', QuatrzC);
        
        // for all coins check the coin crafting handler for the other half of the coin output
        // Coin Crafting Chain
        GameRegistry.addRecipe(CopperCoinTo50.CraftingRec);
        GameRegistry.addRecipe(CopperCoin50ToGold.CraftingRec);
        
        ItemStack SnowB = new ItemStack(Item.snowball);
        ItemStack CobbleS = new ItemStack(Block.cobblestone);
        GameRegistry.addShapedRecipe(new ItemStack(SpikedSnow, 16), "SSS", "SCS", "SSS", 'S', SnowB, 'C', CobbleS);
	}
}

