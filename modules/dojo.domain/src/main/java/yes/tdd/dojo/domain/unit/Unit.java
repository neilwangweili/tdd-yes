package yes.tdd.dojo.domain.unit;

public class Unit {
    private final Double value;

    public Unit(Double value, UnitHub unit) {
        this.value = unit.localToStandardFormula().apply(value);
    }

    public Double to(UnitHub unit) {
        return unit.standardToLocalFormula().apply(this.value);
    }
}
