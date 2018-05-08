package com.nachie.ClayForBalance;

import org.apache.logging.log4j.Level;

import com.nachie.ClayForBalance.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;

public class Config {
	private static final String CATEGORY_GENERAL = "general";
	private static final String CATEGORY_DIMENSIONS = "dimensions";
	
	//Default configs
	//Determines how many hits it takes to form clay
	public static int clayHardness = 5;
	
	
	//Reads config file
	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
            cfg.load();
            initGeneralConfig(cfg);
            initDimensionConfig(cfg);
        } catch (Exception e1) {
            ClayForBalance.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
	}
	
	private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        
        clayHardness = cfg.getInt("goodTutorial", CATEGORY_GENERAL, clayHardness, clayHardness, clayHardness, "How many hits to form clay");
        
    }

    private static void initDimensionConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");

    }
}
