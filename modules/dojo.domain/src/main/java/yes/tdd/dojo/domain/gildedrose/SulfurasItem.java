package yes.tdd.dojo.domain.gildedrose;

public class SulfurasItem extends Item {
    private static final Integer SULFURAS_QUALITY = 80;

    public SulfurasItem(Item item) {
        super(item);
    }

    @Override
    protected void update() {
        setQuality(SULFURAS_QUALITY);
    }

    @Override
    protected void fixQuality() {
    }

    @Override
    protected void passOneDay() {
    }
}
