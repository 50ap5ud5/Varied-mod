package com.vm.common.init;

import java.util.ArrayList;
import java.util.List;

import com.vm.Varied_Mod;
import com.vm.client.render.items.ItemBlockRender;
import com.vm.common.potion.VMPotion;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Varied_Mod.MODID)
public class PotionReg {

	public static List<Potion> POTIONS = new ArrayList<>();
	
	public static Potion Test;

	public static void init() {
		Test = buildPotion(new VMPotion(false, 0), "test");
	}
	

	private static Potion buildPotion(Potion p, String name) {
		p.setRegistryName(Varied_Mod.MODID + ":" + name);
		p.setPotionName(name);
		ForgeRegistries.POTIONS.register(p);
		return p;
	}
	
}
