package com.itssub.common.init;

import com.itssub.UnnamedMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = UnnamedMod.MODID)
public class SoundReg {

	public static SoundEvent test_sound = createSoundEvent("test");
	
	@SubscribeEvent
	public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
		
		 SoundEvent[] soundEvents = {
			test_sound
		};

		event.getRegistry().registerAll(soundEvents);
}
	
	public static SoundEvent createSoundEvent(String soundName) {
		final ResourceLocation soundID = new ResourceLocation(UnnamedMod.MODID, soundName);
		return new SoundEvent(soundID).setRegistryName(soundID);
	}
	
}
