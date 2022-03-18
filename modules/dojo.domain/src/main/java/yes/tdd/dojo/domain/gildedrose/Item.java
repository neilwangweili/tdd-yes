package yes.tdd.dojo.domain.gildedrose;

public class Item {
    private final String name;
    private int sellIn;
    private int quality;

    private static final Integer MAX_QUALITY = 50;
    private static final Integer MIN_QUALITY = 0;
    private static final Integer SULFURAS_QUALITY = 80;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {
        if (name.equals("Aged Brie")) {
            --this.sellIn;
            ++this.quality;
            if (this.quality > MAX_QUALITY) this.quality = MAX_QUALITY;
        } else if (name.equals("Sulfuras, Hand of Ragnaros")) {
            --this.sellIn;
            this.quality = SULFURAS_QUALITY;
        } else {
            --this.sellIn;
            if (this.sellIn >= MIN_QUALITY) --this.quality;
            else this.quality = this.quality - 2;
            if (this.quality < MIN_QUALITY) this.quality = MIN_QUALITY;
        }
    }
}
