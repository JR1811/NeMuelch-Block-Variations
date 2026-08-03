package net.shirojr.nbv.init;

import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.shirojr.nbv.NBVMain;
import net.shirojr.nbv.block.util.Variation;
import net.shirojr.nbv.util.TintType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class NBVBlockVariations {
    public static final List<Variation> ALL_VARIATIONS = new ArrayList<>();
    public static final List<Variation> BIOME_TINTED = new ArrayList<>();


    public static final Variation GRASS = register(new Variation("grass", Blocks.GRASS_BLOCK, NBVMain.getVanillaId("grass_block_top"), NBVMain.getVanillaId("grass_block_top"), NBVMain.getVanillaId("grass_block_top"), NBVMain.getVanillaId("grass_block_top"), List.of(BlockTags.SHOVEL_MINEABLE, BlockTags.DIRT), TintType.GRASS));
    public static final Variation DIRT = register(new Variation("dirt", Blocks.DIRT, NBVMain.getVanillaId("dirt"), List.of(BlockTags.SHOVEL_MINEABLE, BlockTags.DIRT)));
    public static final Variation DIRT_PATH = register(new Variation("dirt_path", Blocks.DIRT_PATH, NBVMain.getVanillaId("dirt_path_top"), NBVMain.getVanillaId("dirt_path_top"), List.of(BlockTags.SHOVEL_MINEABLE, BlockTags.DIRT)));
    public static final Variation MUD = register(new Variation("mud", Blocks.MUD, NBVMain.getVanillaId("mud"), List.of(BlockTags.SHOVEL_MINEABLE, BlockTags.DIRT)));
    public static final Variation GRAVEL = register(new Variation("gravel", Blocks.GRAVEL, NBVMain.getVanillaId("gravel"), List.of(BlockTags.SHOVEL_MINEABLE)));

    public static final Variation STONE = register(new Variation("stone", Blocks.STONE, NBVMain.getVanillaId("stone"), Variation.getStoneTags()));
    public static final Variation SMOOTH_STONE = register(new Variation("smooth_stone", Blocks.SMOOTH_STONE, NBVMain.getVanillaId("smooth_stone"), Variation.getStoneTags()));

    public static final Variation STONE_BRICKS = register(new Variation("stone_bricks", Blocks.STONE_BRICKS, NBVMain.getVanillaId("stone_bricks"), Variation.getStoneTags()));
    public static final Variation CRACKED_STONE_BRICKS = register(new Variation("cracked_stone_bricks", Blocks.CRACKED_STONE_BRICKS, NBVMain.getVanillaId("cracked_stone_bricks"), Variation.getStoneTags()));
    public static final Variation MOSSY_STONE_BRICKS = register(new Variation("mossy_stone_bricks", Blocks.CRACKED_STONE_BRICKS, NBVMain.getVanillaId("mossy_stone_bricks"), Variation.getStoneTags()));

    public static final Variation COBBLESTONE = register(new Variation("cobblestone", Blocks.COBBLESTONE, NBVMain.getVanillaId("cobblestone"), Variation.getStoneTags()));
    public static final Variation MOSSY_COBBLESTONE = register(new Variation("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE, NBVMain.getVanillaId("mossy_cobblestone"), Variation.getStoneTags()));

    public static final Variation END_STONE = register(new Variation("end_stone", Blocks.END_STONE, NBVMain.getVanillaId("end_stone"), Variation.getStoneTags()));
    public static final Variation END_STONE_BRICKS = register(new Variation("end_stone_bricks", Blocks.END_STONE_BRICKS, NBVMain.getVanillaId("end_stone_bricks"), Variation.getStoneTags()));

    public static final Variation PURPUR_BLOCK = register(new Variation("purpur_block", Blocks.PURPUR_BLOCK, new Identifier("purpur_block"), Variation.getStoneTags()));

    public static final Variation BRICKS = register(new Variation("bricks", Blocks.BRICKS, NBVMain.getVanillaId("bricks"), Variation.getStoneTags()));
    public static final Variation NETHER_BRICKS = register(new Variation("nether_bricks", Blocks.NETHER_BRICKS, NBVMain.getVanillaId("nether_bricks"), Variation.getStoneTags()));
    public static final Variation MUD_BRICKS = register(new Variation("mud_bricks", Blocks.MUD_BRICKS, NBVMain.getVanillaId("mud_bricks"), Variation.getStoneTags()));

    public static final Variation SAND = register(new Variation("sand", Blocks.SAND, NBVMain.getVanillaId("sand"), List.of(BlockTags.SHOVEL_MINEABLE, BlockTags.SAND)));
    public static final Variation SMOOTH_SANDSTONE = register(new Variation("smooth_sandstone", Blocks.SMOOTH_SANDSTONE, NBVMain.getVanillaId("sandstone_top"), NBVMain.getVanillaId("sandstone_top"), Variation.getStoneTags(ConventionalBlockTags.SANDSTONE_BLOCKS)));
    public static final Variation SMOOTH_RED_SANDSTONE = register(new Variation("smooth_red_sandstone", Blocks.SMOOTH_RED_SANDSTONE, NBVMain.getVanillaId("red_sandstone_top"), NBVMain.getVanillaId("red_sandstone_top"), Variation.getStoneTags(ConventionalBlockTags.RED_SANDSTONE_BLOCKS)));

    public static final Variation DIORITE = register(new Variation("diorite", Blocks.DIORITE, NBVMain.getVanillaId("diorite"), Variation.getStoneTags()));
    public static final Variation GRANITE = register(new Variation("granite", Blocks.GRANITE, NBVMain.getVanillaId("granite"), Variation.getStoneTags()));
    public static final Variation ANDESITE = register(new Variation("andesite", Blocks.ANDESITE, NBVMain.getVanillaId("andesite"), Variation.getStoneTags()));
    public static final Variation CALCITE = register(new Variation("calcite", Blocks.CALCITE, NBVMain.getVanillaId("calcite"), Variation.getStoneTags()));
    public static final Variation TUFF = register(new Variation("tuff", Blocks.TUFF, NBVMain.getVanillaId("tuff"), Variation.getStoneTags()));

    public static final Variation OCHRE_FROGLIGHT = register(new Variation("ochre_froglight", Blocks.OCHRE_FROGLIGHT, new Identifier("ochre_froglight_side"), new Identifier("ochre_froglight_side"), new Identifier("ochre_froglight_top"), new Identifier("ochre_froglight_top"), List.of()));
    public static final Variation VERDANT_FROGLIGHT = register(new Variation("verdant_froglight", Blocks.VERDANT_FROGLIGHT, new Identifier("verdant_froglight_side"), new Identifier("verdant_froglight_side"), new Identifier("verdant_froglight_top"), new Identifier("verdant_froglight_top"), List.of()));
    public static final Variation PEARLESCENT_FROGLIGHT = register(new Variation("pearlescent_froglight", Blocks.PEARLESCENT_FROGLIGHT, new Identifier("pearlescent_froglight_side"), new Identifier("pearlescent_froglight_side"), new Identifier("pearlescent_froglight_top"), new Identifier("pearlescent_froglight_top"), List.of()));

    public static final Variation COAL_BLOCK = register(new Variation("coal_block", Blocks.COAL_BLOCK, NBVMain.getVanillaId("coal_block"), List.of(BlockTags.PICKAXE_MINEABLE)));
    public static final Variation IRON_BLOCK = register(new Variation("iron_block", Blocks.IRON_BLOCK, NBVMain.getVanillaId("iron_block"), List.of(BlockTags.NEEDS_STONE_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation GOLD_BLOCK = register(new Variation("gold_block", Blocks.GOLD_BLOCK, NBVMain.getVanillaId("gold_block"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation DIAMOND_BLOCK = register(new Variation("diamond_block", Blocks.DIAMOND_BLOCK, NBVMain.getVanillaId("diamond_block"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation EMERALD_BLOCK = register(new Variation("emerald_block", Blocks.EMERALD_BLOCK, NBVMain.getVanillaId("emerald_block"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation NETHERITE_BLOCK = register(new Variation("netherite_block", Blocks.NETHERITE_BLOCK, NBVMain.getVanillaId("netherite_block"), List.of(BlockTags.NEEDS_DIAMOND_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation QUARTZ_BLOCK = register(new Variation("quartz_block", Blocks.QUARTZ_BLOCK, new Identifier("quartz_block_side"), new Identifier("quartz_block_side"), new Identifier("quartz_block_top"), new Identifier("quartz_block_top"), Variation.getStoneTags()));
    public static final Variation AMETHYST_BLOCK = register(new Variation("amethyst_block", Blocks.AMETHYST_BLOCK, new Identifier("amethyst_block"), Variation.getStoneTags()));
    public static final Variation LAPIS_BLOCK = register(new Variation("lapis_block", Blocks.LAPIS_BLOCK, new Identifier("lapis_block"), Variation.getStoneTags()));
    public static final Variation REDSTONE_BLOCK = register(new Variation("redstone_block", Blocks.REDSTONE_BLOCK, new Identifier("redstone_block"), Variation.getStoneTags()));
    public static final Variation DRIPSTONE_BLOCK = register(new Variation("dripstone_block", Blocks.DRIPSTONE_BLOCK, new Identifier("dripstone_block"), Variation.getStoneTags()));
    public static final Variation BONE_BLOCK = register(new Variation("bone_block", Blocks.BONE_BLOCK, new Identifier("bone_block_side"), new Identifier("bone_block_side"), new Identifier("bone_block_top"), new Identifier("bone_block_side"), Variation.getStoneTags()));
    public static final Variation DRIED_KELP_BLOCK = register(new Variation("dried_kelp_block", Blocks.DRIED_KELP_BLOCK, new Identifier("dried_kelp_side"), new Identifier("dried_kelp_side"), new Identifier("dried_kelp_top"), new Identifier("dried_kelp_side"), List.of()));
    public static final Variation HAY_BLOCK = register(new Variation("hay_block", Blocks.HAY_BLOCK, new Identifier("hay_block_side"), new Identifier("hay_block_side"), new Identifier("hay_block_top"), new Identifier("hay_block_side"), List.of()));
    public static final Variation MOSS_BLOCK = register(new Variation("moss_block", Blocks.MOSS_BLOCK, NBVMain.getVanillaId("moss_block"), List.of(BlockTags.DIRT, BlockTags.HOE_MINEABLE)));

    public static final Variation COAL_ORE = register(new Variation("coal_ore", Blocks.COAL_ORE, NBVMain.getVanillaId("coal_ore"), NBVMain.getVanillaId("stone"), List.of(BlockTags.COAL_ORES, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation DEEPSLATE_COAL_ORE = register(new Variation("deepslate_coal_ore", Blocks.DEEPSLATE_COAL_ORE, NBVMain.getVanillaId("deepslate_coal_ore"), NBVMain.getVanillaId("deepslate"), List.of(BlockTags.COAL_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_STONE_TOOL)));
    public static final Variation COPPER_ORE = register(new Variation("copper_ore", Blocks.COPPER_ORE, NBVMain.getVanillaId("copper_ore"), NBVMain.getVanillaId("stone"), List.of(BlockTags.COPPER_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_STONE_TOOL)));
    public static final Variation DEEPSLATE_COPPER_ORE = register(new Variation("deepslate_copper_ore", Blocks.DEEPSLATE_COPPER_ORE, NBVMain.getVanillaId("deepslate_copper_ore"), NBVMain.getVanillaId("deepslate"), List.of(BlockTags.COPPER_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_STONE_TOOL)));
    public static final Variation IRON_ORE = register(new Variation("iron_ore", Blocks.IRON_ORE, NBVMain.getVanillaId("iron_ore"), NBVMain.getVanillaId("stone"), List.of(BlockTags.IRON_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_STONE_TOOL)));
    public static final Variation DEEPSLATE_IRON_ORE = register(new Variation("deepslate_iron_ore", Blocks.DEEPSLATE_IRON_ORE, NBVMain.getVanillaId("deepslate_iron_ore"), NBVMain.getVanillaId("deepslate"), List.of(BlockTags.IRON_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_STONE_TOOL)));
    public static final Variation GOLD_ORE = register(new Variation("gold_ore", Blocks.GOLD_ORE, NBVMain.getVanillaId("gold_ore"), NBVMain.getVanillaId("stone"), List.of(BlockTags.GOLD_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_IRON_TOOL)));
    public static final Variation DEEPSLATE_GOLD_ORE = register(new Variation("deepslate_gold_ore", Blocks.DEEPSLATE_GOLD_ORE, NBVMain.getVanillaId("deepslate_gold_ore"), NBVMain.getVanillaId("deepslate"), List.of(BlockTags.GOLD_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_IRON_TOOL)));
    public static final Variation DIAMOND_ORE = register(new Variation("diamond_ore", Blocks.DIAMOND_ORE, NBVMain.getVanillaId("diamond_ore"), NBVMain.getVanillaId("stone"), List.of(BlockTags.DIAMOND_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_IRON_TOOL)));
    public static final Variation DEEPSLATE_DIAMOND_ORE = register(new Variation("deepslate_diamond_ore", Blocks.DEEPSLATE_DIAMOND_ORE, NBVMain.getVanillaId("deepslate_diamond_ore"), NBVMain.getVanillaId("deepslate"), List.of(BlockTags.DIAMOND_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_IRON_TOOL)));
    public static final Variation EMERALD_ORE = register(new Variation("emerald_ore", Blocks.EMERALD_ORE, NBVMain.getVanillaId("emerald_ore"), NBVMain.getVanillaId("stone"), List.of(BlockTags.EMERALD_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_IRON_TOOL)));
    public static final Variation DEEPSLATE_EMERALD_ORE = register(new Variation("deepslate_emerald_ore", Blocks.DEEPSLATE_EMERALD_ORE, NBVMain.getVanillaId("deepslate_emerald_ore"), NBVMain.getVanillaId("deepslate"), List.of(BlockTags.EMERALD_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_IRON_TOOL)));
    public static final Variation REDSTONE_ORE = register(new Variation("redstone_ore", Blocks.REDSTONE_ORE, NBVMain.getVanillaId("redstone_ore"), NBVMain.getVanillaId("stone"), List.of(BlockTags.REDSTONE_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_IRON_TOOL)));
    public static final Variation DEEPSLATE_REDSTONE_ORE = register(new Variation("deepslate_redstone_ore", Blocks.DEEPSLATE_REDSTONE_ORE, NBVMain.getVanillaId("deepslate_redstone_ore"), NBVMain.getVanillaId("deepslate"), List.of(BlockTags.REDSTONE_ORES, BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_IRON_TOOL)));

    public static final Variation IRON_BARS = register(new Variation("iron_bars", Blocks.IRON_BARS, NBVMain.getVanillaId("iron_bars"), Variation.getStoneTags()));

    public static final Variation DEEPSLATE_BRICKS = register(new Variation("deepslate_bricks", Blocks.DEEPSLATE_BRICKS, NBVMain.getVanillaId("deepslate_bricks"), Variation.getStoneTags()));
    public static final Variation COBBLED_DEEPSLATE = register(new Variation("cobbled_deepslate", Blocks.COBBLED_DEEPSLATE, NBVMain.getVanillaId("cobbled_deepslate"), Variation.getStoneTags()));
    public static final Variation DEEPSLATE = register(new Variation("deepslate", Blocks.DEEPSLATE, new Identifier("deepslate"), new Identifier("deepslate"), new Identifier("deepslate_top"), Variation.getStoneTags()));

    public static final Variation BASALT = register(new Variation("basalt", Blocks.BASALT, new Identifier("basalt_side"), new Identifier("basalt_side"), new Identifier("basalt_top"), new Identifier("basalt_top"), Variation.getStoneTags()));
    public static final Variation SMOOTH_BASALT = register(new Variation("smooth_basalt", Blocks.SMOOTH_BASALT, new Identifier("smooth_basalt"), Variation.getStoneTags()));

    public static final Variation BLACKSTONE = register(new Variation("blackstone", Blocks.BLACKSTONE, new Identifier("blackstone"), Variation.getStoneTags()));
    public static final Variation GILDED_BLACKSTONE = register(new Variation("gilded_blackstone", Blocks.GILDED_BLACKSTONE, new Identifier("gilded_blackstone"), Variation.getStoneTags()));

    public static final Variation NETHERRACK = register(new Variation("netherrack", Blocks.NETHERRACK, new Identifier("netherrack"), Variation.getStoneTags()));

    public static final Variation PRISMARINE = register(new Variation("prismarine", Blocks.PRISMARINE, NBVMain.getVanillaId("prismarine"), Variation.getStoneTags()));
    public static final Variation PRISMARINE_BRICKS = register(new Variation("prismarine_bricks", Blocks.PRISMARINE_BRICKS, NBVMain.getVanillaId("prismarine_bricks"), Variation.getStoneTags()));

    public static final Variation WAXED_COPPER_BLOCK = register(new Variation("waxed_copper_block", Blocks.WAXED_COPPER_BLOCK, NBVMain.getVanillaId("copper_block"), NBVMain.getVanillaId("cut_copper"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation WAXED_CUT_COPPER = register(new Variation("waxed_cut_copper", Blocks.WAXED_CUT_COPPER, NBVMain.getVanillaId("cut_copper"), NBVMain.getVanillaId("cut_copper"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation WAXED_EXPOSED_COPPER = register(new Variation("waxed_exposed_copper", Blocks.WAXED_EXPOSED_COPPER, NBVMain.getVanillaId("exposed_copper"), NBVMain.getVanillaId("exposed_copper"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation WAXED_EXPOSED_CUT_COPPER = register(new Variation("waxed_exposed_cut_copper", Blocks.WAXED_EXPOSED_CUT_COPPER, NBVMain.getVanillaId("exposed_cut_copper"), NBVMain.getVanillaId("exposed_cut_copper"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation WAXED_WEATHERED_COPPER = register(new Variation("waxed_weathered_copper", Blocks.WAXED_WEATHERED_COPPER, NBVMain.getVanillaId("weathered_copper"), NBVMain.getVanillaId("weathered_copper"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation WAXED_WEATHERED_CUT_COPPER = register(new Variation("waxed_weathered_cut_copper", Blocks.WAXED_WEATHERED_CUT_COPPER, NBVMain.getVanillaId("weathered_cut_copper"), NBVMain.getVanillaId("weathered_cut_copper"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation WAXED_OXIDIZED_COPPER = register(new Variation("waxed_oxidized_copper", Blocks.WAXED_OXIDIZED_COPPER, NBVMain.getVanillaId("oxidized_copper"), NBVMain.getVanillaId("oxidized_copper"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));
    public static final Variation WAXED_OXIDIZED_CUT_COPPER = register(new Variation("waxed_oxidized_cut_copper", Blocks.WAXED_OXIDIZED_CUT_COPPER, NBVMain.getVanillaId("oxidized_cut_copper"), NBVMain.getVanillaId("oxidized_cut_copper"), List.of(BlockTags.NEEDS_IRON_TOOL, BlockTags.PICKAXE_MINEABLE)));

    public static final Variation BARREL_BOTTOM = register(new Variation("barrel_bottom", Blocks.BARREL, NBVMain.getVanillaId("barrel_bottom"), NBVMain.getVanillaId("spruce_planks"), List.of(BlockTags.AXE_MINEABLE)));
    public static final Variation BARREL_LID = register(new Variation("barrel_lid", Blocks.BARREL, NBVMain.getVanillaId("barrel_top"), NBVMain.getVanillaId("spruce_planks"), List.of(BlockTags.AXE_MINEABLE)));
    public static final Variation BARREL_SIDE = register(new Variation("barrel_side", Blocks.BARREL, NBVMain.getVanillaId("barrel_side"), NBVMain.getVanillaId("spruce_planks"), List.of(BlockTags.AXE_MINEABLE)));

    public static final List<Variation> OAK_LOG = registerLogsAndWood(Blocks.OAK_LOG, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_OAK_WOOD, "oak", BlockTags.OAK_LOGS, new Pair<>("log", "wood"));
    public static final List<Variation> SPRUCE_LOG = registerLogsAndWood(Blocks.SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_WOOD, "spruce", BlockTags.SPRUCE_LOGS, new Pair<>("log", "wood"));
    public static final List<Variation> BIRCH_LOG = registerLogsAndWood(Blocks.BIRCH_LOG, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_WOOD, "birch", BlockTags.BIRCH_LOGS, new Pair<>("log", "wood"));
    public static final List<Variation> ACACIA_LOG = registerLogsAndWood(Blocks.ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_WOOD, "acacia", BlockTags.ACACIA_LOGS, new Pair<>("log", "wood"));
    public static final List<Variation> DARK_OAK_LOG = registerLogsAndWood(Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_WOOD, "dark_oak", BlockTags.DARK_OAK_LOGS, new Pair<>("log", "wood"));
    public static final List<Variation> JUNGLE_LOG = registerLogsAndWood(Blocks.JUNGLE_LOG, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_WOOD, "jungle", BlockTags.JUNGLE_LOGS, new Pair<>("log", "wood"));
    public static final List<Variation> CHERRY_LOG = registerLogsAndWood(Blocks.CHERRY_LOG, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_LOG, Blocks.STRIPPED_CHERRY_WOOD, "cherry", BlockTags.CHERRY_LOGS, new Pair<>("log", "wood"));
    public static final List<Variation> MANGROVE_LOG = registerLogsAndWood(Blocks.MANGROVE_LOG, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_WOOD, "mangrove", BlockTags.MANGROVE_LOGS, new Pair<>("log", "wood"));
    public static final List<Variation> CRIMSON_STEM = registerLogsAndWood(Blocks.CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_HYPHAE, "crimson", BlockTags.CRIMSON_STEMS, new Pair<>("stem", "hyphae"));
    public static final List<Variation> WARPED_STEM = registerLogsAndWood(Blocks.WARPED_STEM, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_STEM, Blocks.STRIPPED_WARPED_HYPHAE, "warped", BlockTags.WARPED_STEMS, new Pair<>("stem", "hyphae"));
    public static final List<Variation> BAMBOO_BLOCK = registerLogsAndWood(Blocks.BAMBOO_BLOCK, null, Blocks.STRIPPED_BAMBOO_BLOCK, null, "bamboo", BlockTags.BAMBOO_BLOCKS, new Pair<>("block", null));

    public static final Variation GLASS = register(new Variation("glass", Blocks.GLASS, new Identifier("glass"), List.of(ConventionalBlockTags.GLASS_BLOCKS)));


    static {
        for (Block registryBlock : Registries.BLOCK) {
            Identifier registryBlockId = Registries.BLOCK.getId(registryBlock);
            if (!registryBlockId.getNamespace().equals("minecraft")) continue;
            String blockName = registryBlockId.getPath();

            if (blockName.endsWith("terracotta")) {
                ALL_VARIATIONS.add(new Variation(blockName, registryBlock, NBVMain.getVanillaId(blockName), Variation.getStoneTags(BlockTags.TERRACOTTA)));
            } else if (blockName.endsWith("wool")) {
                ALL_VARIATIONS.add(new Variation(blockName, registryBlock, NBVMain.getVanillaId(blockName), List.of(BlockTags.WOOL)));
            } else if (blockName.endsWith("concrete")) {
                ALL_VARIATIONS.add(new Variation(blockName, registryBlock, NBVMain.getVanillaId(blockName), Variation.getStoneTags()));
            } else if (blockName.endsWith("planks")) {
                ALL_VARIATIONS.add(new Variation(blockName, registryBlock, NBVMain.getVanillaId(blockName), List.of(BlockTags.PLANKS)));
            } else if (blockName.endsWith("stained_glass")) {
                ALL_VARIATIONS.add(new Variation(blockName, registryBlock, NBVMain.getVanillaId(blockName), List.of(ConventionalBlockTags.GLASS_BLOCKS)));
            } else if (blockName.endsWith("trapdoor")) {
                ALL_VARIATIONS.add(new Variation(blockName, registryBlock, NBVMain.getVanillaId(blockName), List.of(BlockTags.TRAPDOORS)));
            } else if (blockName.endsWith("leaves")) {
                ALL_VARIATIONS.add(new Variation(blockName, registryBlock, NBVMain.getVanillaId(blockName), List.of(BlockTags.LEAVES), TintType.FOLIAGE));
            }
        }
    }

    private static Variation register(Variation variation) {
        ALL_VARIATIONS.add(variation);
        return variation;
    }

    private static List<Variation> registerLogsAndWood(Block base, @Nullable Block woodVersion, Block stripped, @Nullable Block strippedWoodVersion, String name, TagKey<Block> logTag, Pair<String, String> suffixes) {
        List<Variation> result = new ArrayList<>();
        String baseSuffix = suffixes.getLeft();
        String allSideSuffix = suffixes.getRight();

        result.add(
                register(
                        new Variation(
                                name + "_" + baseSuffix,
                                base,
                                new Identifier("stripped_%s_%s".formatted(name, baseSuffix)),
                                new Identifier("%s_%s".formatted(name, baseSuffix)),
                                new Identifier("%s_%s_top".formatted(name, baseSuffix)),
                                List.of(logTag)
                        )
                )
        );
        result.add(
                register(
                        new Variation(
                                "stripped_" + name + "_" + baseSuffix,
                                stripped,
                                new Identifier("stripped_%s_%s".formatted(name, baseSuffix)),
                                new Identifier("stripped_%s_%s".formatted(name, baseSuffix)),
                                new Identifier("stripped_%s_%s_top".formatted(name, baseSuffix)),
                                List.of(logTag)
                        )
                )
        );
        if (allSideSuffix != null && woodVersion != null && strippedWoodVersion != null) {
            result.add(
                    register(
                            new Variation(
                                    name + "_" + allSideSuffix,
                                    woodVersion,
                                    new Identifier("%s_%s".formatted(name, baseSuffix)),
                                    new Identifier("%s_%s".formatted(name, baseSuffix)),
                                    new Identifier("%s_%s".formatted(name, baseSuffix)),
                                    List.of(logTag)
                            )
                    )
            );
            result.add(
                    register(
                            new Variation(
                                    "stripped_" + name + "_" + allSideSuffix,
                                    strippedWoodVersion,
                                    new Identifier("stripped_%s_%s".formatted(name, baseSuffix)),
                                    new Identifier("stripped_%s_%s".formatted(name, baseSuffix)),
                                    new Identifier("stripped_%s_%s".formatted(name, baseSuffix)),
                                    List.of(logTag)
                            )
                    )
            );
        }

        return result;
    }

    @Nullable
    public static Variation fromParent(Block block) {
        for (Variation entry : ALL_VARIATIONS) {
            if (entry.parentBlock().equals(block)) return entry;
        }
        return null;
    }
}
