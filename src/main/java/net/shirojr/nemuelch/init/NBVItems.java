package net.shirojr.nemuelch.init;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.shirojr.nemuelch.NBVMain;

import java.util.ArrayList;
import java.util.List;

public interface NBVItems {
    List<Item> ALL_ITEMS = new ArrayList<>();
    List<Item> VARIATION_BLOCK_ITEMS = new ArrayList<>();


    static <T extends Item> T register(String name, T entry) {
        T registeredEntry = Registry.register(Registries.ITEM, NBVMain.getId(name), entry);
        ALL_ITEMS.add(registeredEntry);
        return registeredEntry;
    }

    static <T extends Item> T register(String name, T entry, List<Item> group) {
        T registeredEntry = Registry.register(Registries.ITEM, NBVMain.getId(name), entry);
        ALL_ITEMS.add(registeredEntry);
        return registeredEntry;
    }

    static void initialize() {
        // static initialisation
    }
}
