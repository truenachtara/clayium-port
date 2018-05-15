package com.nachie.ClayForBalance.proxy;

import com.nachie.ClayForBalance.common.blocks.machines.bending.ClayBendingMachine;
import com.nachie.ClayForBalance.common.blocks.machines.bending.ClayBendingMachineContainer;
import com.nachie.ClayForBalance.common.blocks.machines.bending.ClayBendingMachineGui;
import com.nachie.ClayForBalance.common.blocks.machines.bending.ClayBendingMachineTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof ClayBendingMachineTileEntity) {
            return new ClayBendingMachineContainer(player.inventory, (ClayBendingMachineTileEntity) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof ClayBendingMachineTileEntity) {
        	ClayBendingMachineTileEntity containerTileEntity = (ClayBendingMachineTileEntity) te;
            return new ClayBendingMachineGui(containerTileEntity, new ClayBendingMachineContainer(player.inventory, containerTileEntity));
        }
        return null;
    }
}