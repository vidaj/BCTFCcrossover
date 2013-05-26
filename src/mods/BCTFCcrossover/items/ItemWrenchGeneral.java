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
package mods.BCTFCcrossover.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.ItemWrench;
import buildcraft.core.utils.StringUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWrenchGeneral extends ItemWrench {
	public String iconName;
	
	public ItemWrenchGeneral(int i) {
		super(i);
		setCreativeTab(CreativeTabBuildCraft.tabBuildCraft);
		maxStackSize = 1;
	}
	
	@Override
	public void wrenchUsed(EntityPlayer player, int x, int y, int z) {
		if(!player.capabilities.isCreativeMode) {
			ItemStack stack = player.inventory.getCurrentItem();
			stack.damageItem(1, player);
			if(stack.getItemDamage() == stack.getMaxDamage() || stack.getItemDamage() == 0) {
				player.renderBrokenItemStack(stack);
				player.worldObj.playSoundAtEntity(player, "random.break", 0.8F, 0.8F + player.worldObj.rand.nextFloat() * 0.4F);
				player.destroyCurrentEquippedItem();
			}
		}
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		iconName = par1Str;
		setMaxDmg(par1Str);
		return super.setUnlocalizedName(par1Str);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registerer) {
		this.itemIcon = registerer.registerIcon("BCTFCcrossover:" + iconName);
	}
	
	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return StringUtils.localize(getUnlocalizedName(itemstack));
	}
	
	private void setMaxDmg(String s) {
		if(s.equals("BismuthWrenchItem")) this.setMaxDamage(70);
		else if(s.equals("TinWrenchItem")) this.setMaxDamage(65);
		else if(s.equals("ZincWrenchItem")) this.setMaxDamage(60);
		else if(s.equals("CopperWrenchItem"))this.setMaxDamage(150);
		else if(s.equals("BismuthBronzeWrenchItem")) this.setMaxDamage(230);
		else if(s.equals("BlackBronzeWrenchItem")) this.setMaxDamage(240);
		else if(s.equals("BronzeWrenchItem")) this.setMaxDamage(260);
		else if(s.equals("RoseGoldWrenchItem")) this.setMaxDamage(210);
		else if(s.equals("WroughtIronWrenchItem")) this.setMaxDamage(510);
		else if(s.equals("SteelWrenchItem")) this.setMaxDamage(700);
		else if(s.equals("BlackSteelWrenchItem")) this.setMaxDamage(8500);
		else if(s.equals("BlueSteelWrenchItem")) this.setMaxDamage(1200);
		else if(s.equals("RedSteelWrenchItem")) this.setMaxDamage(1200);
	}
}
