package com.vm.common.init;

import java.util.ArrayList;
import java.util.List;

import com.vm.Varied_Mod;
import com.vm.client.render.items.ItemBlockRender;
import com.vm.common.items.ItemBlank;
import com.vm.common.items.ItemPotionBase;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Varied_Mod.MODID)
public class ItemsReg {
	
	public static List<Item> ITEMS = new ArrayList<>();
	
	public static Item test_item;
	public static Item steel_ingot;
	public static Item dead_bee;
	public static Item honey_bottle;
	
	public static void Init() {
	
	test_item = createItem(new ItemBlank(), "test_item", CreativeTabsReg.MAIN_TAB);
	steel_ingot = createItem(new ItemBlank(), "steel_ingot", CreativeTabsReg.MAIN_TAB);
	dead_bee = createItem(new ItemBlank(), "dead_bee", CreativeTabsReg.BEE_TAB);
	honey_bottle = createItem(new ItemPotionBase(PotionReg.Test, 100, 0), "honey_bottle", CreativeTabsReg.BEE_TAB);
	
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {	
		
		PotionReg.init();
		
		Init();
		
		IForgeRegistry<Item> reg = event.getRegistry();
		reg.registerAll(ITEMS.toArray(new Item[ITEMS.size()]));
		
		if(Varied_Mod.side.isClient()) 
		{
			ItemBlockRender.items();
		}
	}

	public static Item createItem(Item item, String name, CreativeTabs tab) 
	{
		item.setRegistryName(Varied_Mod.MODID,name);
		item.setUnlocalizedName(name);
		item.setCreativeTab(tab);
		ITEMS.add(item);
		return item;
	}
	
}
