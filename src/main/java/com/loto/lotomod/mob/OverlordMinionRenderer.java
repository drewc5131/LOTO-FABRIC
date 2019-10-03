package com.loto.lotomod.mob;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

public class OverlordMinionRenderer<T extends MobEntity, M extends OverlordMinionModel<T>>
		extends MobEntityRenderer<EntityOverlordMinion, OverlordMinionModel<EntityOverlordMinion>> {

	public OverlordMinionRenderer(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new OverlordMinionModel<>(), 1.0f);
	}

	@Override
	protected Identifier getTexture(EntityOverlordMinion var1) {
		return new Identifier("lotomod:textures/entity/overlordminion.png");
	}

}