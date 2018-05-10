package com.nachie.ClayForBalance.blocks.workbench;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HandTableOutcome {
	private final ItemStack primaryOutput;
	private final ItemStack secondaryOutput;
	
	public HandTableOutcome(final ItemStack primaryOutput, final ItemStack secondaryOutput) {
		this.primaryOutput = primaryOutput;
		this.secondaryOutput = secondaryOutput;
	}

	public ItemStack getPrimaryOutput() {
		return primaryOutput;
	}
	
	public ItemStack getSecondaryOutput() {
		return secondaryOutput;
	}
	
}
