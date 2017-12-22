package com.itssub.common.init;

import java.util.ArrayList;
import java.util.List;

import com.itssub.VariedMod;
import com.itssub.common.items.ItemBlank;
import com.itssub.render.items.ItemBlockRender;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = VariedMod.MODID)
public class ItemsReg {
	
	public static List<Item> ITEMS = new ArrayList<>();
	
	public static Item test_item = createItem(new ItemBlank(), "test_item", CreativeTabsReg.MAIN_TAB);
	public static Item steel_ingot = createItem(new ItemBlank(), "steel_ingot", CreativeTabsReg.MAIN_TAB);
	public static Item dead_bee = createItem(new ItemBlank(), "dead_bee", CreativeTabsReg.MAIN_TAB);
	
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {	
		IForgeRegistry<Item> reg = event.getRegistry();
		reg.registerAll(ITEMS.toArray(new Item[ITEMS.size()]));
		
		if(VariedMod.side.isClient()) 
		{
			ItemBlockRender.items();
		}
	}
	
	public static Item createItem(Item item, String name, CreativeTabs tab) 
	{
		item.setRegistryName(VariedMod.MODID,name);
		item.setUnlocalizedName(name);
		item.setCreativeTab(tab);
		ITEMS.add(item);
		return item;
	}
	
}
