package com.nachie.ClayForBalance.proxy;

import com.nachie.ClayForBalance.ClayForBalance;
import com.nachie.ClayForBalance.common.blocks.ModBlocks;
import com.nachie.ClayForBalance.common.items.ModItems;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.SidedProxy;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
	
    @Override
    public void preInit(FMLPreInitializationEvent e) {
         super.preInit(e);
         OBJLoader.INSTANCE.addDomain(ClayForBalance.MODID);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    	ModItems.initClient();
    	ModBlocks.initClient();
    }
    
    
}
