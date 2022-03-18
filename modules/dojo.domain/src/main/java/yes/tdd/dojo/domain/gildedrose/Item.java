package yes.tdd.dojo.domain.gildedrose;

public class Item {
    private final String name;
    private int sellIn;
    private int quality;

    private static final Integer MAX_QUALITY = 50;
    private static final Integer MIN_QUALITY = 0;
    private static final Integer SULFURAS_QUALITY = 80;
    private static final Integer TEN_DAYS = 10;
    private static final Integer FIVE_DAYS = 5;

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
        } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (sellIn <= 0) {
                --this.sellIn;
                this.quality = 0;
            } else if (sellIn <= FIVE_DAYS) {
                --this.sellIn;
                final int threeQuality = 3;
                this.quality = this.quality + threeQuality;
            } else if (sellIn <= TEN_DAYS) {
                --this.sellIn;
                this.quality = this.quality + 2;
            } else {
                --this.sellIn;
                ++this.quality;
            }
            if (this.quality > MAX_QUALITY) this.quality = MAX_QUALITY;
        } else {
            --this.sellIn;
            if (this.sellIn >= MIN_QUALITY) --this.quality;
            else this.quality = this.quality - 2;
            if (this.quality < MIN_QUALITY) this.quality = MIN_QUALITY;
        }
    }
}
