package com.vm.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class TileEntityBlock extends Block implements ITileEntityProvider {

	TileEntity tile = null;
	
	public TileEntityBlock(Material materialIn, TileEntity tile) {
		super(materialIn);
		this.tile = tile;
		// TODO Auto-generated constructor stub
	}

	@Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
	
	@Override
	 public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return tile;
    }
	
}
