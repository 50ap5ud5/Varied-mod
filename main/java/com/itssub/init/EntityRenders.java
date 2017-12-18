package com.itssub.init;

import com.itssub.common.entities.EntityBee;
import com.itssub.models.ModelBee;
import com.itssub.render.RenderBee;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRenders {

	public static void init() {
	RenderingRegistry.registerEntityRenderingHandler(EntityBee.class, new RenderBee(Minecraft.getMinecraft().getRenderManager(), new ModelBee(), 0.5F));
	}
}
