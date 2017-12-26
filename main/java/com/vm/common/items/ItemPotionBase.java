package com.vm.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemPotionBase extends Item {

	Potion potion = null;
	int dur;
	int amp;
	
	public ItemPotionBase(Potion potion, int duration, int amp) {
		this.potion = potion;
		this.dur = duration;
		this.amp = amp;
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack Stack = playerIn.getHeldItem(handIn);
		playerIn.addPotionEffect(new PotionEffect(potion, this.dur, this.amp));
		Stack.shrink(1);
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
	
}
