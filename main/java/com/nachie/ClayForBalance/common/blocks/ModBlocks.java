package com.nachie.ClayForBalance.common.blocks;

import com.nachie.ClayForBalance.common.blocks.machines.bending.ClayBendingMachine;
import com.nachie.ClayForBalance.common.blocks.workbench.ClayWorktable;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ObjectHolder("clayforbalance")
public final class ModBlocks {
	
	public static final ClayWorktable CLAYWORKTABLE = null;
	public static final ClayBendingMachine CLAYBENDINGMACHINE = null;
	
	@SideOnly(Side.CLIENT)
	public static void initClient() {
		CLAYWORKTABLE.initModel();
		CLAYBENDINGMACHINE.initModel();
	}
}
