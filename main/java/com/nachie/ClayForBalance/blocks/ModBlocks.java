package com.nachie.ClayForBalance.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ObjectHolder("clayforbalance")
public final class ModBlocks {
	
	public static final BlockClay1 BLOCK_CLAY_1 = null;
	
	@SideOnly(Side.CLIENT)
	public static void initClient() {
		BLOCK_CLAY_1.initModel();
	}
}
