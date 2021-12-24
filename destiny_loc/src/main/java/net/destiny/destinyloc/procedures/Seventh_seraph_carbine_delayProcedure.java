package net.destiny.destinyloc.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.destiny.destinyloc.item.SeventhSeraphCarbineItem;
import net.destiny.destinyloc.DestinyLocMod;

import java.util.Map;

public class Seventh_seraph_carbine_delayProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency entity for procedure Seventh_seraph_carbine_delay!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(SeventhSeraphCarbineItem.block, (int) 8);
	}
}
