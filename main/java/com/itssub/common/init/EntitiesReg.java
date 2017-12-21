package com.itssub.common.init;

import com.itssub.UnnamedMod;
import com.itssub.common.entities.EntityBee;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;


@Mod.EventBusSubscriber(modid = UnnamedMod.MODID)
public class EntitiesReg {
	
	@SubscribeEvent
	public static void RegisterEntiites(RegistryEvent.Register<EntityEntry> event) {
		
		EntityEntry[] entries = {
				createBuilder("Bee").entity(EntityBee.class).egg(0xffc100, 0x322600).tracker(80, 3, false).build(),
			};
		
		event.getRegistry().registerAll(entries);	
	}
	
	private static int entityID = 0;
	
	private static <E extends Entity> EntityEntryBuilder<E> createBuilder(String name) {
		final EntityEntryBuilder<E> builder = EntityEntryBuilder.create();
		final ResourceLocation registryName = new ResourceLocation(UnnamedMod.MODID, name);
		return builder.id(registryName, entityID++).name(registryName.toString());
	}	
}
