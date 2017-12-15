package com.itssub.common.init;

import java.util.HashSet;
import java.util.Set;

import com.itssub.UnnamedMod;
import com.itssub.common.items.ItemBlank;
import com.itssub.utils.Utils;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(UnnamedMod.MODID)
public class ItemsReg {
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {	
		
		Item test = Utils.regItem(new ItemBlank(), "debug_item");
		
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(test);
	}
}
