package ga.hallzmine.manaplus.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ProtectorEntity extends MonsterEntity {

    public ProtectorEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    //func_233666_p_ registerAttributes <3
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .func_233815_a_(Attributes.field_233818_a_, 60.0D)
                .func_233815_a_(Attributes.field_233821_d_, 0.25D)
                .func_233815_a_(Attributes.field_233823_f_, 15.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this,0.0D, true));
        this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 90.0F));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 15 + this.world.rand.nextInt(30);
    }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.AMBIENT_CAVE; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.BLOCK_STONE_BREAK; }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.BLOCK_STONE_BREAK; }

}