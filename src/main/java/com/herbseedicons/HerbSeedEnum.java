package com.herbseedicons;

import lombok.Getter;
import lombok.ToString;
import net.runelite.api.ItemID;

@Getter
@ToString
public enum HerbSeedEnum
{
    GUAM_SEEDS(ItemID.GUAM_SEED),
    MARRENTILL_SEEDS(ItemID.MARRENTILL_SEED),
    TARROMIN_SEEDS(ItemID.TARROMIN_SEED),
    HARRALANDER_SEEDS(ItemID.HARRALANDER_SEED),
    RANARR_SEEDS(ItemID.RANARR_SEED),
    TOADFLAX_SEEDS(ItemID.TOADFLAX_SEED),
    IRIT_SEEDS(ItemID.IRIT_SEED),
    AVANTOE_SEEDS(ItemID.AVANTOE_SEED),
    KWUARM_SEEDS(ItemID.KWUARM_SEED),
    SNAPDRAGON_SEEDS(ItemID.SNAPDRAGON_SEED),
    CADANTINE_SEEDS(ItemID.CADANTINE_SEED),
    LANTADYME_SEEDS(ItemID.LANTADYME_SEED),
    DWARF_WEED_SEEDS(ItemID.DWARF_WEED_SEED),
    TORSTOL_SEEDS(ItemID.TORSTOL_SEED);

    private final int id;

    HerbSeedEnum(final int id) {
        this.id = id;
    }

    public static boolean has(final int id) {
        for (HerbSeedEnum seed : HerbSeedEnum.values()) {
            if (seed.id == id) {
                return true;
            }
        }

        return false;
    }
}
