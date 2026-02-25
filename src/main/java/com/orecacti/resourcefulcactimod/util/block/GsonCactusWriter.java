package com.orecacti.resourcefulcactimod.util.block;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.neoforged.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GsonCactusWriter {
    public static void writeBlocksToFile(List<ModCactusBlockData> cacti){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String filePath = FMLPaths.GAMEDIR.get().toString() +"/config/grodomirsresourcefulcactimod/custom_cacti.json";

        File directory = new File(FMLPaths.GAMEDIR.get().toString() + "/config/grodomirsresourcefulcactimod");
        if(!directory.exists()){
            directory.mkdirs();
        }

        try (FileWriter writer = new FileWriter(filePath)){
            gson.toJson(cacti, writer);
            System.out.println("JSON created: " + filePath);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
