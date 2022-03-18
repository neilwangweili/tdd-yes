package yes.tdd.dojo.domain.gildedrose;

public class AgedBrieItem extends Item {
    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        qualityUpOne();
    }
}
