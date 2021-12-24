package net.destiny.destinyloc.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Util;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.block.Block;

import net.destiny.destinyloc.block.CryptSecurityBlock;
import net.destiny.destinyloc.DestinyLocMod;

import java.util.Map;

public class CryptSecurityburotukugapureyaniPoHuaisaretatokiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency world for procedure CryptSecurityburotukugapureyaniPoHuaisaretatoki!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency x for procedure CryptSecurityburotukugapureyaniPoHuaisaretatoki!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency y for procedure CryptSecurityburotukugapureyaniPoHuaisaretatoki!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency z for procedure CryptSecurityburotukugapureyaniPoHuaisaretatoki!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		world.playEvent(2001, new BlockPos((int) x, (int) y, (int) z), Block.getStateId(CryptSecurityBlock.block.getDefaultState()));
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
					SoundCategory.NEUTRAL, (float) 5, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")),
					SoundCategory.NEUTRAL, (float) 5, (float) 1, false);
		}
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent("The security core has been shut down."), ChatType.SYSTEM,
						Util.DUMMY_UUID);
		}
	}
}
