package com.nachie.ClayForBalance.blocks;

import com.nachie.ClayForBalance.ClayForBalance;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockClay1 extends Block{
	public BlockClay1() {
        super(Material.CLAY);
        setHardness(1.0f);
        setResistance(5.0f);
        setUnlocalizedName(ClayForBalance.MODID + ".clay1");
        setRegistryName("block_clay_1");
    }
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "normal"));
	}
}
