package net.destiny.destinyloc.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;

import net.destiny.destinyloc.DestinyLocMod;

import java.util.Map;

public class LumnixChampionoftheGrassPlainsenteiteigaSiWangsitaShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency world for procedure LumnixChampionoftheGrassPlainsenteiteigaSiWangsitaShi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Primary target has been taken down!"), ChatType.SYSTEM,
						Util.DUMMY_UUID);
		}
	}
}
