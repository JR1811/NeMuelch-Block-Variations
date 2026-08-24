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
import net.shirojr.nbv.block.util.VariationBuilder;
import net.shirojr.nbv.util.TintType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class NBVBlockVariations {
    public static final List<Variation> ALL_VARIATIONS = new ArrayList<>();
    public static final List<Variation> BIOME_TINTED = new ArrayList<>();


    public static final Variation GRASS = register(
            VariationBuilder.create("grass", Blocks.GRASS_BLOCK)
                    .innerTexture(NBVMain.getVanillaId("grass_block_top"))
                    .particleTexture(NBVMain.getVanillaId("grass_block_top"))
                    .shovelMinable()
                    .blockTags(tagKeys -> tagKeys.add(BlockTags.DIRT))
                    .tint(TintType.GRASS)
                    .build()
    );
    public static final Variation DIRT = register(VariationBuilder.create("dirt", Blocks.DIRT)
            .singleTexture(NBVMain.getVanillaId("dirt"))
            .shovelMinable()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.DIRT))
            .build()
    );
    public static final Variation DIRT_PATH = register(VariationBuilder.create("dirt_path", Blocks.DIRT_PATH)
            .singleTexture(NBVMain.getVanillaId("dirt_path_top"))
            .particleTexture(NBVMain.getVanillaId("dirt_path_top"))
            .shovelMinable()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.DIRT))
            .build()
    );
    public static final Variation MUD = register(VariationBuilder.create("mud", Blocks.MUD)
            .singleTexture(NBVMain.getVanillaId("mud"))
            .shovelMinable()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.DIRT))
            .build()
    );
    public static final Variation PACKED_MUD = register(VariationBuilder.create("packed_mud", Blocks.PACKED_MUD)
            .singleTexture(NBVMain.getVanillaId("packed_mud"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation MUD_BRICKS = register(VariationBuilder.create("mud_bricks", Blocks.MUD_BRICKS)
            .singleTexture(NBVMain.getVanillaId("mud_bricks"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation GRAVEL = register(VariationBuilder.create("gravel", Blocks.GRAVEL)
            .singleTexture(NBVMain.getVanillaId("gravel"))
            .shovelMinable()
            .build()
    );

    public static final Variation STONE = register(VariationBuilder.create("stone", Blocks.STONE)
            .singleTexture(NBVMain.getVanillaId("stone"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation SMOOTH_STONE = register(VariationBuilder.create("smooth_stone", Blocks.SMOOTH_STONE)
            .singleTexture(NBVMain.getVanillaId("smooth_stone"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation STONE_BRICKS = register(VariationBuilder.create("stone_bricks", Blocks.STONE_BRICKS)
            .singleTexture(NBVMain.getVanillaId("stone_bricks"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation CRACKED_STONE_BRICKS = register(VariationBuilder.create("cracked_stone_bricks", Blocks.CRACKED_STONE_BRICKS)
            .singleTexture(NBVMain.getVanillaId("cracked_stone_bricks"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation MOSSY_STONE_BRICKS = register(VariationBuilder.create("mossy_stone_bricks", Blocks.MOSSY_STONE_BRICKS)
            .singleTexture(NBVMain.getVanillaId("mossy_stone_bricks"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation COBBLESTONE = register(VariationBuilder.create("cobblestone", Blocks.COBBLESTONE)
            .singleTexture(NBVMain.getVanillaId("cobblestone"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation MOSSY_COBBLESTONE = register(VariationBuilder.create("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE)
            .singleTexture(NBVMain.getVanillaId("mossy_cobblestone"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation END_STONE = register(VariationBuilder.create("end_stone", Blocks.END_STONE)
            .singleTexture(NBVMain.getVanillaId("end_stone"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation END_STONE_BRICKS = register(VariationBuilder.create("end_stone_bricks", Blocks.END_STONE_BRICKS)
            .singleTexture(NBVMain.getVanillaId("end_stone_bricks"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation PURPUR_BLOCK = register(VariationBuilder.create("purpur_block", Blocks.PURPUR_BLOCK)
            .singleTexture(NBVMain.getVanillaId("purpur_block"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation BRICKS = register(VariationBuilder.create("bricks", Blocks.BRICKS)
            .singleTexture(NBVMain.getVanillaId("bricks"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation NETHER_BRICKS = register(VariationBuilder.create("nether_bricks", Blocks.NETHER_BRICKS)
            .singleTexture(NBVMain.getVanillaId("nether_bricks"))
            .pickaxeMinable()
            .build()
    );

    public static final Variation SAND = register(VariationBuilder.create("sand", Blocks.SAND)
            .singleTexture(NBVMain.getVanillaId("sand"))
            .shovelMinable()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.SAND))
            .build()
    );
    public static final Variation SMOOTH_SANDSTONE = register(VariationBuilder.create("smooth_sandstone", Blocks.SMOOTH_SANDSTONE)
            .singleTexture(NBVMain.getVanillaId("sandstone_top"))
            .particleTexture(NBVMain.getVanillaId("sandstone_top"))
            .pickaxeMinable()
            .blockTags(tagKeys -> tagKeys.add(ConventionalBlockTags.SANDSTONE_BLOCKS))
            .build()
    );
    public static final Variation SMOOTH_RED_SANDSTONE = register(VariationBuilder.create("smooth_red_sandstone", Blocks.SMOOTH_RED_SANDSTONE)
            .singleTexture(NBVMain.getVanillaId("red_sandstone_top"))
            .particleTexture(NBVMain.getVanillaId("red_sandstone_top"))
            .blockTags(tagKeys -> tagKeys.add(ConventionalBlockTags.RED_SANDSTONE_BLOCKS))
            .build()
    );

    public static final Variation DIORITE = register(VariationBuilder.create("diorite", Blocks.DIORITE)
            .singleTexture(NBVMain.getVanillaId("diorite"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation GRANITE = register(VariationBuilder.create("granite", Blocks.GRANITE)
            .singleTexture(NBVMain.getVanillaId("granite"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation ANDESITE = register(VariationBuilder.create("andesite", Blocks.ANDESITE)
            .singleTexture(NBVMain.getVanillaId("andesite"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation CALCITE = register(VariationBuilder.create("calcite", Blocks.CALCITE)
            .singleTexture(NBVMain.getVanillaId("calcite"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation TUFF = register(VariationBuilder.create("tuff", Blocks.TUFF)
            .singleTexture(NBVMain.getVanillaId("tuff"))
            .pickaxeMinable()
            .build()
    );

    public static final Variation OCHRE_FROGLIGHT = register(VariationBuilder.create("ochre_froglight", Blocks.OCHRE_FROGLIGHT)
            .innerTexture(NBVMain.getVanillaId("ochre_froglight_side"))
            .outerTexture(NBVMain.getVanillaId("ochre_froglight_side"))
            .rimTexture(NBVMain.getVanillaId("ochre_froglight_top"))
            .particleTexture(NBVMain.getVanillaId("ochre_froglight_top"))
            .build()
    );
    public static final Variation VERDANT_FROGLIGHT = register(VariationBuilder.create("verdant_froglight", Blocks.VERDANT_FROGLIGHT)
            .innerTexture(NBVMain.getVanillaId("verdant_froglight_side"))
            .outerTexture(NBVMain.getVanillaId("verdant_froglight_side"))
            .rimTexture(NBVMain.getVanillaId("verdant_froglight_top"))
            .particleTexture(NBVMain.getVanillaId("verdant_froglight_top"))
            .build()
    );
    public static final Variation PEARLESCENT_FROGLIGHT = register(VariationBuilder.create("pearlescent_froglight", Blocks.PEARLESCENT_FROGLIGHT)
            .innerTexture(NBVMain.getVanillaId("pearlescent_froglight_side"))
            .outerTexture(NBVMain.getVanillaId("pearlescent_froglight_side"))
            .rimTexture(NBVMain.getVanillaId("pearlescent_froglight_top"))
            .particleTexture(NBVMain.getVanillaId("pearlescent_froglight_top"))
            .build()
    );

    public static final Variation COAL_BLOCK = register(VariationBuilder.create("coal_block", Blocks.COAL_BLOCK)
            .singleTexture(NBVMain.getVanillaId("coal_block"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation IRON_BLOCK = register(VariationBuilder.create("iron_block", Blocks.IRON_BLOCK)
            .singleTexture(NBVMain.getVanillaId("iron_block"))
            .pickaxeMinable().needsStoneTool()
            .build()
    );
    public static final Variation GOLD_BLOCK = register(VariationBuilder.create("gold_block", Blocks.GOLD_BLOCK)
            .singleTexture(NBVMain.getVanillaId("gold_block"))
            .pickaxeMinable().needsIronTool()
            .build()
    );
    public static final Variation DIAMOND_BLOCK = register(VariationBuilder.create("diamond_block", Blocks.DIAMOND_BLOCK)
            .singleTexture(NBVMain.getVanillaId("diamond_block"))
            .pickaxeMinable().needsIronTool()
            .build()
    );
    public static final Variation EMERALD_BLOCK = register(VariationBuilder.create("emerald_block", Blocks.EMERALD_BLOCK)
            .singleTexture(NBVMain.getVanillaId("emerald_block"))
            .pickaxeMinable().needsIronTool()
            .build()
    );
    public static final Variation NETHERITE_BLOCK = register(VariationBuilder.create("netherite_block", Blocks.NETHERITE_BLOCK)
            .singleTexture(NBVMain.getVanillaId("netherite_block"))
            .pickaxeMinable().needsDiamondTool()
            .build()
    );
    public static final Variation QUARTZ_BLOCK = register(VariationBuilder.create("quartz_block", Blocks.QUARTZ_BLOCK)
            .innerTexture(NBVMain.getVanillaId("quartz_block_side"))
            .outerTexture(NBVMain.getVanillaId("quartz_block_side"))
            .rimTexture(NBVMain.getVanillaId("quartz_block_top"))
            .particleTexture(NBVMain.getVanillaId("quartz_block_top"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation AMETHYST_BLOCK = register(VariationBuilder.create("amethyst_block", Blocks.AMETHYST_BLOCK)
            .singleTexture(NBVMain.getVanillaId("amethyst_block"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation LAPIS_BLOCK = register(VariationBuilder.create("lapis_block", Blocks.LAPIS_BLOCK)
            .singleTexture(NBVMain.getVanillaId("lapis_block"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation REDSTONE_BLOCK = register(VariationBuilder.create("redstone_block", Blocks.REDSTONE_BLOCK)
            .singleTexture(NBVMain.getVanillaId("redstone_block"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation DRIPSTONE_BLOCK = register(VariationBuilder.create("dripstone_block", Blocks.DRIPSTONE_BLOCK)
            .singleTexture(NBVMain.getVanillaId("dripstone_block"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation BONE_BLOCK = register(VariationBuilder.create("bone_block", Blocks.BONE_BLOCK)
            .innerTexture(NBVMain.getVanillaId("bone_block_side"))
            .outerTexture(NBVMain.getVanillaId("bone_block_side"))
            .rimTexture(NBVMain.getVanillaId("bone_block_top"))
            .particleTexture(NBVMain.getVanillaId("bone_block_side"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation DRIED_KELP_BLOCK = register(VariationBuilder.create("dried_kelp_block", Blocks.DRIED_KELP_BLOCK)
            .innerTexture(NBVMain.getVanillaId("dried_kelp_side"))
            .outerTexture(NBVMain.getVanillaId("dried_kelp_side"))
            .rimTexture(NBVMain.getVanillaId("dried_kelp_top"))
            .particleTexture(NBVMain.getVanillaId("dried_kelp_side"))
            .build()
    );
    public static final Variation HAY_BLOCK = register(VariationBuilder.create("hay_block", Blocks.HAY_BLOCK)
            .innerTexture(NBVMain.getVanillaId("hay_block_side"))
            .outerTexture(NBVMain.getVanillaId("hay_block_side"))
            .rimTexture(NBVMain.getVanillaId("hay_block_top"))
            .particleTexture(NBVMain.getVanillaId("hay_block_side"))
            .build()
    );
    public static final Variation MOSS_BLOCK = register(VariationBuilder.create("moss_block", Blocks.MOSS_BLOCK)
            .singleTexture(NBVMain.getVanillaId("moss_block"))
            .hoeMinable()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.DIRT))
            .build()
    );

    public static final Variation COAL_ORE = register(VariationBuilder.create("coal_ore", Blocks.COAL_ORE)
            .singleTexture(NBVMain.getVanillaId("coal_ore"))
            .particleTexture(NBVMain.getVanillaId("stone"))
            .pickaxeMinable()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.COAL_ORES))
            .build()
    );
    public static final Variation DEEPSLATE_COAL_ORE = register(VariationBuilder.create("deepslate_coal_ore", Blocks.DEEPSLATE_COAL_ORE)
            .singleTexture(NBVMain.getVanillaId("deepslate_coal_ore"))
            .particleTexture(NBVMain.getVanillaId("deepslate"))
            .pickaxeMinable().needsStoneTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.COAL_ORES))
            .build()
    );
    public static final Variation COPPER_ORE = register(VariationBuilder.create("copper_ore", Blocks.COPPER_ORE)
            .singleTexture(NBVMain.getVanillaId("copper_ore"))
            .particleTexture(NBVMain.getVanillaId("stone"))
            .pickaxeMinable().needsStoneTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.COPPER_ORES))
            .build()
    );
    public static final Variation DEEPSLATE_COPPER_ORE = register(VariationBuilder.create("deepslate_copper_ore", Blocks.DEEPSLATE_COPPER_ORE)
            .singleTexture(NBVMain.getVanillaId("deepslate_copper_ore"))
            .particleTexture(NBVMain.getVanillaId("deepslate"))
            .pickaxeMinable().needsStoneTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.COPPER_ORES))
            .build()
    );
    public static final Variation IRON_ORE = register(VariationBuilder.create("iron_ore", Blocks.IRON_ORE)
            .singleTexture(NBVMain.getVanillaId("iron_ore"))
            .particleTexture(NBVMain.getVanillaId("stone"))
            .pickaxeMinable().needsStoneTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.IRON_ORES))
            .build()
    );
    public static final Variation DEEPSLATE_IRON_ORE = register(VariationBuilder.create("deepslate_iron_ore", Blocks.DEEPSLATE_IRON_ORE)
            .singleTexture(NBVMain.getVanillaId("deepslate_iron_ore"))
            .particleTexture(NBVMain.getVanillaId("deepslate"))
            .pickaxeMinable().needsIronTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.IRON_ORES))
            .build()
    );
    public static final Variation GOLD_ORE = register(VariationBuilder.create("gold_ore", Blocks.GOLD_ORE)
            .singleTexture(NBVMain.getVanillaId("gold_ore"))
            .particleTexture(NBVMain.getVanillaId("stone"))
            .pickaxeMinable().needsIronTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.GOLD_ORES))
            .build()
    );
    public static final Variation DEEPSLATE_GOLD_ORE = register(VariationBuilder.create("deepslate_gold_ore", Blocks.DEEPSLATE_GOLD_ORE)
            .singleTexture(NBVMain.getVanillaId("deepslate_gold_ore"))
            .particleTexture(NBVMain.getVanillaId("deepslate"))
            .pickaxeMinable().needsIronTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.GOLD_ORES))
            .build()
    );
    public static final Variation DIAMOND_ORE = register(VariationBuilder.create("diamond_ore", Blocks.DIAMOND_ORE)
            .singleTexture(NBVMain.getVanillaId("diamond_ore"))
            .particleTexture(NBVMain.getVanillaId("stone"))
            .pickaxeMinable().needsIronTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.DIAMOND_ORES))
            .build()
    );
    public static final Variation DEEPSLATE_DIAMOND_ORE = register(VariationBuilder.create("deepslate_diamond_ore", Blocks.DEEPSLATE_DIAMOND_ORE)
            .singleTexture(NBVMain.getVanillaId("deepslate_diamond_ore"))
            .particleTexture(NBVMain.getVanillaId("deepslate"))
            .pickaxeMinable().needsIronTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.DIAMOND_ORES))
            .build()
    );
    public static final Variation EMERALD_ORE = register(VariationBuilder.create("emerald_ore", Blocks.EMERALD_ORE)
            .singleTexture(NBVMain.getVanillaId("emerald_ore"))
            .particleTexture(NBVMain.getVanillaId("stone"))
            .pickaxeMinable().needsIronTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.EMERALD_ORES))
            .build()
    );
    public static final Variation DEEPSLATE_EMERALD_ORE = register(VariationBuilder.create("deepslate_emerald_ore", Blocks.DEEPSLATE_EMERALD_ORE)
            .singleTexture(NBVMain.getVanillaId("deepslate_emerald_ore"))
            .particleTexture(NBVMain.getVanillaId("deepslate"))
            .pickaxeMinable().needsIronTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.EMERALD_ORES))
            .build()
    );
    public static final Variation REDSTONE_ORE = register(VariationBuilder.create("redstone_ore", Blocks.REDSTONE_ORE)
            .singleTexture(NBVMain.getVanillaId("redstone_ore"))
            .particleTexture(NBVMain.getVanillaId("stone"))
            .pickaxeMinable().needsIronTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.REDSTONE_ORES))
            .build()
    );
    public static final Variation DEEPSLATE_REDSTONE_ORE = register(VariationBuilder.create("deepslate_redstone_ore", Blocks.DEEPSLATE_REDSTONE_ORE)
            .singleTexture(NBVMain.getVanillaId("deepslate_redstone_ore"))
            .particleTexture(NBVMain.getVanillaId("deepslate"))
            .pickaxeMinable().needsIronTool()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.REDSTONE_ORES))
            .build()
    );

    public static final Variation IRON_BARS = register(VariationBuilder.create("iron_bars", Blocks.IRON_BARS)
            .singleTexture(NBVMain.getVanillaId("iron_bars"))
            .pickaxeMinable()
            .build()
    );

    public static final Variation DEEPSLATE_BRICKS = register(VariationBuilder.create("deepslate_bricks", Blocks.DEEPSLATE_BRICKS)
            .singleTexture(NBVMain.getVanillaId("deepslate_bricks"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation COBBLED_DEEPSLATE = register(VariationBuilder.create("cobbled_deepslate", Blocks.COBBLED_DEEPSLATE)
            .singleTexture(NBVMain.getVanillaId("cobbled_deepslate"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation DEEPSLATE = register(VariationBuilder.create("deepslate", Blocks.DEEPSLATE)
            .innerTexture(NBVMain.getVanillaId("deepslate"))
            .outerTexture(NBVMain.getVanillaId("deepslate"))
            .rimTexture(NBVMain.getVanillaId("deepslate_top"))
            .pickaxeMinable()
            .build()
    );

    public static final Variation BASALT = register(VariationBuilder.create("basalt", Blocks.BASALT)
            .innerTexture(NBVMain.getVanillaId("basalt_side"))
            .outerTexture(NBVMain.getVanillaId("basalt_side"))
            .rimTexture(NBVMain.getVanillaId("basalt_top"))
            .particleTexture(NBVMain.getVanillaId("basalt_top"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation SMOOTH_BASALT = register(VariationBuilder.create("smooth_basalt", Blocks.SMOOTH_BASALT)
            .singleTexture(NBVMain.getVanillaId("smooth_basalt"))
            .pickaxeMinable()
            .build()
    );

    public static final Variation BLACKSTONE = register(VariationBuilder.create("blackstone", Blocks.BLACKSTONE)
            .singleTexture(NBVMain.getVanillaId("blackstone"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation GILDED_BLACKSTONE = register(VariationBuilder.create("gilded_blackstone", Blocks.GILDED_BLACKSTONE)
            .singleTexture(NBVMain.getVanillaId("gilded_blackstone"))
            .pickaxeMinable()
            .build()
    );

    public static final Variation NETHERRACK = register(VariationBuilder.create("netherrack", Blocks.NETHERRACK)
            .singleTexture(NBVMain.getVanillaId("netherrack"))
            .pickaxeMinable()
            .build()
    );

    public static final Variation PRISMARINE = register(VariationBuilder.create("prismarine", Blocks.PRISMARINE)
            .singleTexture(NBVMain.getVanillaId("prismarine"))
            .pickaxeMinable()
            .build()
    );
    public static final Variation PRISMARINE_BRICKS = register(VariationBuilder.create("prismarine_bricks", Blocks.PRISMARINE_BRICKS)
            .singleTexture(NBVMain.getVanillaId("prismarine_bricks"))
            .pickaxeMinable()
            .build()
    );

    public static final Variation WAXED_COPPER_BLOCK = register(VariationBuilder.create("waxed_copper_block", Blocks.WAXED_COPPER_BLOCK)
            .singleTexture(NBVMain.getVanillaId("copper_block"))
            .particleTexture(NBVMain.getVanillaId("cut_copper"))
            .pickaxeMinable().needsIronTool()
            .build()
    );
    public static final Variation WAXED_CUT_COPPER = register(VariationBuilder.create("waxed_cut_copper", Blocks.WAXED_CUT_COPPER)
            .singleTexture(NBVMain.getVanillaId("cut_copper"))
            .particleTexture(NBVMain.getVanillaId("cut_copper"))
            .pickaxeMinable().needsIronTool()
            .build()
    );
    public static final Variation WAXED_EXPOSED_COPPER = register(VariationBuilder.create("waxed_exposed_copper", Blocks.WAXED_EXPOSED_COPPER)
            .singleTexture(NBVMain.getVanillaId("exposed_copper"))
            .particleTexture(NBVMain.getVanillaId("exposed_copper"))
            .pickaxeMinable().needsIronTool()
            .build()
    );
    public static final Variation WAXED_EXPOSED_CUT_COPPER = register(VariationBuilder.create("waxed_exposed_cut_copper", Blocks.WAXED_EXPOSED_CUT_COPPER)
            .singleTexture(NBVMain.getVanillaId("exposed_cut_copper"))
            .particleTexture(NBVMain.getVanillaId("exposed_cut_copper"))
            .pickaxeMinable().needsIronTool()
            .build()
    );
    public static final Variation WAXED_WEATHERED_COPPER = register(VariationBuilder.create("waxed_weathered_copper", Blocks.WAXED_WEATHERED_COPPER)
            .singleTexture(NBVMain.getVanillaId("weathered_copper"))
            .particleTexture(NBVMain.getVanillaId("weathered_copper"))
            .pickaxeMinable().needsIronTool()
            .build()
    );
    public static final Variation WAXED_WEATHERED_CUT_COPPER = register(VariationBuilder.create("waxed_weathered_cut_copper", Blocks.WAXED_WEATHERED_CUT_COPPER)
            .singleTexture(NBVMain.getVanillaId("weathered_cut_copper"))
            .particleTexture(NBVMain.getVanillaId("weathered_cut_copper"))
            .pickaxeMinable().needsIronTool()
            .build()
    );
    public static final Variation WAXED_OXIDIZED_COPPER = register(VariationBuilder.create("waxed_oxidized_copper", Blocks.WAXED_OXIDIZED_COPPER)
            .singleTexture(NBVMain.getVanillaId("oxidized_copper"))
            .particleTexture(NBVMain.getVanillaId("oxidized_copper"))
            .pickaxeMinable().needsIronTool()
            .build()
    );
    public static final Variation WAXED_OXIDIZED_CUT_COPPER = register(VariationBuilder.create("waxed_oxidized_cut_copper", Blocks.WAXED_OXIDIZED_CUT_COPPER)
            .singleTexture(NBVMain.getVanillaId("oxidized_cut_copper"))
            .particleTexture(NBVMain.getVanillaId("oxidized_cut_copper"))
            .pickaxeMinable().needsIronTool()
            .build()
    );

    public static final Variation BARREL_BOTTOM = register(VariationBuilder.create("barrel_bottom", Blocks.BARREL)
            .singleTexture(NBVMain.getVanillaId("barrel_bottom"))
            .particleTexture(NBVMain.getVanillaId("spruce_planks"))
            .axeMinable()
            .build()
    );
    public static final Variation BARREL_LID = register(VariationBuilder.create("barrel_lid", Blocks.BARREL)
            .singleTexture(NBVMain.getVanillaId("barrel_top"))
            .particleTexture(NBVMain.getVanillaId("spruce_planks"))
            .axeMinable()
            .build()
    );
    public static final Variation BARREL_SIDE = register(VariationBuilder.create("barrel_side", Blocks.BARREL)
            .singleTexture(NBVMain.getVanillaId("barrel_side"))
            .particleTexture(NBVMain.getVanillaId("spruce_planks"))
            .axeMinable()
            .build()
    );

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

    public static final Variation GLASS = register(VariationBuilder.create("glass", Blocks.GLASS)
            .singleTexture(NBVMain.getVanillaId("glass"))
            .blockTags(tagKeys -> tagKeys.add(ConventionalBlockTags.GLASS_BLOCKS))
            .build()
    );

    public static final Variation ICE = register(VariationBuilder.create("ice", Blocks.ICE)
            .singleTexture(NBVMain.getVanillaId("ice"))
            .pickaxeMinable()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.ICE))
            .build()
    );
    public static final Variation PACKED_ICE = register(VariationBuilder.create("packed_ice", Blocks.PACKED_ICE)
            .singleTexture(NBVMain.getVanillaId("packed_ice"))
            .pickaxeMinable()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.ICE))
            .build()
    );
    public static final Variation BLUE_ICE = register(VariationBuilder.create("blue_ice", Blocks.BLUE_ICE)
            .singleTexture(NBVMain.getVanillaId("blue_ice"))
            .pickaxeMinable()
            .blockTags(tagKeys -> tagKeys.add(BlockTags.ICE))
            .build()
    );
    public static final Variation BARRIER = register(VariationBuilder.create("barrier", Blocks.BARRIER)
            .singleTexture(NBVMain.getId("blank"))
            .build()
    );

    public static final Variation SCAFFOLDING = register(VariationBuilder.create("scaffolding", Blocks.SCAFFOLDING)
            .singleTexture(NBVMain.getId("blank"))
            .singleTexture(NBVMain.getVanillaId("scaffolding_top"))
            .particleTexture(NBVMain.getVanillaId("scaffolding_top"))
            .axeMinable()
            .additionalBlockSettings(settings -> settings.noCollision().dynamicBounds())
            .build()
    );

    static {
        for (Block registryBlock : Registries.BLOCK) {
            Identifier registryBlockId = Registries.BLOCK.getId(registryBlock);
            if (!registryBlockId.getNamespace().equals("minecraft")) continue;
            String blockName = registryBlockId.getPath();

            if (blockName.endsWith("terracotta")) {
                ALL_VARIATIONS.add(
                        VariationBuilder.create(blockName, registryBlock)
                                .singleTexture(NBVMain.getVanillaId(blockName))
                                .pickaxeMinable()
                                .blockTags(tagKeys -> tagKeys.add(BlockTags.TERRACOTTA))
                                .build()
                );
            } else if (blockName.endsWith("wool")) {
                ALL_VARIATIONS.add(
                        VariationBuilder.create(blockName, registryBlock)
                                .singleTexture(NBVMain.getVanillaId(blockName))
                                .blockTags(tagKeys -> tagKeys.add(BlockTags.WOOL))
                                .build()
                );
            } else if (blockName.endsWith("concrete")) {
                ALL_VARIATIONS.add(
                        VariationBuilder.create(blockName, registryBlock)
                                .singleTexture(NBVMain.getVanillaId(blockName))
                                .pickaxeMinable()
                                .build()
                );
            } else if (blockName.endsWith("planks")) {
                ALL_VARIATIONS.add(
                        VariationBuilder.create(blockName, registryBlock)
                                .singleTexture(NBVMain.getVanillaId(blockName))
                                .axeMinable()
                                .blockTags(tagKeys -> tagKeys.add(BlockTags.PLANKS))
                                .build()
                );
            } else if (blockName.endsWith("stained_glass")) {
                ALL_VARIATIONS.add(
                        VariationBuilder.create(blockName, registryBlock)
                                .singleTexture(NBVMain.getVanillaId(blockName))
                                .blockTags(tagKeys -> tagKeys.add(ConventionalBlockTags.GLASS_BLOCKS))
                                .build()
                );
            } else if (blockName.endsWith("trapdoor")) {
                ALL_VARIATIONS.add(
                        VariationBuilder.create(blockName, registryBlock)
                                .singleTexture(NBVMain.getVanillaId(blockName))
                                .axeMinable()
                                .blockTags(tagKeys -> tagKeys.add(BlockTags.TRAPDOORS))
                                .build()
                );
            } else if (blockName.endsWith("leaves")) {
                ALL_VARIATIONS.add(
                        VariationBuilder.create(blockName, registryBlock)
                                .singleTexture(NBVMain.getVanillaId(blockName))
                                .hoeMinable()
                                .blockTags(tagKeys -> tagKeys.add(BlockTags.LEAVES))
                                .tint(TintType.FOLIAGE)
                                .build()
                );
            }
        }
    }

    private static Variation register(Variation variation) {
        ALL_VARIATIONS.add(variation);
        return variation;
    }

    private static List<Variation> registerLogsAndWood(Block base, @Nullable Block woodVersion, Block stripped,
                                                       @Nullable Block strippedWoodVersion, String name, TagKey<Block> logTag,
                                                       Pair<String, String> suffixes) {
        List<Variation> result = new ArrayList<>();
        String baseSuffix = suffixes.getLeft();
        String allSideSuffix = suffixes.getRight();

        result.add(
                register(
                        VariationBuilder.create(name + "_" + baseSuffix, base)
                                .innerTexture(NBVMain.getVanillaId("stripped_%s_%s".formatted(name, baseSuffix)))
                                .outerTexture(NBVMain.getVanillaId("%s_%s".formatted(name, baseSuffix)))
                                .rimTexture(NBVMain.getVanillaId("%s_%s_top".formatted(name, baseSuffix)))
                                .particleTexture(NBVMain.getVanillaId("%s_%s".formatted(name, baseSuffix)))
                                .blockTags(tagKeys -> tagKeys.add(logTag))
                                .build()
                )
        );
        result.add(
                register(
                        VariationBuilder.create("stripped_" + name + "_" + baseSuffix, stripped)
                                .innerTexture(NBVMain.getVanillaId("stripped_%s_%s".formatted(name, baseSuffix)))
                                .outerTexture(NBVMain.getVanillaId("stripped_%s_%s".formatted(name, baseSuffix)))
                                .rimTexture(NBVMain.getVanillaId("stripped_%s_%s".formatted(name, baseSuffix)))
                                .particleTexture(NBVMain.getVanillaId("%s_%s".formatted(name, baseSuffix)))
                                .blockTags(tagKeys -> tagKeys.add(logTag))
                                .build()
                )
        );
        if (allSideSuffix != null && woodVersion != null && strippedWoodVersion != null) {
            result.add(
                    register(
                            VariationBuilder.create(name + "_" + allSideSuffix, woodVersion)
                                    .innerTexture(NBVMain.getVanillaId("%s_%s".formatted(name, baseSuffix)))
                                    .outerTexture(NBVMain.getVanillaId("%s_%s".formatted(name, baseSuffix)))
                                    .rimTexture(NBVMain.getVanillaId("%s_%s".formatted(name, baseSuffix)))
                                    .particleTexture(NBVMain.getVanillaId("%s_%s".formatted(name, baseSuffix)))
                                    .blockTags(tagKeys -> tagKeys.add(logTag))
                                    .build()
                    )
            );
            result.add(
                    register(
                            VariationBuilder.create("stripped_" + name + "_" + allSideSuffix, strippedWoodVersion)
                                    .innerTexture(NBVMain.getVanillaId("stripped_%s_%s".formatted(name, baseSuffix)))
                                    .outerTexture(NBVMain.getVanillaId("stripped_%s_%s".formatted(name, baseSuffix)))
                                    .rimTexture(NBVMain.getVanillaId("stripped_%s_%s".formatted(name, baseSuffix)))
                                    .particleTexture(NBVMain.getVanillaId("stripped_%s_%s".formatted(name, baseSuffix)))
                                    .blockTags(tagKeys -> tagKeys.add(logTag))
                                    .build()
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
