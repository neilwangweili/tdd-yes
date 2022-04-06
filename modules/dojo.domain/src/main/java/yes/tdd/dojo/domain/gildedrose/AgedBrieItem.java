package yes.tdd.dojo.domain.gildedrose;

public final class AgedBrieItem extends Item {
    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    protected void update() {
        qualityUpOne();
    }
}
