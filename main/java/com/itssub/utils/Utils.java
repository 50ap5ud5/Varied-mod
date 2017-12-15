package com.itssub.utils;

import com.itssub.UnnamedMod;
import com.itssub.common.init.ItemsReg;

import net.minecraft.item.Item;

public class Utils {
	
	
	public static Item regItem(Item item, String name)
	{
		item.setRegistryName(UnnamedMod.MODID, name);
		item.setUnlocalizedName(UnnamedMod.MODID + ":" + name);
		return item;
	}
	
	
}
