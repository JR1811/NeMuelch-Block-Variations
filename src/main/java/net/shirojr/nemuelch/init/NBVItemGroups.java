package net.shirojr.nemuelch.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.shirojr.nemuelch.NBVMain;

import java.util.List;

public class NBVItemGroups {
    public static final RegistryKey<ItemGroup> NEMUELCH_VARIATION_BLOCKS = register("nemuelch_variations",
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(NBVBlocks.ALL_BLOCKS.get(0)))
                    .displayName(Text.translatable("itemGroup.%s.block_variations".formatted(NBVMain.MOD_ID)))
                    .build()
    );

    static {
        addItemsToGroup(NBVItems.VARIATION_BLOCK_ITEMS, NEMUELCH_VARIATION_BLOCKS, ItemGroups.BUILDING_BLOCKS);
    }

    @SuppressWarnings("SameParameterValue")
    @SafeVarargs
    private static void addItemsToGroup(List<Item> toBeAdded, RegistryKey<ItemGroup>... groups) {
        for (RegistryKey<ItemGroup> group : groups) {
            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {
                for (ItemConvertible entry : toBeAdded) {
                    entries.add(entry);
                }
            });
        }
    }

    @SuppressWarnings("unused")
    @SafeVarargs
    private static void addItemStacksToGroup(List<ItemStack> toBeAdded, RegistryKey<ItemGroup>... groups) {
        for (RegistryKey<ItemGroup> group : groups) {
            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {
                for (ItemStack entry : toBeAdded) {
                    entries.add(entry);
                }
            });
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static RegistryKey<ItemGroup> register(String name, ItemGroup group) {
        Registry.register(Registries.ITEM_GROUP, NBVMain.getId(name), group);
        return RegistryKey.of(Registries.ITEM_GROUP.getKey(), NBVMain.getId(name));
    }

    public static void initialize() {
        // static initialisation
    }
}
