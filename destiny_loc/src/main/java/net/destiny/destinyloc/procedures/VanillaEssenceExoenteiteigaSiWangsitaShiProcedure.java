package net.destiny.destinyloc.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.destiny.destinyloc.DestinyLocMod;

import java.util.Map;

public class VanillaEssenceExoenteiteigaSiWangsitaShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency world for procedure VanillaEssenceExoenteiteigaSiWangsitaShi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency entity for procedure VanillaEssenceExoenteiteigaSiWangsitaShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("The duplicate has disappeared."), ChatType.SYSTEM,
							Util.DUMMY_UUID);
			}
		}
	}
}
