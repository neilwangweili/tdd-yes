package yes.tdd.dojo.domain.gildedrose;

public class Item {
    private final String name;
    private final int sellIn;
    private final int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
