package com.loto.lotomod.mob;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class OverlordMinionAttackGoal extends MeleeAttackGoal {
	private final EntityOverlordMinion minion;
	private int raiseArmTicks;

	public OverlordMinionAttackGoal(EntityOverlordMinion minionIn, double speedIn, boolean longMemoryIn) {
		super(minionIn, speedIn, longMemoryIn);
		this.minion = minionIn;
	}

	public void start() {
		super.start();
		this.raiseArmTicks = 0;
	}

	public void stop() {
		super.stop();
		this.minion.setAttacking(false);
	}

	public void tick() {
		super.tick();
		++this.raiseArmTicks;
		if (this.raiseArmTicks >= 5 && this.ticksUntilAttack < 10) {
			this.minion.setAttacking(true);
		} else {
			this.minion.setAttacking(false);
		}

	}
}