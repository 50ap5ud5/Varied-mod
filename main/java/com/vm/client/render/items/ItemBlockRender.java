package com.vm.client.render.items;

import com.vm.Varied_Mod;
import com.vm.common.init.BlockReg;
import com.vm.common.init.ItemsReg;
import com.vm.utils.GenerateJsons;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ItemBlockRender {

	public static void items() 
	{
		for (int i = 0; i < ItemsReg.ITEMS.size(); i++) {
			Item item = ItemsReg.ITEMS.get(i);
			
			if(Varied_Mod.GenerateJsons) 
			{
			GenerateJsons.Item(item.getUnlocalizedName().substring(5), item.getUnlocalizedName().substring(5));
			}
			
			ModelResourceLocation mrl = new ModelResourceLocation(Varied_Mod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory");
			ModelLoader.setCustomModelResourceLocation(item, 0, mrl);
		}
	}
	
	
	public static void blocks()
	{
		for (int i = 0; i < BlockReg.BLOCKS.size(); i++) {
			Block b = BlockReg.BLOCKS.get(i);
			Item item = Item.getItemFromBlock(b);
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Varied_Mod.MODID + ":" + b.getUnlocalizedName().substring(5), "inventory"));
		}
	}
}
