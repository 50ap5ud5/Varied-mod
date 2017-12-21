package com.itssub.render.items;

import com.itssub.UnnamedMod;
import com.itssub.common.init.ItemsReg;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ItemBlockRender {

	public static void items() 
	{
		for (int i = 0; i < ItemsReg.ITEMS.size(); i++) {
			Item item = ItemsReg.ITEMS.get(i);
			ModelResourceLocation mrl = new ModelResourceLocation(UnnamedMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory");
			ModelLoader.setCustomModelResourceLocation(item, 0, mrl);
		}
	}
}
