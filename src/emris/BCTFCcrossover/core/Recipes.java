/**
 *  Copyright (C) 2013  emris
 *  https://github.com/emris/BCTFCcrossover
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package emris.BCTFCcrossover.core;

import java.util.List;
import java.util.Random;

import emris.BCTFCcrossover.BCTFCcrossover;
import emris.BCTFCcrossover.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import TFC.TFCBlocks;
import TFC.TFCItems;
import TFC.API.Crafting.AnvilCraftingManagerTFC;
import TFC.API.Crafting.AnvilRecipe;
import TFC.API.Crafting.AnvilReq;
import TFC.API.Crafting.CraftingManagerTFC;
import TFC.API.Enums.CraftingRuleEnum;
import buildcraft.BuildCraftBuilders;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftFactory;
import buildcraft.BuildCraftSilicon;
import buildcraft.BuildCraftTransport;
import buildcraft.api.filler.FillerManager;
import buildcraft.api.recipes.AssemblyRecipe;
import buildcraft.builders.FillerFillAll;
import buildcraft.builders.FillerFillPyramid;
import buildcraft.builders.FillerFillStairs;
import buildcraft.builders.FillerFillWalls;
import buildcraft.builders.FillerFlattener;

public class Recipes {

	public static void loadRecipes() {
		// Scribing Table Recipes
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(Items.Plans, 1, 0), new Object[] { "# # #"," ### ","## ##"," ### ","# # #",Character.valueOf('#'), TFCItems.Ink});
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(Items.Plans, 1, 1), new Object[] { " # # "," ### ","  #  ","  #  ","  #  ",Character.valueOf('#'), TFCItems.Ink});
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(Items.Plans, 1, 2), new Object[] { "#####","##  #","# # #","#  ##","#####",Character.valueOf('#'), TFCItems.Ink});
		
		// ========Remove BC Gear Recipes================
		RemoveRecipe(new ItemStack(BuildCraftCore.stoneGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.woodenGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.ironGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.goldGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.diamondGearItem));
		
		// Anvil Recipes
		AnvilCraftingManagerTFC anvil = AnvilCraftingManagerTFC.getInstance();
		for(int i = 0; i < 5; i++) {
			Random R = new Random (192865717);
			int dam = i * 5;
			
			// Instead of Wood
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BismuthBronzeIngot), new ItemStack(Items.Plans, 1, 0),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BISMUTHBRONZE, new ItemStack(Items.Gears, 1, 0)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackBronzeIngot), new ItemStack(Items.Plans, 1, 0),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BLACKBRONZE, new ItemStack(Items.Gears, 1, 1)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BronzeIngot), new ItemStack(Items.Plans, 1, 0),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BRONZE, new ItemStack(Items.Gears, 1, 2)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.CopperIngot), new ItemStack(Items.Plans, 1, 0),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.COPPER, new ItemStack(Items.Gears, 1, 3)));
			// Instead of Stone
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.WroughtIronIngot), new ItemStack(Items.Plans, 1, 0),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.WROUGHTIRON, new ItemStack(Items.Gears, 1, 4)));
			// Instead of Iron
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SteelIngot), new ItemStack(Items.Plans, 1, 0),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.STEEL, new ItemStack(Items.Gears, 1, 5)));
			// Instead of Gold
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackSteelIngot), new ItemStack(Items.Plans, 1, 0),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BLACKSTEEL, new ItemStack(Items.Gears, 1, 6)));
			// Instead of Diamond
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlueSteelIngot), new ItemStack(Items.Plans, 1, 0),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BLUESTEEL, new ItemStack(Items.Gears, 1, 7)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RedSteelIngot), new ItemStack(Items.Plans, 1, 0),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.REDSTEEL, new ItemStack(Items.Gears, 1, 8)));
			
			// Wrench
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BismuthIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.BismuthWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.TinIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.TinWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.ZincIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.ZincWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.CopperIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.CopperWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BismuthBronzeIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.BismuthBronzeWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackBronzeIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.BlackBronzeWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BronzeIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.BronzeWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RoseGoldIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.RoseGoldWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.WroughtIronIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.BRONZE, new ItemStack(Items.WroughtIronWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SteelIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.WROUGHTIRON, new ItemStack(Items.SteelWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackSteelIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STEEL, new ItemStack(Items.BlackSteelWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlueSteelIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.BLACKSTEEL, new ItemStack(Items.BlueSteelWrenchItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RedSteelIngot), new ItemStack(Items.Plans, 1, 1),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.BLACKSTEEL, new ItemStack(Items.RedSteelWrenchItem, 1, dam)));
			
			// Anvil Pipe Frames
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.TinSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.PipeFrames, 8, 0)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.LeadSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 1)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.BronzeSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 2)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.WroughtIronSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.BRONZE, new ItemStack(Items.PipeFrames, 8, 3)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.SteelSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.WROUGHTIRON, new ItemStack(Items.PipeFrames, 8, 4)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.BlueSteelSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.BLACKSTEEL, new ItemStack(Items.PipeFrames, 8, 5)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.RedSteelSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.BLACKSTEEL, new ItemStack(Items.PipeFrames, 8, 6)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.BlackBronzeSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 7)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.RoseGoldSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.BlackSteelSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STEEL, new ItemStack(Items.PipeFrames, 8, 9)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.ZincSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.PipeFrames, 8, 10)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.CopperSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.PipeFrames, 8, 11)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.SilverSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 12)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.PlatinumSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STEEL, new ItemStack(Items.PipeFrames, 8, 13)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.SterlingSilverSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 14)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.BrassSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.PipeFrames, 8, 15)));
		}
		//Buckets
		Random R = new Random (192865717);
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.ZincSheet), new ItemStack(TFCItems.BucketPlan),20 + R.nextInt(55),CraftingRuleEnum.BENDLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.Buckets, 1, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SteelSheet), new ItemStack(TFCItems.BucketPlan),20 + R.nextInt(55),CraftingRuleEnum.BENDLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.WROUGHTIRON, new ItemStack(Items.Buckets, 1, 3)));


		// =================Transport Pipes========================
		// Tin replaces Wood
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsWood));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.TinPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameTin",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsCobblestone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsCobblestone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsStone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsStone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BronzePipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameBronze",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsIron
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsIron));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.WroughtIronPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameWroughtIron",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsGold
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsGold));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.SteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameSteel",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsDiamond
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsDiamond));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlueSteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameBlueSteel",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsEmerald
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsEmerald));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.RedSteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameRedSteel",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsVoid
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsVoid));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeItem, 1), new Object[] { "RG ", "GFG", " GR",
			Character.valueOf('F'), "pipeFrameBlackBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeItem, 1), new Object[] { " GR", "GFG", "RG ",
			Character.valueOf('F'), "pipeFrameBlackBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Item.redstone });
		// Replaces pipeItemsSandstone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsSandstone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.RoseGoldPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameRoseGold",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsObsidian
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsObsidian));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackSteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameBlackSteel",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsDaizuli
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsDaizuli));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.SterlingSilverPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameSterlingSilver",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsLapis
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsLapis));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BrassPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameBrass",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsQuartz
//		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsQuartz));
//		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.????PipeItem, 1), new Object[] { " G ", "GFG", " G ",
//			Character.valueOf('F'), "pipeFrame????",
//			Character.valueOf('G'), Block.thinGlass });
		
		// =================Structure Pipes========================
		// Replaces pipeStructureCobblestone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeStructureCobblestone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { " G ", "GFG", " GR",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { " G ", "GFG", "RG ",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { " GR", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { "RG ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });

		// =================Waterproof Pipes========================
		// Replaces pipeFluidsWood
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsWood));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.TinPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameTin",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsCobblestone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsCobblestone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsStone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsStone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BronzePipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsIron
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsIron));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.WroughtIronPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameWroughtIron",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsGold
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsGold));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.SteelPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameSteel",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsEmerald
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsEmerald));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.RedSteelPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameRedSteel",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsVoid
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsVoid));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeFluidsItem, 1), new Object[] { "RGW", "GFG", "WGR",
			Character.valueOf('F'), "pipeFrameBlackBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen",
			Character.valueOf('R'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeFluidsItem, 1), new Object[] { "WGR", "GFG", "RGW",
			Character.valueOf('F'), "pipeFrameBlackBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen",
			Character.valueOf('R'), Item.redstone });
		// Replaces pipeFluidsSandstone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsSandstone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.RoseGoldPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameRoseGold",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });

		// =================Power Pipes========================
		// Conductive Pipe value 8
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerCobblestone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.CopperPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameCopper",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// Conductive Pipe value 16
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerStone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.RoseGoldPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameRoseGold",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// Conductive Pipe value 32
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerWood));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameBlackBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// Conductive Pipe value 64
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerQuartz));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.WroughtIronPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameWroughtIron",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// Conductive Pipe value 256
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerGold));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.SteelPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameSteel",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// Conductive Pipe value 1024
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerDiamond));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.PlatinumPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFramePlatinum",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// ===================Engines=====================
		// Mechanical
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearBismuthBronze",
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearBlackBronze",
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearBronze",
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearCopper",
			Character.valueOf('P'), Block.pistonBase });
		// Steam
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneIgInCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearWroughtIron",
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneIgExCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearWroughtIron",
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneSedCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearWroughtIron",
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneMMCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearWroughtIron",
			Character.valueOf('P'), Block.pistonBase });
		// Combustion
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCItems.WroughtIronIngot,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearSteel",
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCItems.WroughtIronIngot,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearSteel",
			Character.valueOf('P'), Block.pistonBase });
		
		// ==================Machines==========================
		// AutoWorkbench
		if (BuildCraftFactory.allowMining) {
			RemoveRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] { " g ", "gwg", " g ",
				Character.valueOf('w'), Block.workbench,
				Character.valueOf('g'), "gearBismuthBronze" });
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] { " g ", "gwg", " g ",
				Character.valueOf('w'), Block.workbench,
				Character.valueOf('g'), "gearBlackBronze" });
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] { " g ", "gwg", " g ",
				Character.valueOf('w'), Block.workbench,
				Character.valueOf('g'), "gearBronze" });
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] { " g ", "gwg", " g ",
				Character.valueOf('w'), Block.workbench,
				Character.valueOf('g'), "gearCopper" });
			// Mining Well
			RemoveRecipe(new ItemStack(BuildCraftFactory.miningWellBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.miningWellBlock, 1), new Object[] { "ipi", "igi", "iki",
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('i'), TFCItems.SteelIngot,
				Character.valueOf('g'), "gearSteel",
				Character.valueOf('k'), TFCItems.SteelPick });
			// Quarry
			RemoveRecipe(new ItemStack(BuildCraftFactory.quarryBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.quarryBlock), new Object[] { "ipi", "gig", "dkd",
				Character.valueOf('i'), "gearSteel",
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('g'), "gearBlackSteel",
				Character.valueOf('d'), "gearBlueSteel",
				Character.valueOf('k'), TFCItems.BlueSteelPick });
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.quarryBlock), new Object[] { "ipi", "gig", "dkd",
				Character.valueOf('i'), "gearSteel",
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('g'), "gearBlackSteel",
				Character.valueOf('d'), "gearRedSteel",
				Character.valueOf('k'), TFCItems.RedSteelPick });
		} else {
			RemoveRecipe(new ItemStack(BuildCraftFactory.pumpBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.pumpBlock), new Object[] { "iri", "iTi", "gpg",
				Character.valueOf('r'), Item.redstone,
				Character.valueOf('i'), TFCItems.SteelIngot,
				Character.valueOf('T'), BuildCraftFactory.tankBlock,
				Character.valueOf('g'), "gearSteel",
				Character.valueOf('p'), Items.SteelPipeFluidsItem });
		}

		// Refinery
		RemoveRecipe(new ItemStack(BuildCraftFactory.refineryBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.refineryBlock), new Object[] { "   ", "RTR", "TGT",
			Character.valueOf('T'), BuildCraftFactory.tankBlock,
			Character.valueOf('G'), "gearBlueSteel",
			Character.valueOf('R'), Block.torchRedstoneActive });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.refineryBlock), new Object[] { "   ", "RTR", "TGT",
			Character.valueOf('T'), BuildCraftFactory.tankBlock,
			Character.valueOf('G'), "gearRedSteel",
			Character.valueOf('R'), Block.torchRedstoneActive });
		
		// Hopper
		if (!BuildCraftFactory.hopperDisabled) {
			RemoveRecipe(new ItemStack(BuildCraftFactory.hopperBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.hopperBlock), new Object[] { "ICI", "IGI", " I ",
				Character.valueOf('I'), TFCItems.WroughtIronIngot,
				Character.valueOf('C'), Block.chest,
				Character.valueOf('G'), "gearWroughtIron" });
		}
		
		// ==================Builders==========================
		// Filler
		RemoveRecipe(new ItemStack(BuildCraftBuilders.fillerBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.fillerBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), "gearBlackSteel",
			Character.valueOf('s'), Block.chest });
		// Builder
		RemoveRecipe(new ItemStack(BuildCraftBuilders.builderBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.builderBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), "gearBlueSteel",
			Character.valueOf('s'), Block.chest });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.builderBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), "gearRedSteel",
			Character.valueOf('s'), Block.chest });
		// Architect
		RemoveRecipe(new ItemStack(BuildCraftBuilders.architectBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.architectBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), "gearBlueSteel",
			Character.valueOf('s'), new ItemStack(BuildCraftBuilders.templateItem, 1) });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.architectBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), "gearRedSteel",
			Character.valueOf('s'), new ItemStack(BuildCraftBuilders.templateItem, 1) });
		// Library
		RemoveRecipe(new ItemStack(BuildCraftBuilders.libraryBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.libraryBlock, 1), new Object[] { "bbb", "bkb", "bbb",
			Character.valueOf('b'), new ItemStack(BuildCraftBuilders.blueprintItem),
			Character.valueOf('k'), Block.bookShelf });
		
		// ==================Filler Recipes======================
		for (int i = 0; i < 3; i++) {
			FillerManager.registry.addRecipe(new FillerFillAll(), new Object[] { "bbb", "bbb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgInBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFlattener(), new Object[] { "   ", "ggg", "bbb",
				Character.valueOf('g'), Block.glass,
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgInBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillWalls(), new Object[] { "bbb", "b b", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgInBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillPyramid(), new Object[] { "   ", " b ", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgInBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillStairs(), new Object[] { "  b", " bb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgInBrick, 1, i) });
		}
		for (int i = 0; i < 4; i++) {
			FillerManager.registry.addRecipe(new FillerFillAll(), new Object[] { "bbb", "bbb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgExBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFlattener(), new Object[] { "   ", "ggg", "bbb",
				Character.valueOf('g'), Block.glass,
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgExBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillWalls(), new Object[] { "bbb", "b b", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgExBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillPyramid(), new Object[] { "   ", " b ", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgExBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillStairs(), new Object[] { "  b", " bb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgExBrick, 1, i) });
		}
		for (int i = 0; i < 10; i++) {
			FillerManager.registry.addRecipe(new FillerFillAll(), new Object[] { "bbb", "bbb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneSedBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFlattener(), new Object[] { "   ", "ggg", "bbb",
				Character.valueOf('g'), Block.glass,
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneSedBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillWalls(), new Object[] { "bbb", "b b", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneSedBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillPyramid(), new Object[] { "   ", " b ", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneSedBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillStairs(), new Object[] { "  b", " bb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneSedBrick, 1, i) });
		}
		for (int i = 0; i < 6; i++) {
			FillerManager.registry.addRecipe(new FillerFillAll(), new Object[] { "bbb", "bbb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneMMBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFlattener(), new Object[] { "   ", "ggg", "bbb",
				Character.valueOf('g'), Block.glass,
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneMMBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillWalls(), new Object[] { "bbb", "b b", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneMMBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillPyramid(), new Object[] { "   ", " b ", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneMMBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillStairs(), new Object[] { "  b", " bb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneMMBrick, 1, i) });
		}
		
		// ==================Silicone==================
		RemoveRecipe(new ItemStack(BuildCraftSilicon.laserBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.laserBlock), new Object[] { "ORR", "DDR", "ORR",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('R'), Item.redstone,
			Character.valueOf('D'), new ItemStack(TFCItems.GemDiamond,1,2), });
		
		RemoveRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 0), new Object[] { "ORO", "ODO", "OGO",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('R'), Item.redstone,
			Character.valueOf('D'), new ItemStack(TFCItems.GemDiamond,1,2),
			Character.valueOf('G'), "gearBlueSteel", });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 0), new Object[] { "ORO", "ODO", "OGO",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('R'), Item.redstone,
			Character.valueOf('D'), new ItemStack(TFCItems.GemDiamond,1,2),
			Character.valueOf('G'), "gearRedSteel", });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 1), new Object[] { "OWO", "OCO", "ORO",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('W'), Block.workbench,
			Character.valueOf('C'), Block.chest,
			Character.valueOf('R'), new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 0), });
		
		// / REDSTONE CHIPSETS
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.WroughtIronIngot) }, 20000, new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 1)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.GoldIngot) }, 40000, new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 2)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.GemDiamond,1,2) }, 80000, new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 3)));
		// PULSATING CHIPSETS
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.GemEmerald,1,2) }, 40000, new ItemStack(BuildCraftSilicon.redstoneChipset, 2, 4)));
		
		// BC Wires
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.redPipeWire));
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.bluePipeWire));
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.greenPipeWire));
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.yellowPipeWire));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.redPipeWire, 8)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.bluePipeWire, 8)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 2), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.greenPipeWire, 8)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 11), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.yellowPipeWire, 8)));

		// ==========Latex==========
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LatexBowl, 1), new Object[] { "fff", "fff", " b ",
			Character.valueOf('f'), Block.blocksList[37],
			Character.valueOf('b'), Item.bowlEmpty });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.Buckets, 1, 0), new Object[] { " f ", "fff", " b ",
			Character.valueOf('f'), "bowlLatex",
			Character.valueOf('b'), TFCItems.WoodenBucketEmpty });
		
		// ==========Rubber==========
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.Rubber, 1, 15), new Object[] { "s", "b",
			Character.valueOf('s'), new ItemStack(TFCItems.Powder, 1, 3),
			Character.valueOf('b'), "bowlLatex" });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.Rubber, 4, 15), new Object[] { "s", "b",
			Character.valueOf('s'), new ItemStack(TFCItems.Powder, 1, 3),
			Character.valueOf('b'), "bucketLatex" });
		for(int i = 0; i < 16; i++) {
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.Rubber, 1, i), new Object[] { "g", "s", "b",
				Character.valueOf('g'), new ItemStack(Item.dyePowder, 1 , i),
				Character.valueOf('s'), new ItemStack(TFCItems.Powder, 1, 3),
				Character.valueOf('b'), "bowlLatex" });
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.Rubber, 4, i), new Object[] { "g", "s", "b",
				Character.valueOf('g'), new ItemStack(Item.dyePowder, 1 , i),
				Character.valueOf('s'), new ItemStack(TFCItems.Powder, 1, 3),
				Character.valueOf('b'), "bucketLatex" });
		}
		
		// ==========Things That make no sense...yet=============
		// Olivien as green dye. Not sure if this makes any sense
		Item[] tfcHammers = TFC.Core.Recipes.Hammers;
		for(int j = 0; j < tfcHammers.length; j++) {
			BCTFCcrossover.proxy.addShapelessRecipe(new ItemStack(Item.dyePowder, 4, 2), new Object[] {new ItemStack(TFCItems.OreChunk, 1, 33), new ItemStack(tfcHammers[j], 1, 32767)});
			BCTFCcrossover.proxy.addShapelessRecipe(new ItemStack(Item.dyePowder, 8, 2), new Object[] {new ItemStack(TFCItems.OreChunk, 1, 9), new ItemStack(tfcHammers[j], 1, 32767)});
			BCTFCcrossover.proxy.addShapelessRecipe(new ItemStack(Item.dyePowder, 4, 2), new Object[] {new ItemStack(TFCItems.SmallOreChunk, 1, 9), new ItemStack(tfcHammers[j], 1, 32767)});
		}
		
		// ===============Vanilla Recipes==================
		// Vanilla Pistons
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneIgInCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneIgExCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneSedCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneMMCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });

		// Bookshelf Recipe for Library
		for(int i = 0; i < 16; i++) {
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.bookShelf, 1), new Object[] { "ppp", "bbb", "ppp",
				Character.valueOf('p'), new ItemStack(TFCItems.SinglePlank,1,i),
				Character.valueOf('b'), Item.book });
		}
	}
	
	public static void RemoveRecipe(ItemStack resultItem) {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipes.size(); i++)
		{
			IRecipe tmpRecipe = recipes.get(i);
			if (tmpRecipe instanceof IRecipe) {
				IRecipe recipe = tmpRecipe;
				ItemStack recipeResult = recipe.getRecipeOutput();
				if (ItemStack.areItemStacksEqual(resultItem, recipeResult)) {
					recipes.remove(i--);
				}
			}
		}
	}
}