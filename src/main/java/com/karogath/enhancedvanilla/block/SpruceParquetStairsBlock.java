
package com.karogath.enhancedvanilla.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

import com.karogath.enhancedvanilla.EnhancedvanillaModElements;

@EnhancedvanillaModElements.ModElement.Tag
public class SpruceParquetStairsBlock extends EnhancedvanillaModElements.ModElement {
	@ObjectHolder("enhancedvanilla:spruce_parquet_stairs")
	public static final Block block = null;
	public SpruceParquetStairsBlock(EnhancedvanillaModElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK)).getDefaultState(), Block.Properties.create(Material.WOOD).sound(SoundType.WOOD)
					.hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(1).harvestTool(ToolType.AXE));
			setRegistryName("spruce_parquet_stairs");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
