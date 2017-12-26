package com.vm.common.init;

import com.google.common.base.Preconditions;
import com.vm.Varied_Mod;
import com.vm.client.render.items.ItemBlockRender;
import com.vm.common.TileEntities.TileEntityTest;
import com.vm.common.blocks.BasicBlock;
import com.vm.common.blocks.TileEntityBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Mod.EventBusSubscriber(modid = Varied_Mod.MODID)
public class BlockReg {

		public static final List<Block> BLOCKS = new ArrayList<>();

		public static void init() {
			System.out.println("blocks test");
		Block tile_test = createBlock(new TileEntityBlock(Material.CLAY, new TileEntityTest()), "tile_test", CreativeTabsReg.MAIN_TAB);
		Block block_test = createBlock(new BasicBlock(Material.CLAY), "test", null);
		
		registerTileEntities();
		
		if(Varied_Mod.side.isClient()) 
		{
			ItemBlockRender.blocks();
		}
		
	}
			
	public static Block createBlock(Block block, String name, CreativeTabs tab) 
		{
			block.setRegistryName(Varied_Mod.MODID,name);
			block.setUnlocalizedName(name);
			block.setCreativeTab(tab);
			ForgeRegistries.BLOCKS.register(block);
			return block;
		}
		

	private static void registerTileEntities() {
		registerTileEntity(TileEntityTest.class, "tile_entity_test");
	}

	private static void registerTileEntity(final Class<? extends TileEntity> tileEntityClass, final String name) {
		GameRegistry.registerTileEntity(tileEntityClass, Varied_Mod.MODID + name);
	}
}
