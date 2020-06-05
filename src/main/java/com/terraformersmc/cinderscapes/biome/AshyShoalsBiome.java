package com.terraformersmc.cinderscapes.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.mixinterface.AshyBiome;
import com.terraformersmc.cinderscapes.mixinterface.FogDensityBiome;
import com.terraformersmc.cinderscapes.surfacebuilder.config.EmptySurfaceConfig;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;

/**
 * @author <Wtoll> Will Toll on 2020-05-23
 * @project Cinderscapes
 */
public class AshyShoalsBiome extends Biome implements AshyBiome, FogDensityBiome {
    public AshyShoalsBiome() {
        super(new Settings()
                .configureSurfaceBuilder(CinderscapesSurfaces.ASHY_SHOALS, new EmptySurfaceConfig())
                .precipitation(Precipitation.NONE)
                .category(Category.NETHER)
                .depth(0.1F)
                .scale(0.2F)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4159204)
                        .waterFogColor(4341314)
                        .fogColor(0x363636)
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.ASH, 0.00625F))
                        .loopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .build())
                .parent(null)
                .noises(ImmutableList.of(new MixedNoisePoint(-0.35F, 0.0F, 0.35F, 0.0F, 0.2F))));


        // REPLACE NETHERRACK
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.SOUL_SAND_REPLACE_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.SOUL_SOIL_REPLACE_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.NETHERRACK_REPLACE_BLOBS.configure(CinderscapesFeatures.GRAVEL_REPLACE_CONFIG).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 128))));

        // FEATURES
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, CinderscapesFeatures.DEAD_TREE.configure(FeatureConfig.DEFAULT).createDecoratedFeature(CinderscapesDecorators.COUNT_FLOOR.configure(new CountDecoratorConfig(10))));
        this.addFeature(GenerationStep.Feature.UNDERGROUND_DECORATION, Feature.BASALT_PILLAR.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(30, 0, 0, 128))));

    }

    public float fogMultiplier() {
        return 0.5f;
    }
}
