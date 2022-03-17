package yes.tdd.dojo.domain.unit;

public class Unit {
    private final Double value;

    private static final int CM = 100;

    public Unit(Double value, String unit) {
        this.value = value;
    }

    public Double to(String unit) {
        return value * CM;
    }
}
