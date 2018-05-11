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
			    new HandTableRecipe(new ItemStack(Item.getItemFromBlock(Blocks.CLAY)),new ItemStack(ModItems.SLICER),new ItemStack(Items.CLAY_BALL, 4),ItemStack.EMPTY),
			    new HandTableRecipe(new ItemStack(Items.CLAY_BALL),ItemStack.EMPTY,new ItemStack(ModItems.CLAYSTICK),ItemStack.EMPTY),
			    new HandTableRecipe(new ItemStack(ModItems.CLAYCYLINDER),ItemStack.EMPTY,new ItemStack(ModItems.CLAYNEEDLE),ItemStack.EMPTY),
			    new HandTableRecipe(new ItemStack(ModItems.LARGECLAYBALL),ItemStack.EMPTY,new ItemStack(ModItems.CLAYCYLINDER),ItemStack.EMPTY),
			    new HandTableRecipe(new ItemStack(ModItems.CLAYPLATE, 6),new ItemStack(ModItems.ROLLING_PIN),new ItemStack(ModItems.LARGECLAYPLATE),ItemStack.EMPTY),
			    new HandTableRecipe(new ItemStack(ModItems.CLAYPLATE),ItemStack.EMPTY,new ItemStack(ModItems.CLAYBLADE),new ItemStack(Items.CLAY_BALL, 2)),
			    new HandTableRecipe(new ItemStack(ModItems.LARGECLAYBALL),new ItemStack(ModItems.ROLLING_PIN),new ItemStack(ModItems.CLAYDISC),new ItemStack(Items.CLAY_BALL, 2)),
			    new HandTableRecipe(new ItemStack(ModItems.CLAYDISC),new ItemStack(ModItems.SLICER),new ItemStack(ModItems.CLAYPLATE),new ItemStack(Items.CLAY_BALL, 2)),
			    new HandTableRecipe(new ItemStack(ModItems.CLAYDISC),new ItemStack(ModItems.KNIFE),new ItemStack(ModItems.CLAYRING),new ItemStack(ModItems.SMALLCLAYDISC)),
			    new HandTableRecipe(new ItemStack(ModItems.SMALLCLAYDISC),new ItemStack(ModItems.KNIFE),new ItemStack(ModItems.CLAYPLATE),new ItemStack(ModItems.SHORTCLAYSTICK)),
			    new HandTableRecipe(new ItemStack(ModItems.CLAYPLATE),new ItemStack(ModItems.KNIFE),new ItemStack(ModItems.CLAYSTICK,4),ItemStack.EMPTY),
			    new HandTableRecipe(new ItemStack(ModItems.CLAYCYLINDER),new ItemStack(ModItems.KNIFE),new ItemStack(ModItems.SMALLCLAYDISC, 8),ItemStack.EMPTY)
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
