/*
 * Copyright (c) 2020 The Cursed Legacy Team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package io.github.minecraftcursedlegacy.test;

import io.github.minecraftcursedlegacy.api.client.AtlasMap;
import io.github.minecraftcursedlegacy.api.recipe.Recipes;
import io.github.minecraftcursedlegacy.api.registry.Id;
import io.github.minecraftcursedlegacy.api.registry.Registries;
import io.github.minecraftcursedlegacy.api.registry.Translations;
//import io.github.minecraftcursedlegacy.api.registry.Translations;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.ItemType;
import net.minecraft.tile.Tile;

public class TexturesTest implements ModInitializer {
	private static ItemType item, alsoItem;

	@SuppressWarnings("deprecation")
	@Override
	public void onInitialize() {
		item = Registries.ITEM_TYPE.register(new Id("modid:item_texture"),
				id -> new BasicItem(id).setTexturePosition(2, 0).setName("exampleTextureItem"));
		AtlasMap.registerAtlas(item, "/assets/modid/bc/item_textures.png");

		// set with the 1.1.0 model discovery api which uses choco's 0.x api generated atlas impl under the hood
		alsoItem = Registries.ITEM_TYPE.register(new Id("modid:item_texture_too"), id -> new BasicItem(id).setName("exampleTextureItemAlso"));

		Recipes.addShapelessRecipe(new ItemInstance(item), Tile.WOOD);
		Recipes.addShapelessRecipe(new ItemInstance(alsoItem), item);

		Translations.addItemTranslation(item, "Example Item");
		Translations.addItemTranslation(alsoItem, "Example Item Too");
	}
}