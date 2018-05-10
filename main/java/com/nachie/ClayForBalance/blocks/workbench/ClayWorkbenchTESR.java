package com.nachie.ClayForBalance.blocks.workbench;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;

import com.nachie.ClayForBalance.library.client.RenderUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClayWorkbenchTESR<T extends ClayWorkbenchTE> extends TileEntitySpecialRenderer<T> {

	protected final float yMin;
	protected final float yMax;
	protected final float xzMin;
	protected final float xzMax;

    protected float yScale;
	protected float xzScale;
	protected float yOffset;
	protected float xzOffset;
	
	public ClayWorkbenchTESR(float yMin, float yMax, float xzMin, float xzMax) {
	    float s = 0.9995f;
	    this.yMin = yMin * s;
	    this.yMax = yMax * s;
	    this.xzMin = xzMin * s;
	    this.xzMax = xzMax * s;

	    this.yOffset = yMin + (yMax - yMin) / 2f;
	    this.xzOffset = xzMin + (xzMax - xzMin) / 2f;

	    this.xzScale = (this.xzMax - this.xzMin);
	    this.yScale = xzScale;
	}
	
    @Override
    public void render(ClayWorkbenchTE te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
    	ItemStack stack = te.getStack();
    	if(te.getStack().isEmpty()) {
          RenderUtil.pre(x, y, z);
          int brightness = te.getWorld().getCombinedLight(te.getPos(), 0);
          OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightness % 0x10000 / 1f,
                                                brightness / 0x10000 / 1f);

          GlStateManager.translate(xzOffset, yOffset, xzOffset);
          GlStateManager.scale(xzScale, yScale, xzScale);

          GlStateManager.blendFunc(GL11.GL_CONSTANT_ALPHA, GL11.GL_ONE_MINUS_CONSTANT_ALPHA);

          GL11.glDepthMask(false);
          IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(stack, te.getWorld(), null);
          Minecraft.getMinecraft().getRenderItem().renderItem(stack, model);
          GL11.glDepthMask(true);
          GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    RenderUtil.post();
    }
    
    
    }
}