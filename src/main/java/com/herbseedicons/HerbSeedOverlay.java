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
import net.runelite.api.ItemID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

@Slf4j
public class HerbSeedOverlay extends WidgetItemOverlay
{
	final Map<String, Image> images = new HashMap<>();

    @Inject
    private HerbSeedOverlay()
    {
		this.showOnInventory();
		this.showOnBank();
		this.showOnInterfaces(
			//268, // INVENTORY WITH BANK PIN OPEN
			InterfaceID.SEED_BOX,
			InterfaceID.SEED_VAULT,
			InterfaceID.SEED_VAULT_INVENTORY,
			InterfaceID.POH_TREASURE_CHEST_INV,
			InterfaceID.GROUP_STORAGE,
			InterfaceID.GROUP_STORAGE_INVENTORY,
			InterfaceID.BANK,
			InterfaceID.BANK_INVENTORY,
			InterfaceID.BANK_PIN
		);
    }

    @Override
    public void renderItemOverlay(final Graphics2D graphics, final int id , final WidgetItem widget)
    {
        if (id >= ItemID.GUAM_SEED && id <= ItemID.TORSTOL_SEED) {
			final Rectangle bounds = widget.getCanvasBounds();
			final int quantity = Math.min(widget.getQuantity(), 5);
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
			}

			this.images.put(key, new ImageIcon(resourceUrl).getImage());
		}

		return this.images.get(key);
	}
}
