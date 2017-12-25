package com.vm.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;

public class Utils {
	
	public static class Client {
		public static Minecraft mc = Minecraft.getMinecraft();
		public static RenderManager render_manager = Minecraft.getMinecraft().getRenderManager();
	}
	
	
	
}
