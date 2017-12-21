package com.itssub.render.entities;

import com.itssub.UnnamedMod;
import com.itssub.common.entities.EntityBee;
import com.itssub.utils.Utils;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;

public class RenderBee extends RenderLiving<EntityBee>
{
	public RenderBee(ModelBase modelbaseIn) 
	{
		super(Utils.Client.render_manager, modelbaseIn, 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBee entity) 
	{
		return new ResourceLocation(UnnamedMod.MODID, "textures/entities/bee.png");
	}
	
}
