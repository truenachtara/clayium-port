package com.nachie.ClayForBalance.common.blocks.machines;

import com.nachie.ClayForBalance.ClayForBalance;
import com.nachie.ClayForBalance.common.blocks.workbench.ClayWorkbenchTE;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BasicMachine extends Block implements ITileEntityProvider {

	public BasicMachine(String name) {
		super(Material.CLAY);
        setHardness(1.0f);
        setResistance(5.0f);
        setUnlocalizedName(ClayForBalance.MODID + "." + name);
        setRegistryName(name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new BasicMachineTileEntity();
	}
	
	private BasicMachineTileEntity getTE(IBlockAccess world, BlockPos pos) {
        return (BasicMachineTileEntity) world.getTileEntity(pos);
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }
    
	
}