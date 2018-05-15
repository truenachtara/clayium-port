package com.nachie.ClayForBalance.common.items;

import com.nachie.ClayForBalance.ClayForBalance;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemClayStick extends Item{
	public ItemClayStick() {
        setRegistryName("claystick");
        setUnlocalizedName(ClayForBalance.MODID + ".claystick");
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "normal"));
	}
	
}
