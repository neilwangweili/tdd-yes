package yes.tdd.dojo.domain.gildedrose;

public class AgedBrieItem extends Item {
    public AgedBrieItem(Item item) {
        super(item.name(), item.sellIn(), item.quality());
    }

    @Override
    public void updateQuality() {
        setSellIn(super.sellIn() - 1);
        setQuality(super.quality() + 1);
    }
}
