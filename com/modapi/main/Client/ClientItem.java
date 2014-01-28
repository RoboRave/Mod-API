package com.modapi.main.Client;

import com.modapi.main.api.Item.ItemBase;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientItem {
	
	private static final ClientItem INSTANCE = new ClientItem();
	public Item Item2;
	public static ClientItem instance()
	{
		return INSTANCE;
	}
public ClientItem AddComplexItem(String InGameName,Item item, int ID ,int MaxDamage,int MaxStackSize,CreativeTabs creativetab, String UnlocalizedName){
		 item = new Item(ID - 256)
		.setFull3D()
		.setMaxDamage(MaxDamage)
		.setMaxStackSize(MaxStackSize)
		.setTextureName("ModAPI:"+"Item_"+UnlocalizedName)
		.setUnlocalizedName("Item_"+InGameName+".name")
		.setCreativeTab(creativetab);
		return this;
		
	}

public ClientItem AddSimpleItem(String InGameName, int ID,Item item,String UnlocalizedName,String ModName ){
		 item= new Item(ID)
		.setFull3D()
		.setTextureName(ModName+":"+"UnlocalizedName")
		.setUnlocalizedName(UnlocalizedName)
		.setCreativeTab(CreativeTabs.tabMaterials);
		Registry(item, InGameName, UnlocalizedName, ModName);
		return  this;
		
	}
public ClientItem AddTestItem(String InGameName, int ID,String UnlocalizedName,String ModName){
	Item item = new Item(ID)
	.setFull3D()
	.setTextureName(ModName+":"+UnlocalizedName)
	.setUnlocalizedName("item."+UnlocalizedName+".name")
	.setCreativeTab(CreativeTabs.tabMaterials);
	Registry(item, InGameName, UnlocalizedName, ModName);
	return  this;
	
}

public ClientItem Registry(Item item, String name, String UnlocalizedName,String ModName){
	
	GameRegistry.registerItem(item, "tile."+UnlocalizedName.replace(" ", "_")+".name",ModName);
	
	LanguageRegistry.addName(item, name);
	return this;
	
}
//////////////////////////////////////////////////////////////////////////////////////////
//--------------------------------------------------------------------------------------//
//-------------------------------------ITEM MANAGER-------------------------------------//
//--------------------------------------------------------------------------------------//
//////////////////////////////////////////////////////////////////////////////////////////
static int[] items = new int[5000];

public static void addItem(Item item)
{
	int i=0;
	while(items[i]!=0)
	{
		if(items[i]==item.itemID)
		{
			System.out.println("[MODAPI] [WARNING] Duplicated itemid adding: "+item.getUnlocalizedName()+".");
			}
		i++;
}
	items[i]=item.itemID;
	System.out.println("[MODAPI] [INFO] Added item: "+item.getUnlocalizedName()+" on ID "+item.itemID+".");
}

public static void registerItems()
{
	int i = 0;
	while(items[i]!=0)
	{
		if(Item.itemsList[items[i]] instanceof ItemBase)
		{
			LanguageRegistry.addName(Item.itemsList[items[i]], ((ItemBase) Item.itemsList[items[i]]).ingamename);
			System.out.println("[MODAPI] [INFO] Loaded item: "+Item.itemsList[items[i]].getUnlocalizedName()+" on ID "+items[i]+".");
			}
		i++;
		}
}
}
