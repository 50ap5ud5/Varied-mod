package com.itssub.render;

import com.itssub.UnnamedMod;
import com.itssub.common.entities.EntityBee;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBee extends RenderLiving<EntityBee>
{

	private static final ResourceLocation BeeTexture = new ResourceLocation(UnnamedMod.MODID, "textures/entities/bee.png");
	

	public RenderBee(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) 
	{
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBee entity) 
	{
		return BeeTexture;
	}
	
}
