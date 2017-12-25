package com.vm.client.render.entities;

import com.vm.Varied_Mod;
import com.vm.common.entities.EntityBee;
import com.vm.utils.Utils;

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
		return new ResourceLocation(Varied_Mod.MODID, "textures/entities/bee.png");
	}
	
}
