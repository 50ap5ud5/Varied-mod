package com.itssub.common.items;

import com.itssub.UnnamedMod;

import net.minecraft.item.Item;

public class ItemBlank extends Item {

	public ItemBlank(String reg_name) {
		this.setUnlocalizedName(reg_name);
		this.setRegistryName(UnnamedMod.MODID,reg_name);
		setCreativeTab(UnnamedMod.maintab);
	}
}
