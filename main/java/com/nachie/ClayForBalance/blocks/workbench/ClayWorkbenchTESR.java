package com.nachie.ClayForBalance.blocks.workbench;

import com.nachie.ClayForBalance.blocks.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClayWorkbenchTESR extends TileEntitySpecialRenderer<ClayWorkbenchTE> {

    @Override
    public void render(ClayWorkbenchTE te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();

        // Translate to the location of our tile entity
        GlStateManager.translate(x, y, z);
        GlStateManager.disableRescaleNormal();

        // Render the rotating handles
        //renderHandles(te);

        // Render our item
        renderItem(te);

        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    private void renderItem(ClayWorkbenchTE te) {
        ItemStack stack = te.getStack();
        if (!stack.isEmpty()){
	        if (!(stack.getItem() instanceof ItemBlock)) {
	            RenderHelper.enableStandardItemLighting();
	            GlStateManager.enableLighting();
	            GlStateManager.pushMatrix();
	            // Translate to the center of the block and .9 points higher
	            GlStateManager.translate(.5, .968, .5);
	            GlStateManager.scale(.7f, .7f, .7f);
	            GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
	
	            Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);
	
	            GlStateManager.popMatrix();
	        } else {
	        	RenderHelper.enableStandardItemLighting();
	            GlStateManager.enableLighting();
	            GlStateManager.pushMatrix();
	            // Translate to the center of the block and .9 points higher
	            GlStateManager.translate(.5, 1.188, .5);
	            GlStateManager.scale(.5f, .5f, .5f);
	
	            Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);
	
	            GlStateManager.popMatrix();
	        }
        }
    }

}