package com.orecacti.resourcefulcactimod.util.item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ReadSpikeFromJson {

    //public static final LinkedHashMap<String, Integer> REGISTER_SPIKE_FROM_JSON = new LinkedHashMap<>();
    public static final List<String> REGISTER_SPIKE_FROM_JSON = new ArrayList<>();
    public static final LinkedHashMap<String, String> INFUSION_BLOCK = new LinkedHashMap<>();

    public static void loadSpikesFromJson(){
        List<ModSpikeItemData> readItems = GsonSpikeReader.readItemsFromFile();

        assert readItems != null;

        if(!readItems.isEmpty()){
            for(ModSpikeItemData addedSpike : readItems){
                String id = addedSpike.getId();
                String infusionBlock = addedSpike.getInfusionBlock();

                REGISTER_SPIKE_FROM_JSON.add(id);
                INFUSION_BLOCK.put(infusionBlock, id);
            }
        }
    }
}
