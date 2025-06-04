package org.github.shiftjis.employment.mixin.client;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.Box;
import org.github.shiftjis.employment.EmploymentMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {
    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity)(Object)this;
        Box searchArea = livingEntity.getBoundingBox().expand(1.0);
        for (ItemEntity ignored : livingEntity.getWorld().getEntitiesByType(TypeFilter.instanceOf(ItemEntity.class), searchArea, itemEntity -> itemEntity.getStack().getItem() == EmploymentMod.JOB_APPLICATION_ITEM)) {
            livingEntity.damage(livingEntity.getDamageSources().magic(), Float.MAX_VALUE);
        }
    }
}
