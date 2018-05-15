package com.nachie.ClayForBalance.common.blocks.machines.bending;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ClayBendingMachineTileEntity extends TileEntity {

	public static final int SIZE = 3;

	private static int timeLeft = 0;
	private static int energyLeft = 0;

	 // This item handler will hold our nine inventory slots
	    private ItemStackHandler inputStackHandler = new ItemStackHandler(1) {
	        @Override
	        protected void onContentsChanged(int slot) {
	            // We need to tell the tile entity that something has changed so
	            // that the chest contents is persisted
	            ClayBendingMachineTileEntity.this.markDirty();
	        }
	    };

		private ItemStackHandler energyStackHandler = new ItemStackHandler(1) {
			@Override
			protected void onContentsChanged(int slot) {
				// We need to tell the tile entity that something has changed so
				// that the chest contents is persisted
				ClayBendingMachineTileEntity.this.markDirty();
			}
		};
		private ItemStackHandler outputStackHandler = new ItemStackHandler(1) {
			@Override
			protected void onContentsChanged(int slot) {
				// We need to tell the tile entity that something has changed so
				// that the chest contents is persisted
				ClayBendingMachineTileEntity.this.markDirty();
			}
		};

	    @Override
	    public void readFromNBT(NBTTagCompound compound) {
	        super.readFromNBT(compound);
	        if (compound.hasKey("input")) {
	            inputStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("input"));
	        }
			if (compound.hasKey("energyItem")) {
				inputStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("energy"));
			}
			if (compound.hasKey("output")) {
				inputStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("output"));
			}
	    }

	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
	        super.writeToNBT(compound);
	        compound.setTag("input", inputStackHandler.serializeNBT());
			compound.setTag("energyItem", energyStackHandler.serializeNBT());
			compound.setTag("output", outputStackHandler.serializeNBT());
	        return compound;
	    }

	    public boolean canInteractWith(EntityPlayer playerIn) {
	        // If we are too far away from this tile entity you cannot use it
	        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
	    }


	    @Override
	    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

	        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
	            return true;
	        }
	        return super.hasCapability(capability, facing);
	    }

	    @Override
	    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
	        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
	        	if (facing == EnumFacing.UP) {
					return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(inputStackHandler);
				}
				else if (facing == EnumFacing.DOWN) {
					return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(outputStackHandler);
				}
				else
					return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(energyStackHandler);
	        }
	        return super.getCapability(capability, facing);
	    }

	    /*
		@Override
		public void update() {
			boolean flag = false;

				if (!this.world.isRemote){

				}

				if (flag = true){
					this.markDirty();
				}
		}
		*/
}

