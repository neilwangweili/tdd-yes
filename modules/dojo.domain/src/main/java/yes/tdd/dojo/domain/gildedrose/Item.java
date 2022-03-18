package yes.tdd.dojo.domain.gildedrose;

public class Item {
    private final String name;
    private int sellIn;
    private int quality;

    private static final Integer MAX_QUALITY = 50;
    private static final Integer MIN_QUALITY = 0;

    protected static Item newInstance(Item item) {
        if (item.is("Aged Brie")) return new AgedBrieItem(item);
        if (item.is("Sulfuras, Hand of Ragnaros")) return new SulfurasItem(item);
        if (item.is("Backstage passes to a TAFKAL80ETC concert")) return new BackstageItem(item);
        return new Item(item);
    }

    public Item(Item item) {
        this(item.name(), item.sellIn(), item.quality());
    }

    public static Item newInstance(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    private Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        passOneDay();
        update();
        fixQuality();
    }

    protected void update() {
        if (this.sellIn >= MIN_QUALITY) qualityDownOne();
        else qualityDownTwo();
    }

    private String name() {
        return name;
    }

    protected int sellIn() {
        return sellIn;
    }

    protected int quality() {
        return quality;
    }

    protected void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    protected void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    private void qualityDownTwo() {
        this.setQuality(quality() - 2);
    }

    private void qualityDownOne() {
        this.setQuality(quality() - 1);
    }

    protected void qualityUpOne() {
        this.setQuality(quality() + 1);
    }

    protected void qualityUpTwo() {
        this.setQuality(quality() + 2);
    }

    protected void qualityUpThree() {
        final int threeQuality = 3;
        this.setQuality(quality() + threeQuality);
    }

    protected void fixQuality() {
        if (this.quality > MAX_QUALITY) this.quality = MAX_QUALITY;
        if (this.quality < MIN_QUALITY) this.quality = MIN_QUALITY;
    }

    protected void passOneDay() {
        setSellIn(sellIn() - 1);
    }

    public boolean is(String name) {
        return name.equals(this.name);
    }
}
