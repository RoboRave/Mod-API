package com.modapi.main.api.Block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockBase extends Block
{
	public String ingamename = "";
	
	int IDDropped = this.blockID;
	
	int amountdropped=1;
	
	int xpdropped=0;
	
	public String harvesttool="";
	
	public int harvestlevel = 0;
	
	boolean opaquecube = true;
	
	public BlockBase(int id, Material material)
	{
		super(id, material);
	}
	
	
	public BlockBase setNonOpaqueCube()
	{
		this.opaquecube=false;
		return this;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return this.opaquecube;
	}
	
	public BlockBase setXpDropped(int amount)
	{
		this.xpdropped=amount;
		return this;
	}
	
	public BlockBase setInGameName(String name)
	{
		this.ingamename=name;
		return this;
	}
	
	public BlockBase setHarvestLevel(String tool, int level)
	{
		this.harvesttool=tool;
		this.harvestlevel=level;
		return this;
	}
	
	public BlockBase setIdDropped(int id)
	{
		this.IDDropped=id;
		return this;
	}
	
	public BlockBase setQuantityDropped(int amount)
	{
		this.amountdropped=amount;
		return this;
	}
	
	@Override
	public int quantityDropped(Random par1Random)
    {
        return this.amountdropped;
    }
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.IDDropped;
    }
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int par5)
	{
		dropXpOnBlockBreak(world, x, y, z, this.xpdropped);
	}
}