package com.orecacti.resourcefulcactimod.util.block;

public class ModCactusBlockData {
    private String id;

    //public boolean dropSelf;
    //public boolean dropWithChance;
    //public float essenceDropChance;

    private int lightLevel;
    private int tier;

    //public String getCactusName(){return cactusName;}
    //public float getEssenceDropChance(){return essenceDropChance;}
    public String getId(){return id;}
    public int getTier(){return tier;}
    public int getLightLevel(){return lightLevel;}

    public ModCactusBlockData(String ID, int TIER, int LIGHTLEVEL){
        this.id = ID;
        this.tier = TIER;
        this.lightLevel = LIGHTLEVEL;
    }
}
