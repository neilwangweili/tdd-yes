package yes.tdd.dojo.domain.gildedrose;

import java.util.Arrays;

public class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(Item::updateQuality);
    }
}
