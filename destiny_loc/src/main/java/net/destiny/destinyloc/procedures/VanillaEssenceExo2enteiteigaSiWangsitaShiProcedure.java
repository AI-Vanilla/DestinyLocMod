package net.destiny.destinyloc.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.destiny.destinyloc.potion.CopyoftheduplicatePotionEffect;
import net.destiny.destinyloc.DestinyLocMod;

import java.util.Map;

public class VanillaEssenceExo2enteiteigaSiWangsitaShiProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency entity for procedure VanillaEssenceExo2enteiteigaSiWangsitaShi!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DestinyLocMod.LOGGER.warn("Failed to load dependency world for procedure VanillaEssenceExo2enteiteigaSiWangsitaShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent("The duplicate has been defeated!"), ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		if (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof LivingEntity)
			((LivingEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null))
					.addPotionEffect(new EffectInstance(CopyoftheduplicatePotionEffect.potion, (int) 400, (int) 1));
	}
}
