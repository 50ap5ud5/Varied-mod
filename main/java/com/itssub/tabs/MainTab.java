package com.itssub.tabs;

import com.itssub.common.init.ItemsReg;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MainTab extends CreativeTabs{
	
	public MainTab(String label) {
		super("maintab");
		this.setBackgroundImageName("main.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemsReg.steel_ingot);
		//If block wanted use: Item.getItemFromBlock()
	}

}
