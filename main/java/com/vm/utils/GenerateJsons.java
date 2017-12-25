package com.vm.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import com.vm.Varied_Mod;

import net.minecraft.client.Minecraft;

public class GenerateJsons {

	private static String mod_path = Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "/mods/vm/Json Files";
	

	//Saves a heap of time, you'll find the generated jsons at
	//MCDIR/mods/vm/Json Files
	//You're welcome - Sub
	
	//Generates basic item jsons
	public static void Item(String itemName, String textureName){
	        File fileDir = new File(mod_path + "\\models\\item\\");
	        if(!fileDir.exists()){
	            fileDir.mkdirs();
	        }

	        try {

	            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + itemName + ".json"), "UTF-8");
	            Gson gson = new GsonBuilder().setPrettyPrinting().create();
	            JsonWriter jw = gson.newJsonWriter(writer);

	            jw.beginObject();
	            jw.name("parent").value("item/generated");
	            jw.name("textures");
	            jw.beginObject();
	            jw.name("layer0").value(Varied_Mod.MODID + ":items/" + textureName);
	            jw.endObject();
	            jw.endObject();

	            writer.close();

	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	public static void SkinPacks(String itemName, String textureName){
        File fileDir = new File(mod_path + "\\models\\item\\");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + itemName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("parent").value("item/generated");
            jw.name("textures");
            jw.beginObject();
            jw.name("layer0").value(Varied_Mod.MODID + ":items/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	
	
}
