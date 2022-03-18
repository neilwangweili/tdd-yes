package yes.tdd.dojo.domain.gildedrose;

import java.util.*;
import java.util.stream.Collectors;

public class GildedRose {
    private final List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items.stream().map(Item::newInstance).collect(Collectors.toList());
    }

    public List<Item> items() {
        return new ArrayList<>(items);
    }

    public void updateQuality() {
        items.forEach(Item::updateQuality);
    }
}
