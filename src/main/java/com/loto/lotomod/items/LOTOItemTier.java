package com.loto.lotomod.items;

import java.util.function.Supplier;

import com.loto.lotomod.LOTOMod;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum LOTOItemTier implements ToolMaterial {
	OVERLORD(5, 16542, 40.0F, 32.0F, 30, () -> {
		return Ingredient.ofItems(Items.QUARTZ); // Temporary probably
	}),

	MYTHICAL(5, 4000, 8.0F, 6.0F, 20, () -> {
		return Ingredient.ofItems(LOTOMod.MYTHICAL_DIAMOND);
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final Lazy<Ingredient> repairMaterial;

	private LOTOItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn,
			int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = new Lazy<>(repairMaterialIn);
	}

	public int getMaxUses() {
		return this.maxUses;
	}

	public float getEfficiency() {
		return this.efficiency;
	}

	public float getAttackDamage() {
		return this.attackDamage;
	}

	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public Ingredient getRepairMaterial() {
		return (Ingredient)this.repairMaterial.get();
	}

	@Override
	public int getDurability() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getMiningSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMiningLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public net.minecraft.recipe.Ingredient getRepairIngredient() {
		// TODO Auto-generated method stub
		return null;
	}

}