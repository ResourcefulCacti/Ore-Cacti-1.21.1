package com.orecacti.resourcefulcactimod.util.block;

public class ModCactusBlockData {
    private String cactusName;
    private String id;

    public boolean dropSelf;
    public boolean dropWithChance;
    private boolean isGlowing;

    public float essenceDropChance;
    private int lightLevel;
    private int tier;

    public String getCactusName(){return cactusName;}
    public String getId(){return id;}
    public int getTier(){return tier;}
    public int getLightLevel(){return lightLevel;}
    public float getEssenceDropChance(){return essenceDropChance;}

    public ModCactusBlockData(String CactusName, String ID, int TIER, boolean DROPSELF, boolean DROPWITHCHANCE, float ESSENCEDROPCHANCE, boolean ISGLOWING, int LIGHTLEVEL){
        this.cactusName = CactusName;
        this.id = ID;
        this.tier = TIER;
        this.dropSelf = DROPSELF;
        this.dropWithChance = DROPWITHCHANCE;
        this.essenceDropChance = ESSENCEDROPCHANCE;
        this.isGlowing = ISGLOWING;
        this.lightLevel = LIGHTLEVEL;
    }
}
