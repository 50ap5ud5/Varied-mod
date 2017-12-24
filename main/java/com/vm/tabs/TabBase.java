package com.vm.tabs;

import com.vm.common.init.ItemsReg;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabBase extends CreativeTabs{
	
	private static ItemStack stack = new ItemStack(ItemsReg.test_item);
	
	public TabBase(String label, Item item) {
		super(label);
		stack = new ItemStack(item);
		this.setBackgroundImageName("main.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return stack;
		//If block wanted use: Item.getItemFromBlock()
	}

}
