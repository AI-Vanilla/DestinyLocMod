
package net.destiny.destinyloc.world.biome;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

import net.destiny.destinyloc.entity.EuropaZombieEntity;
import net.destiny.destinyloc.DestinyLocModElements;

@DestinyLocModElements.ModElement.Tag
public class EuropaBiome extends DestinyLocModElements.ModElement {
	public static Biome biome;
	public EuropaBiome(DestinyLocModElements instance) {
		super(instance, 23);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}
	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-16777216).setWaterColor(-2565928).setWaterFogColor(329011)
						.withSkyColor(-16777216).withFoliageColor(-2565928).withGrassColor(-2565928).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(Blocks.SNOW.getDefaultState(),
								Blocks.PACKED_ICE.getDefaultState(), Blocks.PACKED_ICE.getDefaultState())));
				biomeGenerationSettings.withStructure(StructureFeatures.STRONGHOLD);
				biomeGenerationSettings.withStructure(StructureFeatures.MINESHAFT);
				biomeGenerationSettings.withStructure(StructureFeatures.VILLAGE_SNOWY);
				biomeGenerationSettings.withStructure(StructureFeatures.MANSION);
				biomeGenerationSettings.withStructure(StructureFeatures.JUNGLE_PYRAMID);
				biomeGenerationSettings.withStructure(StructureFeatures.DESERT_PYRAMID);
				biomeGenerationSettings.withStructure(StructureFeatures.IGLOO);
				biomeGenerationSettings.withStructure(StructureFeatures.MONUMENT);
				biomeGenerationSettings.withStructure(StructureFeatures.SHIPWRECK);
				biomeGenerationSettings.withStructure(StructureFeatures.OCEAN_RUIN_COLD);
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG).withPlacement(Features.Placements.PATCH_PLACEMENT)
								.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 1))));
				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SNOW_GOLEM, 20, 3, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SKELETON, 20, 4, 4));
				mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EuropaZombieEntity.entity, 20, 4, 4));
				biome = new Biome.Builder().precipitation(Biome.RainType.SNOW).category(Biome.Category.ICY).depth(0.5f).scale(0.3f).temperature(0.1f)
						.downfall(0.7f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("destiny_loc:europa"));
			}
		}
	}
	@Override
	public void init(FMLCommonSetupEvent event) {
	}
}
