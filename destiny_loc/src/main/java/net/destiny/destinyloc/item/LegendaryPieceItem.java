
package net.destiny.destinyloc.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.destiny.destinyloc.itemgroup.DestinyLoCItemGroup;
import net.destiny.destinyloc.DestinyLocModElements;

import java.util.List;

@DestinyLocModElements.ModElement.Tag
public class LegendaryPieceItem extends DestinyLocModElements.ModElement {
	@ObjectHolder("destiny_loc:legendary_piece")
	public static final Item block = null;
	public LegendaryPieceItem(DestinyLocModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DestinyLoCItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC));
			setRegistryName("legendary_piece");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Piece of equipment that can be obtained by dismantling some equipment."));
		}
	}
}
