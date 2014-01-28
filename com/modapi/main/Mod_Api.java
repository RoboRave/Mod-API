package com.modapi.main;

import com.modapi.main.Server.CommonProxy;
import com.modapi.main.api.Block.BlockBase;
import com.modapi.main.Client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "Mod-Api", version="2.0",name="Mod API Base",dependencies="required-after:Forge@[9.11.1.953,);required-after:Mod-API:Core@[3.0.0.20,3.0.0.25]")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Mod_Api {
	
	@SidedProxy
	(clientSide="com.modapi.main.Client.CombinedClientProxy", 
	serverSide="com.modapi.main.Server.DedicatedServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		proxy.preInit();
		
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event)
	{
		proxy.load();
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		proxy.postInit();
	}
}
