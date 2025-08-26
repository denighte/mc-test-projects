package com.unknown.patch.mixin;

import com.unknown.patch.ModPatchMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Boat.class)
public abstract class BoatMixin extends Entity {

    @Unique
    private static final EntityDataAccessor<Integer> DATA_ID_SINK_TIME = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);
    @Unique
    private float sinkMultiplier;

    @Unique
    private int getSinkTime() {
        return this.entityData.get(DATA_ID_SINK_TIME);
    }

    @Unique
    private void setSinkTime(int ticks) {
        this.entityData.set(DATA_ID_SINK_TIME, ticks);
    }

    @Unique
    private boolean isSinking;

    @Shadow
    private float bubbleAngle;

    @Shadow
    private float bubbleAngleO;

    @Shadow
    protected abstract Boat.Status getStatus();

    @Shadow
    protected abstract void destroy(DamageSource damageSource);

    public BoatMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Inject(at = @At(value = "TAIL"), method = "defineSynchedData")
    protected void defineAdditionalSynchedData(CallbackInfo info) {
        this.entityData.define(DATA_ID_SINK_TIME, 0);
    }

    @Inject(at = @At(value = "HEAD"), method = "tickBubbleColumn", cancellable = true)
    protected void tickBubbleColumnSinkingAware(CallbackInfo info) {
        if (this.getSinkTime() > 0) {
            info.cancel();
        }
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat;tickBubbleColumn()V"), method = "tick")
    private void tickSinking(CallbackInfo info) {
        if (!getType().is(ModPatchMod.SINKABLE_BOATS)) {
            return;
        }

        int i = this.getSinkTime();
        if (this.level().isClientSide) {
            if (i > 0) {
                this.sinkMultiplier += 0.02F;
            } else {
                this.sinkMultiplier -= 0.1F;
            }
            this.sinkMultiplier = Mth.clamp(this.sinkMultiplier, 0.0F, 1.0F);
            this.bubbleAngleO = this.bubbleAngle;
            this.bubbleAngle = 10.0F * (float)Math.sin((double)(0.5F * (float)this.level().getGameTime())) * this.sinkMultiplier;
        }  else if (this.shouldSink() && this.getStatus() == Boat.Status.IN_WATER) {
            if (!isSinking) {
                isSinking = true;
                this.setSinkTime(90);
            } else if (i <= 0) {
                this.level().playSound(this, BlockPos.containing(this.position()), SoundEvents.PLAYER_SPLASH_HIGH_SPEED, this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat());
                this.kill();
                this.destroy(new DamageSources(this.level().registryAccess()).drown());
            } else {
                this.setSinkTime(--i);
                for(int j = 0; j < 2; ++j) {
                    ServerLevel serverlevel = (ServerLevel)this.level();
                    BlockPos pos = blockPosition();
                    serverlevel.sendParticles(ParticleTypes.SPLASH, (double)pos.getX() + serverlevel.random.nextDouble(), (double)(pos.getY() + 1), (double)pos.getZ() + serverlevel.random.nextDouble(), 1, 0.0D, 0.0D, 0.0D, 1.0D);
                    serverlevel.sendParticles(ParticleTypes.BUBBLE, (double)pos.getX() + serverlevel.random.nextDouble(), (double)(pos.getY() + 1), (double)pos.getZ() + serverlevel.random.nextDouble(), 1, 0.0D, 0.01D, 0.0D, 0.2D);
                }
            }
        } else {
            isSinking = false;
            this.setSinkTime(0);
        }
    }

    @Unique
    boolean shouldSink() {
        return this.level().getBiome(blockPosition()).is(ModPatchMod.SINKS_BOATS);
    }
}
