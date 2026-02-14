package com.orecacti.resourcefulcactimod.init;

import com.orecacti.resourcefulcactimod.gui.InWorldInteractionGUI;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(value = Dist.CLIENT)
public class ModScreens {
    @SubscribeEvent
    public static void clientLoad(RegisterMenuScreensEvent event){
        event.register(ModMenus.IN_WORLD_INTERACTION.get(), InWorldInteractionGUI::new);
    }
}
