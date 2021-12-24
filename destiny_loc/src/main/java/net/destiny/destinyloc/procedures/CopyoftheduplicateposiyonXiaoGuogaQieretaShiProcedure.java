package net.destiny.destinyloc.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.destiny.destinyloc.DestinyLocMod;

import java.util.Map;

public class CopyoftheduplicateposiyonXiaoGuogaQieretaShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency entity for procedure CopyoftheduplicateposiyonXiaoGuogaQieretaShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 400);
	}
}
