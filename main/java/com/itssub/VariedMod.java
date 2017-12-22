package com.itssub;

import com.itssub.proxy.CommonProxy;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = VariedMod.MODID, version = VariedMod.VERSION)
public class VariedMod
{
    public static final String MODID = "varied_mod";
    public static final String NAME = "Varied Mod";
    public static final String VERSION = "1.0";

    @Instance
	public static VariedMod instance;   
   
    public static  Side side =  FMLCommonHandler.instance().getSide();
    
    @SidedProxy(clientSide = "com.itssub.proxy.ClientProxy", serverSide = "com.itssub.proxy.CommonProxy")

	
    public static CommonProxy TheProxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
       TheProxy.init(event);
    }
}
