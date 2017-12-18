package com.itssub.common.init;

import java.util.HashSet;
import java.util.Set;

import com.itssub.UnnamedMod;
import com.itssub.common.items.ItemBlank;
import com.itssub.utils.Utils;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = UnnamedMod.MODID)
public class ItemsReg {
	
	public static Item test_item = new ItemBlank("test_item");
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {	
		IForgeRegistry<Item> reg = event.getRegistry();
		reg.registerAll(test_item);
	}
}
