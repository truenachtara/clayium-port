package com.nachie.ClayForBalance.common.blocks.machines.bending;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import java.util.Random;

public class ClayBendingMachineContainer extends Container {
	private ClayBendingMachineTileEntity te;
	private Random slotRNG = new Random();

    public ClayBendingMachineContainer(IInventory playerInventory, ClayBendingMachineTileEntity te) {
        this.te = te;

        // This container references items out of our own inventory (the 9 slots we hold ourselves)
        // as well as the slots from the player inventory so that the user can transfer items between
        // both inventories. The two calls below make sure that slots are defined for both inventories.
        addOwnSlots();
        addPlayerSlots(playerInventory);
    }

    protected int getOCD() {
        int ocd = slotRNG.nextInt(9);
        if (ocd > 4){
            ocd = ocd - 9;
        }
        return ocd;
    }

    private void addPlayerSlots(IInventory playerInventory) {
        // Slots for the main inventory
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                int x = 9 + col * 26;
                int y = row * 26 + 72;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 9, x + getOCD(), y + getOCD()));
            }
        }

        // Slots for the hotbar
        for (int row = 0; row < 9; ++row) {
            int x = 9 + row * 26;
            int y = 98 + 72;
            this.addSlotToContainer(new Slot(playerInventory, row, x + getOCD(), y + getOCD()));
        }
    }

    private void addOwnSlots() {
        IItemHandler inputHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        IItemHandler energyHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.WEST);
        IItemHandler outputHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);

        // Add our own slots
        addSlotToContainer(new SlotItemHandler(inputHandler, 0, 86, 24));
        addSlotToContainer(new SlotItemHandler(energyHandler, 0, 118, 48));
        addSlotToContainer(new SlotItemHandler(outputHandler, 0, 150, 24));
    }




    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < ClayBendingMachineTileEntity.SIZE) {
                if (!this.mergeItemStack(itemstack1, ClayBendingMachineTileEntity.SIZE, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, ClayBendingMachineTileEntity.SIZE, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return te.canInteractWith(playerIn);
    }

}
