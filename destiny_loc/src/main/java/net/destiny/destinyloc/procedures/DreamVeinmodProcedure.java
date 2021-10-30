package net.destiny.destinyloc.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.destiny.destinyloc.potion.NightmareResistantPotionEffect;
import net.destiny.destinyloc.item.DREAMVEINItem;
import net.destiny.destinyloc.DestinyLocMod;

import java.util.Map;

public class DreamVeinmodProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency entity for procedure DreamVeinmod!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((DREAMVEINItem.helmet == ((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
				: ItemStack.EMPTY).getItem())) {
			if ((DREAMVEINItem.body == ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
					: ItemStack.EMPTY).getItem())) {
				if ((DREAMVEINItem.legs == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
						: ItemStack.EMPTY).getItem())) {
					if ((DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY).getItem())) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 3));
					} else {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 2));
					}
				} else {
					if ((DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY).getItem())) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 2));
					} else {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 1));
					}
				}
			} else {
				if ((DREAMVEINItem.legs == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
						: ItemStack.EMPTY).getItem())) {
					if ((DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY).getItem())) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 2));
					} else {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 1));
					}
				} else {
					if ((DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY).getItem())) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 1));
					} else {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 0));
					}
				}
			}
		} else {
			if ((DREAMVEINItem.body == ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
					: ItemStack.EMPTY).getItem())) {
				if ((DREAMVEINItem.legs == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
						: ItemStack.EMPTY).getItem())) {
					if ((DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY).getItem())) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 2));
					} else {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 1));
					}
				} else {
					if ((DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY).getItem())) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 1));
					} else {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 0));
					}
				}
			} else {
				if ((DREAMVEINItem.legs == ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
						: ItemStack.EMPTY).getItem())) {
					if ((DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY).getItem())) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 1));
					} else {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 0));
					}
				} else {
					if ((DREAMVEINItem.boots == ((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY).getItem())) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(NightmareResistantPotionEffect.potion, (int) 60, (int) 0));
					}
				}
			}
		}
	}
}
