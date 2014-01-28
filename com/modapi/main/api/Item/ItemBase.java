package com.modapi.main.api.Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
	public String ingamename="";
	
	public ItemBase(int id)
	{
		super(id);
	}
	
	public ItemBase setInGameName(String name)
	{
		this.ingamename=name;
		return this;
	}
	
	public ItemBase setTextureFile(String texture)
	{
		this.registerIcons(null, texture);
		return this;
	}
	  @SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister par1IconRegister, String Name)
	    {
	        this.itemIcon = par1IconRegister.registerIcon( Name + ":" + (this.getUnlocalizedName().substring(5)));
	    }
}
