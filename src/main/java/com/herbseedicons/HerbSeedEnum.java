package com.herbseedicons;

import lombok.Getter;
import lombok.ToString;
import net.runelite.api.ItemID;

@Getter
@ToString
public enum HerbSeedEnum
{
    IRIT_SEEDS(ItemID.IRIT_SEED),
    TARROMIN_SEEDS(ItemID.TARROMIN_SEED);

    private final int id;

    HerbSeedEnum(final int id) {
        this.id = id;
    }

    static HerbSeedEnum getIconOverride(final int id) {
        for (HerbSeedEnum seed : HerbSeedEnum.values()) {
            if (seed.id == id) {
                return seed;
            }
        }

        return null;
    }
}
