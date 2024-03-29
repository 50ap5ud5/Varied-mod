package com.vm.common.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import com.vm.Varied_Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Varied_Mod.MODID)
public class SoundReg {

	public static SoundEvent test_sound = createSoundEvent("test");
	public static SoundEvent bee_buzz = createSoundEvent("bee_buzz");
	
	@SubscribeEvent
	public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
		
		 SoundEvent[] soundEvents = {
			test_sound,
			bee_buzz
		};

		event.getRegistry().registerAll(soundEvents);
}
	
	public static SoundEvent createSoundEvent(String soundName) {
		final ResourceLocation soundID = new ResourceLocation(Varied_Mod.MODID, soundName);
		return new SoundEvent(soundID).setRegistryName(soundID);
	}
	
}
