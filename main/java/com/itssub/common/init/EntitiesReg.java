package com.itssub.common.init;

import com.itssub.UnnamedMod;
import com.itssub.common.entities.EntityBee;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

public class EntitiesReg {

	
	private static int entityID = 0;
	
	private static <E extends Entity> EntityEntryBuilder<E> createBuilder(String name) {
		final EntityEntryBuilder<E> builder = EntityEntryBuilder.create();
		final ResourceLocation registryName = new ResourceLocation(UnnamedMod.MODID, name);
		return builder.id(registryName, entityID++).name(registryName.toString());
	}
	
	
	@Mod.EventBusSubscriber(modid = UnnamedMod.MODID)
	public static class AddMobs
	{
		
	@SubscribeEvent
	public static void RegisterEntiites(RegistryEvent.Register<EntityEntry> event) {
		
		EntityEntry[] entries = {
				createBuilder("Bee").entity(EntityBee.class).tracker(80, 3, false).build(),
			};
		
		event.getRegistry().registerAll(entries);
		
		}

	}
}
