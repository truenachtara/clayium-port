package com.nachie.ClayForBalance;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import com.nachie.ClayForBalance.proxy.CommonProxy;

@Mod(modid = ClayForBalance.MODID, name = ClayForBalance.NAME, version = ClayForBalance.VERSION)
public class ClayForBalance
{
    public static final String MODID = "clayforbalance";
    public static final String NAME = "Clay Stuff Mod";
    public static final String VERSION = "0.0";

    @SidedProxy(clientSide = "com.nachie.ClayForBalance.proxy.ClientProxy", serverSide = "com.nachie.ClayForBalance.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static ClayForBalance instance;
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
    }
}
