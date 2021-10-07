package net.destiny.destinyloc.procedures;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.destiny.destinyloc.DestinyLocMod;

import java.util.Map;
import java.util.Collections;

public class TPinitialbaseProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency entity for procedure TPinitialbase!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate((-321), 64, 265);
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation((-321), 64, 265, _ent.rotationYaw, _ent.rotationPitch,
						Collections.emptySet());
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
