package com.nachie.ClayForBalance.proxy;

import java.io.File;

import com.nachie.ClayForBalance.Config;
import com.nachie.ClayForBalance.items.*;
import com.nachie.ClayForBalance.blocks.ModBlocks;
import com.nachie.ClayForBalance.blocks.workbench.*;
import com.nachie.ClayForBalance.blocks.*;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	public static Configuration config;
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}

    public void preInit(FMLPreInitializationEvent e) {
    	File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "clayforbalance.cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    	if (config.hasChanged()) {
            config.save();
    	}
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	event.getRegistry().register(new ClayWorktable());
    	GameRegistry.registerTileEntity(ClayWorkbenchTE.class, "clayforbalance_clayworkbench");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	
    	event.getRegistry().register(new ItemBlock(ModBlocks.CLAYWORKTABLE).setRegistryName(ModBlocks.CLAYWORKTABLE.getRegistryName()));
        //register tools
    	event.getRegistry().register(new ItemKnife());
        event.getRegistry().register(new ItemRollingPin());
        event.getRegistry().register(new ItemSlicer());
        
        //register tier 1
        event.getRegistry().register(new ItemClayBearing());
        event.getRegistry().register(new ItemClayBlade());
        event.getRegistry().register(new ItemClayCuttingHead());
        event.getRegistry().register(new ItemClayCylinder());
        event.getRegistry().register(new ItemClayDisc());
        event.getRegistry().register(new ItemClayGear());
        event.getRegistry().register(new ItemClayGrindingHead());
        event.getRegistry().register(new ItemClayPipe());
        event.getRegistry().register(new ItemClayPlate());
        event.getRegistry().register(new ItemClayRing());
        event.getRegistry().register(new ItemClaySpindle());
        event.getRegistry().register(new ItemClayStick());
        event.getRegistry().register(new ItemClayWheel());
        event.getRegistry().register(new ItemLargeClayBall());
        event.getRegistry().register(new ItemLargeClayPlate());
        event.getRegistry().register(new ItemShortClayStick());
        event.getRegistry().register(new ItemSmallClayDisc());
        event.getRegistry().register(new ItemSmallClayRing());
        
    }
    
}
