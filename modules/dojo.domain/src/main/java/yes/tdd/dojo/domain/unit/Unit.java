package yes.tdd.dojo.domain.unit;

public class Unit {
    private final Double value;

    public Unit(Double value, UnitHub unit) {
        this.value = value / unit.formula();
    }

    public Double to(UnitHub unit) {
        return this.value * unit.formula();
    }
}
