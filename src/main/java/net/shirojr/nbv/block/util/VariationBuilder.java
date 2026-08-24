package net.shirojr.nbv.block.util;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.shirojr.nbv.util.TintType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class VariationBuilder {
    private final String name;
    private final Block parentBlock;
    private Identifier innerTexture;
    private Identifier outerTexture;
    private Identifier rimTexture;
    private @Nullable Identifier particleTexture;
    private final List<TagKey<Block>> blockTags = new ArrayList<>();
    private @Nullable TintType tint;
    private UnaryOperator<AbstractBlock.Settings> additionalBlockSettings;

    private VariationBuilder(String name, Block parentBlock) {
        this.name = name;
        this.parentBlock = parentBlock;
    }

    public static VariationBuilder create(String name, Block parentBlock) {
        return new VariationBuilder(name, parentBlock);
    }

    public VariationBuilder singleTexture(Identifier texture) {
        this.outerTexture = null;
        this.rimTexture = null;
        return this.innerTexture(texture);
    }

    public VariationBuilder innerTexture(Identifier texture) {
        this.innerTexture = texture;
        return this;
    }

    public VariationBuilder outerTexture(Identifier texture) {
        this.outerTexture = texture;
        return this;
    }

    public VariationBuilder rimTexture(Identifier texture) {
        this.rimTexture = texture;
        return this;
    }

    public VariationBuilder particleTexture(Identifier texture) {
        this.particleTexture = texture;
        return this;
    }

    public VariationBuilder blockTags(Consumer<List<TagKey<Block>>> tags) {
        tags.accept(this.blockTags);
        return this;
    }

    public VariationBuilder tint(TintType tint) {
        this.tint = tint;
        return this;
    }

    public VariationBuilder pickaxeMinable() {
        this.blockTags.add(BlockTags.PICKAXE_MINEABLE);
        return this;
    }

    public VariationBuilder shovelMinable() {
        this.blockTags.add(BlockTags.SHOVEL_MINEABLE);
        return this;
    }

    public VariationBuilder axeMinable() {
        this.blockTags.add(BlockTags.AXE_MINEABLE);
        return this;
    }

    public VariationBuilder hoeMinable() {
        this.blockTags.add(BlockTags.HOE_MINEABLE);
        return this;
    }

    public VariationBuilder needsStoneTool() {
        this.blockTags.add(BlockTags.NEEDS_STONE_TOOL);
        return this;
    }

    public VariationBuilder needsIronTool() {
        this.blockTags.add(BlockTags.NEEDS_IRON_TOOL);
        return this;
    }

    public VariationBuilder needsDiamondTool() {
        this.blockTags.add(BlockTags.NEEDS_DIAMOND_TOOL);
        return this;
    }

    public VariationBuilder additionalBlockSettings(UnaryOperator<AbstractBlock.Settings> additionalBlockSettings) {
        this.additionalBlockSettings = additionalBlockSettings;
        return this;
    }

    public Variation build() {
        if (this.innerTexture == null && this.outerTexture == null && this.rimTexture == null) {
            throw new IllegalStateException("Variations need at least one texture (Variation: %s)".formatted(this.name));
        } else if (this.innerTexture == null) {
            this.innerTexture = Objects.requireNonNullElseGet(this.outerTexture, () -> this.rimTexture);
        }
        Identifier innerTexture = this.innerTexture;
        Identifier outerTexture = this.outerTexture == null ? this.innerTexture : this.outerTexture;
        Identifier rimTexture = this.rimTexture == null ? this.innerTexture : this.rimTexture;
        return new Variation(name, parentBlock, innerTexture, outerTexture, rimTexture, this.particleTexture,
                this.blockTags, this.tint, this.additionalBlockSettings);
    }
}
