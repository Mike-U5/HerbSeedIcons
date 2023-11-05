package com.herbseedicons;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
		name = "Herb Seed Icons",
		description = "Herb Seed Icons",
		tags = {"seeds", "cosmetic", "inventory", "icon"}
)
public class HerbSeedIconsPlugin extends Plugin
{
	@Inject
	private HerbSeedOverlay overlay;
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private HerbSeedIconsPlugin config;

	@Override
	protected void startUp() {
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() {
		overlayManager.remove(overlay);
	}
}
