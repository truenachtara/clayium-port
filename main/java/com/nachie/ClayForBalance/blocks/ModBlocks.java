package com.nachie.ClayForBalance.blocks;

import com.nachie.ClayForBalance.blocks.workbench.ClayWorktable;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ObjectHolder("clayforbalance")
public final class ModBlocks {
	
	public static final ClayWorktable CLAYWORKTABLE = null;
	
	@SideOnly(Side.CLIENT)
	public static void initClient() {
		CLAYWORKTABLE.initModel();
	}
}
