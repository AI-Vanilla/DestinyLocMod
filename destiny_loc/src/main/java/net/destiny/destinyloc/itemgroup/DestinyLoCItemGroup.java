
package net.destiny.destinyloc.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.destiny.destinyloc.item.ExoticEngramItem;
import net.destiny.destinyloc.DestinyLocModElements;

@DestinyLocModElements.ModElement.Tag
public class DestinyLoCItemGroup extends DestinyLocModElements.ModElement {
	public DestinyLoCItemGroup(DestinyLocModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdestiny_lo_c") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ExoticEngramItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
