package com.loto.lotomod;

import com.loto.lotomod.items.ItemMythicalDiamond;
import com.loto.lotomod.items.ItemMythicalPickaxe;
import com.loto.lotomod.items.LOTOItemTier;
import com.loto.lotomod.mob.EntityOverlordMinion;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.Biome.SpawnEntry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;

public class LOTOMod implements ModInitializer {

	public static ItemMythicalPickaxe MYTHICAL_PICKAXE = new ItemMythicalPickaxe(LOTOItemTier.MYTHICAL, 2, 4f,
			new Item.Settings());
	public static ItemMythicalDiamond MYTHICAL_DIAMOND = new ItemMythicalDiamond(new Item.Settings());

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("tutorial", "general"))
			.icon(() -> new ItemStack(MYTHICAL_PICKAXE)).appendItems(stacks -> {
				stacks.add(new ItemStack(MYTHICAL_PICKAXE));
				stacks.add(new ItemStack(MYTHICAL_DIAMOND));
			}).build();

	public static final EntityType<EntityOverlordMinion> OVERLORD_MINION = Registry.register(Registry.ENTITY_TYPE,
			new Identifier("lotomod", "overlord_minion"),
			FabricEntityTypeBuilder.create(EntityCategory.MONSTER, EntityOverlordMinion::new)
					.size(EntityDimensions.fixed(1, 2)).build());

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("lotomod", "mythicalpickaxe"), MYTHICAL_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("lotomod", "mythicaldiamond"), MYTHICAL_DIAMOND);
		registerEntitySpawn(OVERLORD_MINION, 95, 2, 4, Biomes.NETHER, Biomes.FOREST, Biomes.DEFAULT, Biomes.JUNGLE,
				Biomes.TAIGA, Biomes.PLAINS, Biomes.MOUNTAINS, Biomes.SAVANNA, Biomes.DESERT, Biomes.STONE_SHORE);
	}

	public static void registerEntitySpawn(EntityType<? extends LivingEntity> entityType, int weight, int minGroupCount,
			int maxGroupCount, Biome... biomes) {
		for (Biome biome : biomes) {
			biome.getEntitySpawnList(EntityCategory.MONSTER)
					.add(new SpawnEntry(entityType, weight, minGroupCount, maxGroupCount));
		}
	}
}
