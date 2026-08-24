package net.shirojr.nbv.block.util;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.shirojr.nbv.util.TintType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public record Variation(String name, Block parentBlock, Identifier innerTexture, Identifier outerTexture,
                        Identifier rimTexture, @Nullable Identifier customParticleTexture,
                        List<TagKey<Block>> blockTags, @Nullable TintType tint,
                        UnaryOperator<AbstractBlock.Settings> additionalBlockSettings) {

    public Variation(String name, Block parentBlock, Identifier innerTexture, Identifier outerTexture,
                     Identifier rimTexture, @Nullable Identifier customParticleTexture, List<TagKey<Block>> blockTags,
                     @Nullable TintType tint, @Nullable UnaryOperator<AbstractBlock.Settings> additionalBlockSettings) {
        this.name = name;
        this.parentBlock = parentBlock;
        this.innerTexture = Identifier.of(innerTexture.getNamespace(), "block/" + innerTexture.getPath());
        this.outerTexture = Identifier.of(outerTexture.getNamespace(), "block/" + outerTexture.getPath());
        this.rimTexture = Identifier.of(rimTexture.getNamespace(), "block/" + rimTexture.getPath());
        this.customParticleTexture = customParticleTexture == null ? null :
                Identifier.of(customParticleTexture.getNamespace(), "block/" + customParticleTexture.getPath());
        this.blockTags = blockTags;
        this.tint = tint;
        this.additionalBlockSettings = additionalBlockSettings;
    }

    public Variation(String name, Block parentBlock, Identifier innerTexture, Identifier outerTexture,
                     Identifier rimTexture, @Nullable Identifier customParticleTexture, List<TagKey<Block>> blockTags) {
        this(name, parentBlock, innerTexture, outerTexture, rimTexture, customParticleTexture, blockTags, null, null);
    }

    public Variation(String name, Block parentBlock, Identifier innerTexture, Identifier outerTexture,
                     Identifier rimTexture, List<TagKey<Block>> blockTags) {
        this(name, parentBlock, innerTexture, outerTexture, rimTexture, null, blockTags, null, null);
    }

    public Variation(String name, Block parentBlock, Identifier innerTexture, Identifier outerTexture,
                     Identifier rimTexture, List<TagKey<Block>> blockTags, TintType tint) {
        this(name, parentBlock, innerTexture, outerTexture, rimTexture, null, blockTags, tint, null);
    }

    public Variation(String name, Block parentBlock, Identifier singleTexture, List<TagKey<Block>> blockTags) {
        this(name, parentBlock, singleTexture, singleTexture, singleTexture, blockTags);
    }

    public Variation(String name, Block parentBlock, Identifier singleTexture, List<TagKey<Block>> blockTags,
                     UnaryOperator<AbstractBlock.Settings> additionalBlockSettings) {
        this(name, parentBlock, singleTexture, singleTexture, singleTexture, null, blockTags,
                null, additionalBlockSettings);
    }

    public Variation(String name, Block parentBlock, Identifier singleTexture, List<TagKey<Block>> blockTags, TintType tint) {
        this(name, parentBlock, singleTexture, singleTexture, singleTexture, blockTags, tint);
    }

    public Variation(String name, Block parentBlock, Identifier singleTexture, Identifier particleTexture, List<TagKey<Block>> blockTags) {
        this(name, parentBlock, singleTexture, singleTexture, singleTexture, particleTexture, blockTags, null, null);
    }

    public Variation(String name, Block parentBlock, Identifier singleTexture, Identifier particleTexture, List<TagKey<Block>> blockTags, UnaryOperator<AbstractBlock.Settings> additionalBlockSettings) {
        this(name, parentBlock, singleTexture, singleTexture, singleTexture, particleTexture, blockTags, null, additionalBlockSettings);
    }

    @SafeVarargs
    public static List<TagKey<Block>> getStoneTags(TagKey<Block>... extraTags) {
        List<TagKey<Block>> blockTags = new ArrayList<>();
        blockTags.add(BlockTags.PICKAXE_MINEABLE);
        blockTags.addAll(Arrays.asList(extraTags));
        return blockTags;
    }
}
