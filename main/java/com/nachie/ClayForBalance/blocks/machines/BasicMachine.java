package com.nachie.ClayForBalance.blocks.machines;

import com.nachie.ClayForBalance.ClayForBalance;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BasicMachine<T extends GenericTileEntity, C extends Container> extends GenericBlock<T, C> {

    public BasicMachine(Material material,
                               Class<? extends T> tileEntityClass,
                               Class<? extends C> containerClass,
                               String name, boolean isContainer) {
        super(ClayForBalance.instance, material, tileEntityClass, containerClass, GenericItemBlock.class, name, isContainer);
    }

    public BasicMachine(Material material,
                               Class<? extends T> tileEntityClass,
                               Class<? extends C> containerClass,
                               Class<? extends ItemBlock> itemBlockClass,
                               String name, boolean isContainer) {
        super(ClayForBalance.instance, material, tileEntityClass, containerClass, itemBlockClass, name, isContainer);

    }
}