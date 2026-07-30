package net.shirojr.nbv.block.util;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

public interface VariationHolder {
    Variation getVariant();

    Block getBlock();

    Identifier getBaseModel();
}
