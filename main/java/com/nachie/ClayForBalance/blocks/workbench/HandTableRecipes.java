package com.nachie.ClayForBalance.blocks.workbench;

import java.util.List;

import com.google.common.collect.Lists;
import com.nachie.ClayForBalance.items.ModItems;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;

public class HandTableRecipes {
	
	public static HandTableOutcome IterateHandTableRecipes(ItemStack tableIngredient, ItemStack itemUsed) {
		List<HandTableRecipe> Recipes = Lists.newArrayList( //Insert recipes here!
			    new HandTableRecipe(new ItemStack(Item.getItemFromBlock(Blocks.CLAY)),new ItemStack(ModItems.SLICER),new ItemStack(Items.CLAY_BALL, 4),ItemStack.EMPTY)
			); {	
				
				for(HandTableRecipe recipe : Recipes) {
					HandTableOutcome whatComesOut = recipe.CompareRecipes(tableIngredient, itemUsed);
					
					if (whatComesOut.getPrimaryOutput() != ItemStack.EMPTY || whatComesOut.getSecondaryOutput() != ItemStack.EMPTY) { //Return results if not empty
						return whatComesOut;
					}
				}
				return new HandTableOutcome(ItemStack.EMPTY, ItemStack.EMPTY);
					
			}
	}
}
