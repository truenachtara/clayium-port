package com.nachie.ClayForBalance.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@ObjectHolder("clayforbalance")
public class ModItems {
	//tools
	public static final ItemKnife KNIFE = null;
	public static final ItemRollingPin ROLLING_PIN = null;
	public static final ItemSlicer SLICER = null;
	
	//tier 1 items
	public static final ItemClayBearing CLAYBEARING = null;
	public static final ItemClayBlade CLAYBLADE = null;
	public static final ItemClayCuttingHead CLAYCUTTINGHEAD = null;
	public static final ItemClayCylinder CLAYCYLINDER = null;
	public static final ItemClayDisc CLAYDISC = null;
	public static final ItemClayGear CLAYGEAR = null;
	public static final ItemClayGrindingHead CLAYGRINDINGHEAD = null;
	public static final ItemClayNeedle CLAYNEEDLE = null;
	public static final ItemClayPipe CLAYPIPE = null;
	public static final ItemClayPlate CLAYPLATE = null;
	public static final ItemClayRing CLAYRING = null;
	public static final ItemClaySpindle CLAYSPINDLE = null;
	public static final ItemClayStick CLAYSTICK = null;
	public static final ItemClayWheel CLAYWHEEL = null;
	public static final ItemLargeClayBall LARGECLAYBALL = null;
	public static final ItemLargeClayPlate LARGECLAYPLATE = null;
	public static final ItemShortClayStick SHORTCLAYSTICK = null;
	public static final ItemSmallClayDisc SMALLCLAYDISC = null;
	public static final ItemSmallClayRing SMALLCLAYRING = null;

	@SideOnly(Side.CLIENT)
	public static void initClient() {
		//tools
		KNIFE.initModel();
		ROLLING_PIN.initModel();
		SLICER.initModel();
		
		//tier 1 items
		CLAYBEARING.initModel();
		CLAYBLADE.initModel();
		CLAYCUTTINGHEAD.initModel();
		CLAYCYLINDER.initModel();
		CLAYDISC.initModel();
		CLAYGEAR.initModel();
		CLAYGRINDINGHEAD.initModel();
		CLAYPIPE.initModel();
		CLAYPLATE.initModel();
		CLAYRING.initModel();
		CLAYSPINDLE.initModel();
		CLAYSTICK.initModel();
		CLAYWHEEL.initModel();
		LARGECLAYBALL.initModel();
		LARGECLAYPLATE.initModel();
		SHORTCLAYSTICK.initModel();
		SMALLCLAYDISC.initModel();
		SMALLCLAYRING.initModel();
	}
}
