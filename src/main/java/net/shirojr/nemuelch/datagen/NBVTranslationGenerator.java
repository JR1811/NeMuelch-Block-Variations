package net.shirojr.nemuelch.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.shirojr.nemuelch.block.util.VariationHolder;
import net.shirojr.nemuelch.init.NBVBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NBVTranslationGenerator extends FabricLanguageProvider {
    public NBVTranslationGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        builder.add("itemGroup.nbv.block_variations", "NeMuelch Block Variations (NBV)");

        for (VariationHolder variationHolder : NBVBlocks.VARIATION_HOLDERS) {
            Identifier identifier = Registries.BLOCK.getId(variationHolder.getBlock());
            builder.add(variationHolder.getBlock(), cleanString(identifier, false));
        }
    }

    public static String cleanString(@Nullable Identifier identifier, boolean reverse) {
        if (identifier == null) throw new NullPointerException("Not a valid Identifier for clean String Translation");
        List<String> input = List.of(identifier.getPath().split("/"));
        List<String> words = Arrays.asList(input.get(input.size() - 1).split("_"));
        return cleanMergedString(words, reverse);
    }

    public static String cleanMergedString(List<String> input, boolean reverse) {
        List<String> words = new ArrayList<>(input);
        if (reverse) Collections.reverse(words);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            char capitalized = Character.toUpperCase(word.charAt(0));
            output.append(capitalized).append(word.substring(1));
            if (i < words.size() - 1) {
                output.append(" ");
            }
        }
        return output.toString();
    }
}
