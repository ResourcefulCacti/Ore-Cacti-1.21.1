package com.orecacti.resourcefulcactimod.util.block;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.neoforged.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonCactusReader {

    public static List<ModCactusBlockData> readBlocksFromFile(){
        Gson gson = new Gson();
        String filePath = FMLPaths.GAMEDIR.get().toString() + "/config/grodomirsresourcefulcactimod/custom_cacti.json";

        File file = new File(filePath);
        if (!file.exists()){
            System.err.println("File '" + filePath + "' not found.");

            List<ModCactusBlockData> cacti = new ArrayList<>();

            //cacti.add(new ModCactusBlockData("Test cactus", "test_cactus", 1, true, false, 0F, false, 0));
            //cacti.add(new ModCactusBlockData("Test ess cactus", "test_ess_cactus", 1, false, true, 0.1F, false, 0));
            //cacti.add(new ModCactusBlockData("Test glow cactus", "test_glow_cactus", 1, true, false, 0F, true, 4));
            cacti.add(new ModCactusBlockData("Test glow cactus", "kurwiszon_cactus", 2, false, true, 0.9F, true, 16));
            cacti.add(new ModCactusBlockData("Test glow cactus", "chujiszon_cactus", 1, false, true, 0.9F, true, 16));

            GsonCactusWriter.writeBlocksToFile(cacti);
            return cacti;
        }

        try(FileReader reader = new FileReader(filePath)){
            Type listType = new TypeToken<List<ModCactusBlockData>>(){}.getType();
            //return gson.fromJson(reader, listType);
            List<ModCactusBlockData> result = gson.fromJson(reader, listType);

            return result != null ? result : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
