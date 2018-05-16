package com.nachie.ClayForBalance.common.blocks.machines.bending;

import com.nachie.ClayForBalance.ClayForBalance;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class ClayBendingMachineGui extends GuiContainer {
	public static final int WIDTH = 252;
    public static final int HEIGHT = 200;

    private static final ResourceLocation background = new ResourceLocation(ClayForBalance.MODID, "textures/gui/testcontainer.png");

    public ClayBendingMachineGui(ClayBendingMachineTileEntity tileEntity, ClayBendingMachineContainer container) {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
