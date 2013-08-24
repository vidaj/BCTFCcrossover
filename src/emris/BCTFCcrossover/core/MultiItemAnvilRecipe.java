package emris.BCTFCcrossover.core;

import net.minecraft.item.ItemStack;
import TFC.API.Crafting.AnvilRecipe;
import TFC.API.Crafting.AnvilReq;
import TFC.API.Enums.CraftingRuleEnum;

public class MultiItemAnvilRecipe extends AnvilRecipe {

	ItemStack result;
	
	public MultiItemAnvilRecipe(ItemStack in, ItemStack p, int cv, CraftingRuleEnum rule0, CraftingRuleEnum rule1, CraftingRuleEnum rule2, boolean flux, AnvilReq req, ItemStack result) {
		super(in, p, cv, rule0, rule1, rule2, flux, req, result);
		this.result = result;
	}

	@Override
	public ItemStack getCraftingResult() {
		return result.copy();
	}
}