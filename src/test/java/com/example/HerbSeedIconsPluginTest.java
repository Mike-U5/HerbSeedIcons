package com.example;

import com.herbseedicons.HerbSeedIconsPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class HerbSeedIconsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(HerbSeedIconsPlugin.class);
		RuneLite.main(args);
	}
}