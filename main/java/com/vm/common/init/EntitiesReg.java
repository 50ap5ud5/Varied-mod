package com.vm.common.init;

import com.vm.Varied_Mod;
import com.vm.common.entities.EntityBee;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;


@Mod.EventBusSubscriber(modid = Varied_Mod.MODID)
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
        final ResourceLocation registryName = new ResourceLocation(Varied_Mod.MODID, name);
        return builder.id(registryName, entityID++).name(registryName.toString().replaceAll(Varied_Mod.MODID + ":", ""));
    }
}
