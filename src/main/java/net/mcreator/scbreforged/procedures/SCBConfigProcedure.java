package net.mcreator.scbreforged.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SCBConfigProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		com.google.gson.JsonObject main_json_object = new com.google.gson.JsonObject();
		File SCB = new File("");
		SCB = new File((FMLPaths.GAMEDIR.get().toString() + "/config/"), File.separator + "SpiritualComeBack_config.json");
		if (SCB.exists() == false) {
			try {
				SCB.getParentFile().mkdirs();
				SCB.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			main_json_object.addProperty("Panicked_Spirit Duration_(seconds)", 120);
			main_json_object.addProperty("Panicked_Spirit_Speed", true);
			main_json_object.addProperty("Panicked_Spirit_Speed_level", 2);
			main_json_object.addProperty("Panicked_Spirit_Slow_falling", true);
			main_json_object.addProperty("Panicked_Spirit_Slow_falling_level", 1);
			main_json_object.addProperty("Panicked_Spirit_Fire_resistance", true);
			main_json_object.addProperty("Panicked_Spirit_Fire_resistance_level", 1);
			main_json_object.addProperty("Spooky_Advantage_Duration_(seconds)", 15);
			main_json_object.addProperty("Spooky_Advantage_chance_(%)", 50);
			main_json_object.addProperty("Mysterious_force_chance_(%)", 5);
			main_json_object.addProperty("Spiritual_Defense_Effect", true);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(SCB);
					fileWriter.write(mainGSONBuilderVariable.toJson(main_json_object));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
