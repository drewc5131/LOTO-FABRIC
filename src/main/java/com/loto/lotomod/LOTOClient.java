package com.loto.lotomod;
import com.loto.lotomod.mob.EntityOverlordMinion;
import com.loto.lotomod.mob.OverlordMinionRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;

public class LOTOClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(EntityOverlordMinion.class, (entityRenderDispatcher, context) -> new OverlordMinionRenderer(entityRenderDispatcher));
		
	}

}
