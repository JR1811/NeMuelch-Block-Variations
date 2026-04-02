package net.shirojr.nemuelch;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.shirojr.nemuelch.datagen.*;

public class NBVDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();

		pack.addProvider(NBVTranslationGenerator::new);
		pack.addProvider(NBVModelGenerator::new);
		pack.addProvider(NBVRecipeGenerator::new);
		NBVLootTableGenerators.registerAll(pack);
		NBVTagGenerators.registerAll(pack);
	}
}
