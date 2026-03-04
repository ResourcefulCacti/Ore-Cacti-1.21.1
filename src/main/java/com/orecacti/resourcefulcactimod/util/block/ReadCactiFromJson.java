package com.orecacti.resourcefulcactimod.util.block;

import java.util.LinkedHashMap;
import java.util.List;

public class ReadCactiFromJson {

    public static final LinkedHashMap<String, Integer> TIER = new LinkedHashMap<>();
    public static final LinkedHashMap<String, Integer> CACTI_FROM_JSON = new LinkedHashMap<>();

    public static void loadCactiFromJson(){
        List<ModCactusBlockData> readBlocks = GsonCactusReader.readBlocksFromFile();

        assert readBlocks != null;

        if(!readBlocks.isEmpty()){
            for(ModCactusBlockData addedCacti : readBlocks){
                String id = addedCacti.getId();
                int lightLevel = addedCacti.getLightLevel();
                int tier = addedCacti.getTier();

                TIER.put(id, tier);
                CACTI_FROM_JSON.put(id, lightLevel);
            }
        }
    }
}
