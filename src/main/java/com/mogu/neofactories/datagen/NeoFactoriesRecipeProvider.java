package com.mogu.neofactories.datagen;

import com.mogu.neofactories.NeoFactories;
import com.mogu.neofactories.blocks.NeoFactories_Block;
import com.mogu.neofactories.items.NeoFactories_Item;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class NeoFactoriesRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public NeoFactoriesRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput){

        List<ItemLike> TERMIUM_SMELTABLES = List.of(NeoFactories_Block.TERMIUM_ORE);

        //ShapedRecipeBuilder.shaped(RecipeCategory.MISC, NeoFactories_Block.TERMIUM_BLOCK.get())
                //.pattern("TTT")
                //.pattern("TTT")
                //.pattern("TTT")
                //.define('T', NeoFactories_Item.TERMIUM.get())
                //.unlockedBy("has_termium",has(NeoFactories_Item.TERMIUM)).save(recipeOutput);

        //ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,NeoFactories_Item.TERMIUM.get(),9)
                //.requires(NeoFactories_Block.TERMIUM_BLOCK)
                //.unlockedBy("has_termium_block",has(NeoFactories_Block.TERMIUM_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, TERMIUM_SMELTABLES, RecipeCategory.MISC, NeoFactories_Item.TERMIUM.get(), 0.25f, 200, "termium");
        oreBlasting(recipeOutput, TERMIUM_SMELTABLES, RecipeCategory.MISC, NeoFactories_Item.TERMIUM.get(), 0.25f, 100, "termium");

    }
    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult,
                                      float pExperience, int pCookingTIme, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult,
                                      float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(@NotNull RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.@NotNull Factory<T> factory,
                                                                       List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, NeoFactories.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}

