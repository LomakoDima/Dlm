package ru.dimalab.dlm.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class LightningStrikerEnchantment extends Enchantment {
    public LightningStrikerEnchantment(Rarity pRarity, EnchantmentType type, EquipmentSlotType... pApplicableSlots) {
        super(pRarity, type, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if(!pAttacker.level.isClientSide()) {
            ServerWorld world = ((ServerWorld) pAttacker.level);
            BlockPos position = pTarget.blockPosition();

            if(pLevel == 1) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }

            if(pLevel == 2) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, position,
                        SpawnReason.TRIGGERED, true, true);
            }
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
    }

