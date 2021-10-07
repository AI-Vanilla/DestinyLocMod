
package net.destiny.destinyloc.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.Blocks;

import net.destiny.destinyloc.itemgroup.DestinyLoCItemGroup;
import net.destiny.destinyloc.DestinyLocModElements;

import java.util.List;

@DestinyLocModElements.ModElement.Tag
public class Swordoffor2Item extends DestinyLocModElements.ModElement {
	@ObjectHolder("destiny_loc:swordoffor_2")
	public static final Item block = null;
	public Swordoffor2Item(DestinyLocModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 400;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.BONE_BLOCK));
			}
		}, 3, -1.5f, new Item.Properties().group(DestinyLoCItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Are you a demon?"));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("swordoffor_2"));
	}
}
