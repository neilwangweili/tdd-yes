package yes.tdd.dojo.domain.unit;

import java.util.function.Function;

public final class Unit {
    private final Double value;

    private Unit(Double value, UnitHub unit) {
        this.value = unit.localToStandardFormula().apply(value);
    }

    public static Unit of(Double value, UnitHub unit) {
        return new Unit(value, unit);
    }

    public Double to(UnitHub unit) {
        return unit.standardToLocalFormula().apply(this.value);
    }

    public enum UnitHub {
        CM(100), DM(10), M(1);

        private final Integer magnification;

        UnitHub(Integer magnification) {
            this.magnification = magnification;
        }

        private Function<Double, Double> standardToLocalFormula() {
            return o -> o * magnification;
        }

        private Function<Double, Double> localToStandardFormula() {
            return o -> o / magnification;
        }
    }
}
