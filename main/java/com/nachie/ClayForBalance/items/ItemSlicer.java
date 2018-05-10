package com.nachie.ClayForBalance.items;

import com.nachie.ClayForBalance.ClayForBalance;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSlicer extends Item{
	public ItemSlicer() {
        setRegistryName("slicer");
        setUnlocalizedName(ClayForBalance.MODID + ".item_slicer");
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "normal"));
	}
}
