package yes.tdd.dojo.domain.gildedrose;

public final class BackstageItem extends Item {
    private static final Integer TEN_DAYS = 10;
    private static final Integer FIVE_DAYS = 5;

    public BackstageItem(Item item) {
        super(item);
    }

    @Override
    protected void update() {
        if (sellIn() < 0) setQuality(0);
        else if (sellIn() < FIVE_DAYS) qualityUpThree();
        else if (sellIn() < TEN_DAYS) qualityUpTwo();
        else qualityUpOne();
    }
}
