package com.herbseedicons;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.swing.ImageIcon;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

@Slf4j
public class HerbSeedOverlay extends WidgetItemOverlay
{
	final Map<String, Image> images = new HashMap<>();

    @Inject
    private HerbSeedOverlay()
    {
        this.showOnEquipment();
		this.showOnInventory();
		this.showOnBank();
		this.showOnInterfaces(WidgetID.SEED_BOX_GROUP_ID, WidgetID.SEED_VAULT_INVENTORY_GROUP_ID, WidgetID.SEED_VAULT_GROUP_ID);
    }

    @Override
    public void renderItemOverlay(final Graphics2D graphics, final int id , final WidgetItem itemWidget)
    {
        if (id >= 5291 && id <= 5304) {
			final Rectangle bounds = itemWidget.getCanvasBounds();
			final int quantity = Math.min(itemWidget.getQuantity(), 5);
			final Image iconImage = this.getReplacementIcon(id, quantity);

			if (iconImage == null) {
				System.out.println("Could not find replacement image for item ID: " + id + "_" + quantity);
			} else {
				graphics.drawImage(iconImage, (int)bounds.getX(), (int)bounds.getY(), null);
			}
        }
    }

	private Image getReplacementIcon(final int id, final int quantity) {
		final String key = id + "_" + quantity;

		if (!this.images.containsKey(key)) {
			final URL resourceUrl = HerbSeedIconsPlugin.class.getClassLoader().getResource(key + ".png");

			if (resourceUrl == null) {
				return null;
			} else {
				this.images.put(key, new ImageIcon(resourceUrl).getImage());
			}
		}

		return this.images.get(key);
	}
}
