package com.modapi.main.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.common.collect.Lists;
import com.modapi.main.api.Block.BlockBase;
import com.modapi.main.api.Mod.ModVersion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CommonProxy 
{
	public static ArrayList<String> Mods;
	
	public void preInit()
	{
		findMods();
	}
	
	public void load() 
	{
	    
	}
	
       
          
//You also need a GameRegistry and everything else you'd do to add a normal block (which varies depending on if you have a config or not.)
	public void postInit()
	{
	   
	}
	
	//TODO make this work!!!
	
	public boolean RegisterMods()
	{
		if(Loader.isModLoaded("FML")) return true;
		if(Loader.instance().isModLoaded("MainCore")) return true;
		
		return Mods != null;
	}
	
	public void findMods(){
		if(RegisterMods()==true){
			System.out.print("FML"+" & Maincore"+" loaded!!");
			
		}else{
			System.out.print("FML failed to load!!");
		}
	}
	
}
