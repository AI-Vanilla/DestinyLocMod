
package net.destiny.destinyloc.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.destiny.destinyloc.item.PrimeEngramItem;
import net.destiny.destinyloc.DestinyLocModElements;

@DestinyLocModElements.ModElement.Tag
public class DestinyLoCWeaponItemGroup extends DestinyLocModElements.ModElement {
	public DestinyLoCWeaponItemGroup(DestinyLocModElements instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdestiny_lo_c_weapon") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PrimeEngramItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
