package com.nachie.ClayForBalance.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ObjectHolder("clayforbalance")
public class ModItems {
	public static final ItemKnife ITEM_KNIFE = null;
	public static final ItemRollingPin ITEM_ROLLING_PIN = null;
	public static final ItemSlicer ITEM_SLICER = null;

	@SideOnly(Side.CLIENT)
	public static void initClient() {
		ITEM_KNIFE.initModel();
		ITEM_ROLLING_PIN.initModel();
		ITEM_SLICER.initModel();
	}
}
