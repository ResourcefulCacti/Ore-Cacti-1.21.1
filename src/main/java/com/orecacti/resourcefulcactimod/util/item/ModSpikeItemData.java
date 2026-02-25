package com.orecacti.resourcefulcactimod.util.item;

public class ModSpikeItemData {
    private String spikeName;
    private String id;
    private String infusionBlock;

    public String getCactusName(){return spikeName;}
    public String getId(){return id;}
    public String getInfusionBlock(){return infusionBlock;}

    public ModSpikeItemData(String SpikeName, String ID, String spikeInfusionBlock){
        this.spikeName = SpikeName;
        this.id = ID;
        this.infusionBlock = spikeInfusionBlock;
    }
}
