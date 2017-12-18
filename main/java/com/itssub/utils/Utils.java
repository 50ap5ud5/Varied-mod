package com.itssub.utils;

import com.itssub.UnnamedMod;
import com.itssub.common.init.ItemsReg;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;

public class Utils {
	
	public static class ReusedBs {
		public static Minecraft mc = Minecraft.getMinecraft();
		public static RenderManager render_manager = Minecraft.getMinecraft().getRenderManager();
	}
	
	
}
