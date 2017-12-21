package com.itssub;

import com.itssub.proxy.CommonProxy;
import com.itssub.tabs.MainTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = UnnamedMod.MODID, version = UnnamedMod.VERSION)
public class UnnamedMod
{
    public static final String MODID = "unnamed_mod";
    public static final String NAME = "Unnamed Mod";
    public static final String VERSION = "1.0";

    public static final CreativeTabs maintab = new MainTab("maintab");
    
    @Instance
	public static UnnamedMod instance;   
    
    @SidedProxy(clientSide = "com.itssub.proxy.ClientProxy", serverSide = "com.itssub.proxy.CommonProxy")

	
    public static CommonProxy TheProxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
       TheProxy.init(event);
    }
}
