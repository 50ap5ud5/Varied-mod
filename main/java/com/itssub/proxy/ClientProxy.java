package com.itssub.proxy;

import com.itssub.common.init.EntitiesReg;
import com.itssub.init.EntityRenders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy
{
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		if(FMLCommonHandler.instance().getSide().isClient())
		{
		EntityRenders.init();
		super.init(event);
		}
	}
}
