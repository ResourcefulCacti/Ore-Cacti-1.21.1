package com.orecacti.resourcefulcactimod.util.item;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.neoforged.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonSpikeReader {

    public static List<ModSpikeItemData>readItemsFromFile(){
        Gson gson = new Gson();
        String filePath = FMLPaths.GAMEDIR.get().toString() + "/config/grodomirsresourcefulcactimod/custom_spikes.json";

        File file = new File(filePath);
        if (!file.exists()){
            System.err.println("File '" + filePath + "' not found.");

            List<ModSpikeItemData> cacti = new ArrayList<>();

            cacti.add(new ModSpikeItemData("Dirt Spike", "dirt_cactus_spike", "minecraft:dirt"));
            cacti.add(new ModSpikeItemData("Dirt Spike", "cobble_cactus_spike", "minecraft:cobblestone"));

            GsonSpikeWriter.writeItemsToFile(cacti);
            return cacti;
        }

        try(FileReader reader = new FileReader(filePath)){
            Type listType = new TypeToken<List<ModSpikeItemData>>(){}.getType();
            List<ModSpikeItemData> result = gson.fromJson(reader, listType);

            return result != null ? result : new ArrayList<>();
        } catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
