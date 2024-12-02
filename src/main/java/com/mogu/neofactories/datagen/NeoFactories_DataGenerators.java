package com.mogu.neofactories.datagen;

import com.mogu.neofactories.NeoFactories;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = NeoFactories.MODID, bus = EventBusSubscriber.Bus.MOD)
public class NeoFactories_DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //ルートテーブル
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(NeoFactories_BlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        //レシピ
        generator.addProvider(event.includeServer(), new NeoFactories_RecipeProvider(packOutput, lookupProvider));

        //ブロックタグ
        BlockTagsProvider blockTagsProvider = new NeoFactories_BlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);

        //アイテムタグ
        generator.addProvider(event.includeServer(), new NeoFactories_ItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        //データマップ
        generator.addProvider(event.includeServer(), new NeoFactories_DataMapProvider(packOutput, lookupProvider));

        //アイテムモデル
        generator.addProvider(event.includeClient(), new NeoFactories_ItemModelProvider(packOutput, existingFileHelper));

        //ブロックモデル
        generator.addProvider(event.includeClient(), new NeoFactories_BlockStateProvider(packOutput, existingFileHelper));

        //言語
        generator.addProvider(event.includeClient(), new NeoFactories_jajpProvider(packOutput));
        generator.addProvider(event.includeClient(), new NeoFactories_enusProvider(packOutput));
    }
}
