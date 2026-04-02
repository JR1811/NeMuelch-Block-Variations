package net.shirojr.nemuelch.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.shirojr.nemuelch.NBVMain;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class NBVTags {
    public static final List<TagKey<?>> ALL_TAGS = new ArrayList<>();

    public static void initialize() {
        Blocks.initialize();
        Items.initialize();
    }

    public static class Blocks {
        public static final List<TagKey<Block>> ALL_BLOCK_TAGS = new ArrayList<>();

        public static final TagKey<Block> CENTERED_HALF_SLABS = createTag("centered_half_slabs");
        public static final TagKey<Block> CENTERED_VERTICAL_HALF_SLABS = createTag("centered_vertical_half_slabs");
        public static final TagKey<Block> CHIMNEYS = createTag("chimneys");
        public static final TagKey<Block> DOUBLE_PLATES = createTag("double_plates");
        public static final TagKey<Block> HALF_SLABS = createTag("half_slabs");
        public static final TagKey<Block> PLATES = createTag("plates");
        public static final TagKey<Block> SMALL_FENCES = createTag("small_fences");
        public static final TagKey<Block> VERTICAL_HALF_SLABS = createTag("vertical_half_slabs");

        private static TagKey<Block> createTag(String name) {
            TagKey<Block> tagKey = TagKey.of(RegistryKeys.BLOCK, new Identifier(NBVMain.MOD_ID, name));
            ALL_BLOCK_TAGS.add(tagKey);
            ALL_TAGS.add(tagKey);
            return tagKey;
        }

        private static TagKey<Block> createCommonTag(String name) {
            TagKey<Block> tagKey = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
            ALL_BLOCK_TAGS.add(tagKey);
            ALL_TAGS.add(tagKey);
            return tagKey;
        }

        public static void initialize() {
            // static initialisation
        }
    }

    public static class Items {
        public static final List<TagKey<Item>> ALL_ITEM_TAGS = new ArrayList<>();

        public static final TagKey<Item> CENTERED_HALF_SLABS = createTag("centered_half_slabs");
        public static final TagKey<Item> CENTERED_VERTICAL_HALF_SLABS = createTag("centered_vertical_half_slabs");
        public static final TagKey<Item> CHIMNEYS = createTag("chimneys");
        public static final TagKey<Item> DOUBLE_PLATES = createTag("double_plates");
        public static final TagKey<Item> HALF_SLABS = createTag("half_slabs");
        public static final TagKey<Item> PLATES = createTag("plates");
        public static final TagKey<Item> SMALL_FENCES = createTag("small_fences");
        public static final TagKey<Item> VERTICAL_HALF_SLABS = createTag("vertical_half_slabs");

        private static TagKey<Item> createTag(String name) {
            TagKey<Item> tagKey = TagKey.of(RegistryKeys.ITEM, new Identifier(NBVMain.MOD_ID, name));
            ALL_ITEM_TAGS.add(tagKey);
            ALL_TAGS.add(tagKey);
            return tagKey;
        }

        private static TagKey<Item> createCommonTag(String name) {
            TagKey<Item> tagKey = TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
            ALL_ITEM_TAGS.add(tagKey);
            ALL_TAGS.add(tagKey);
            return tagKey;
        }

        public static void initialize() {
            // static initialisation
        }
    }
}
