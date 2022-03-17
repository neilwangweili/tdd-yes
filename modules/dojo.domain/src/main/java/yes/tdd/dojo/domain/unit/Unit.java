package yes.tdd.dojo.domain.unit;

public class Unit {
    private final Double value;

    private static final int CM = 100;
    private static final int DM = 10;
    private static final int M = 1;

    public Unit(Double value, String unit) {
        this.value = value;
    }

    public Double to(String unit) {
        if (unit.equals("cm")) return value * CM;
        if (unit.equals("dm")) return value * DM;
        return value * M;
    }
}
