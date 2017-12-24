package com.vm.proxy;

import com.vm.Varied_Mod;
import com.vm.common.entities.EntityBee;
import com.vm.models.ModelBee;
import com.vm.render.entities.RenderBee;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy
{
	
	public void init() {
			RenderingRegistry.registerEntityRenderingHandler(EntityBee.class, new RenderBee(new ModelBee()));
		}
}
