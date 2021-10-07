
package net.destiny.destinyloc.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.destiny.destinyloc.itemgroup.DestinyLoCItemGroup;
import net.destiny.destinyloc.DestinyLocModElements;

@DestinyLocModElements.ModElement.Tag
public class HeavygunpowderItem extends DestinyLocModElements.ModElement {
	@ObjectHolder("destiny_loc:heavygunpowder")
	public static final Item block = null;
	public HeavygunpowderItem(DestinyLocModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DestinyLoCItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("heavygunpowder");
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
			return 0F;
		}
	}
}
