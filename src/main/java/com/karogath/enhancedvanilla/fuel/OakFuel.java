
package com.karogath.enhancedvanilla.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import com.karogath.enhancedvanilla.block.OakTanBarkBlock;
import com.karogath.enhancedvanilla.EnhancedVanillaElements;

@EnhancedVanillaElements.ModElement.Tag
public class OakFuel extends EnhancedVanillaElements.ModElement {
	public OakFuel(EnhancedVanillaElements instance) {
		super(instance, 189);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(OakTanBarkBlock.block, (int) (1)).getItem())
			event.setBurnTime(1600);
	}
}
