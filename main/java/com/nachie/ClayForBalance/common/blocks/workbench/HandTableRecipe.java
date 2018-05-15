package com.nachie.ClayForBalance.common.blocks.workbench;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class HandTableRecipe {
	private final ItemStack tableIngredient;
	private final ItemStack itemUsed;
	private final ItemStack primaryOutput;
	private final ItemStack secondaryOutput;
	
	public HandTableRecipe(final ItemStack itemStack, final ItemStack itemStack2, final ItemStack primaryOutput, final ItemStack secondaryOutput) {
		this.tableIngredient = itemStack;
		this.itemUsed = itemStack2;
		this.primaryOutput = primaryOutput;
		this.secondaryOutput = secondaryOutput;
	}
	
	public HandTableOutcome CompareRecipes(ItemStack tableIngredient, ItemStack itemUsed) {
		
		if (this.tableIngredient.getItem() == tableIngredient.getItem() && this.itemUsed.getItem() == itemUsed.getItem()) {			
			return new HandTableOutcome(this.primaryOutput, this.secondaryOutput);
		} else {
			return new HandTableOutcome(ItemStack.EMPTY, ItemStack.EMPTY);
		}
		
	}
	
}
