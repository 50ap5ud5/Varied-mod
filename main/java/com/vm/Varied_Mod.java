package com.vm;

import com.vm.proxy.CommonProxy;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Varied_Mod.MODID, version = Varied_Mod.VERSION)
public class Varied_Mod
{
    public static final String MODID = "vm";
    public static final String NAME = "Varied Mod";
    public static final String VERSION = "1.0";

    @Instance
	public static Varied_Mod instance;   
   
    public static  Side side =  FMLCommonHandler.instance().getSide();
    
    @SidedProxy(clientSide = "com.vm.proxy.ClientProxy", serverSide = "com.vm.proxy.CommonProxy")

	
    public static CommonProxy TheProxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
       TheProxy.init(event);
    }
}
