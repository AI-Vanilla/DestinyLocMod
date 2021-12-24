package net.destiny.destinyloc.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.destiny.destinyloc.item.DREAMVEINItem;
import net.destiny.destinyloc.DestinyLocMod;

import java.util.Map;

public class Hit_player_nightmare_arrowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency entity for procedure Hit_player_nightmare_arrow!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (DREAMVEINItem.helmet == ((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD)
				: ItemStack.EMPTY).getItem()) {
			if (DREAMVEINItem.body == ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
					: ItemStack.EMPTY).getItem()) {
				if (DREAMVEINItem.legs == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS)
						: ItemStack.EMPTY).getItem()) {
					if (DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
							: ItemStack.EMPTY).getItem()) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 6);
					} else {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 12);
					}
				} else {
					if (DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
							: ItemStack.EMPTY).getItem()) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 12);
					} else {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
					}
				}
			} else {
				if (DREAMVEINItem.legs == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS)
						: ItemStack.EMPTY).getItem()) {
					if (DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
							: ItemStack.EMPTY).getItem()) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 12);
					} else {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
					}
				} else {
					if (DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
							: ItemStack.EMPTY).getItem()) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
					} else {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 50);
					}
				}
			}
		} else {
			if (DREAMVEINItem.body == ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
					: ItemStack.EMPTY).getItem()) {
				if (DREAMVEINItem.legs == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS)
						: ItemStack.EMPTY).getItem()) {
					if (DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
							: ItemStack.EMPTY).getItem()) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 12);
					} else {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
					}
				} else {
					if (DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
							: ItemStack.EMPTY).getItem()) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
					} else {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 50);
					}
				}
			} else {
				if (DREAMVEINItem.legs == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS)
						: ItemStack.EMPTY).getItem()) {
					if (DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
							: ItemStack.EMPTY).getItem()) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
					} else {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 50);
					}
				} else {
					if (DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
							: ItemStack.EMPTY).getItem()) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 50);
					} else {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 100);
					}
				}
			}
		}
	}
}
