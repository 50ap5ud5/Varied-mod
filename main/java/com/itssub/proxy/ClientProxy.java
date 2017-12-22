package com.itssub.proxy;

import com.itssub.VariedMod;
import com.itssub.common.entities.EntityBee;
import com.itssub.models.ModelBee;
import com.itssub.render.entities.RenderBee;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy
{
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		if(VariedMod.side.isClient()) {
			
			RenderingRegistry.registerEntityRenderingHandler(EntityBee.class, new RenderBee(new ModelBee()));
		
		}
	}
}
