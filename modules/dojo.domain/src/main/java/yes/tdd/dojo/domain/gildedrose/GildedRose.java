package yes.tdd.dojo.domain.gildedrose;

import java.util.*;
import java.util.stream.Collectors;

public class GildedRose {
    private final List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items.stream().map(this::newInstance).collect(Collectors.toList());
    }

    public List<Item> items() {
        return new ArrayList<>(items);
    }

    private Item newInstance(Item item) {
        if (item.is("Aged Brie")) return new AgedBrieItem(item);
        return new Item(item);
    }

    public void updateQuality() {
        items.forEach(Item::updateQuality);
    }
}
