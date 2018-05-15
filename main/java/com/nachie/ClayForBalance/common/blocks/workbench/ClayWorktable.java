package com.nachie.ClayForBalance.common.blocks.workbench;

import com.nachie.ClayForBalance.ClayForBalance;
import com.nachie.ClayForBalance.common.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClayWorktable extends Block implements ITileEntityProvider{

	public ClayWorktable() {
        super(Material.CLAY);
        setHardness(1.0f);
        setResistance(5.0f);
        setUnlocalizedName(ClayForBalance.MODID + ".clayworktable");
        setRegistryName("clayworktable");
    }
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
        ClientRegistry.bindTileEntitySpecialRenderer(ClayWorkbenchTE.class, new ClayWorkbenchTESR());
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ClayWorkbenchTE();
	}
	
	private ClayWorkbenchTE getTE(IBlockAccess world, BlockPos pos) {
        return (ClayWorkbenchTE) world.getTileEntity(pos);
    }
	
	@Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }
	
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }
    
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
						
		if(!world.isRemote) {
			ClayWorkbenchTE te = getTE(world, pos);
			
			HandTableOutcome whatComesOut = HandTableRecipes.IterateHandTableRecipes(te.getStack(),player.getHeldItem(hand));
			
			System.out.println(whatComesOut.getPrimaryOutput());
			System.out.println(whatComesOut.getSecondaryOutput());
			
			if(whatComesOut.getPrimaryOutput() != ItemStack.EMPTY || whatComesOut.getSecondaryOutput() != ItemStack.EMPTY) {
				if(whatComesOut.getPrimaryOutput() != ItemStack.EMPTY) {
					EntityItem primaryOutput = new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), whatComesOut.getPrimaryOutput());
	                world.spawnEntity(primaryOutput);
				}
				if(whatComesOut.getSecondaryOutput() != ItemStack.EMPTY) {
					EntityItem SecondaryOutput = new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), whatComesOut.getSecondaryOutput());
	                world.spawnEntity(SecondaryOutput);
				}
				
				if(whatComesOut.getPrimaryOutput().getItem() == ModItems.LARGECLAYBALL) {
					ItemStack within = te.getStack();
					within.shrink(6);
					te.setStack(within);
				} else {
					ItemStack within = te.getStack();
					within.shrink(1);
					te.setStack(within);
				}
				
			} 
			else if(te.getStack().isEmpty()) 
			{
				if (!player.getHeldItem(hand).isEmpty()) 
				{
					System.out.println(player.getHeldItem(hand).getItem());
					
					te.setStack(player.getHeldItem(hand));
				    player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
				    player.openContainer.detectAndSendChanges();
					}	

			} 
			else 
			{
				ItemStack stack = te.getStack();
                te.setStack(ItemStack.EMPTY);
                EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), stack);
                world.spawnEntity(entityItem);                
			}
		}
		return true;
	}	
	
	
	
}
