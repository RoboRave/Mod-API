package com.modapi.main.Client;

import com.modapi.main.api.Block.BlockBase;
import com.modapi.main.api.Item.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends com.modapi.main.Server.CommonProxy{
	//public static Block Test;
	private static final ClientProxy INSTANCE = new ClientProxy();
	//private Block block;
	@Deprecated
	public static ClientProxy instance()
	{
		return INSTANCE;
	}
	public String getCurrentLanguage() {
		// TODO Auto-generated method stub
		return null;
	}
}