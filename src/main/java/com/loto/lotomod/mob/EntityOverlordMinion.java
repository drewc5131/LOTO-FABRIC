package com.loto.lotomod.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombiePigmanEntity;
import net.minecraft.entity.passive.AbstractTraderEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class EntityOverlordMinion extends HostileEntity {
	public EntityOverlordMinion(EntityType<? extends EntityOverlordMinion> type, World worldIn) {
		super(type, worldIn);
		setCustomName(Text.Serializer.fromJson("{\"text\":\"Overlord Minion\"}"));
	}

	protected void initGoals() {
		this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(8, new LookAroundGoal(this));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
		this.goalSelector.add(2, new OverlordMinionAttackGoal(this, 1.0D, false));
		this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
		this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(ZombiePigmanEntity.class));
		this.targetSelector.add(2, new FollowTargetGoal(this, PlayerEntity.class, true));
		this.targetSelector.add(3, new FollowTargetGoal(this, AbstractTraderEntity.class, false));
		this.targetSelector.add(3, new FollowTargetGoal(this, IronGolemEntity.class, true));
		this.targetSelector.add(5, new FollowTargetGoal(this, TurtleEntity.class, 10, true, false,
				TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
	}

	protected void initAttributes() {
		super.initAttributes();
		this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
		this.getAttributeInstance(EntityAttributes.ARMOR).setBaseValue(2.0D);
	}

	@Override
	public boolean isCustomNameVisible() {
		return true;
	}

}
