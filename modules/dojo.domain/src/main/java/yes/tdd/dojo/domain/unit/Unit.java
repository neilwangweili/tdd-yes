package yes.tdd.dojo.domain.unit;

import java.util.function.Function;

public class Unit {
    private final Double value;

    public Unit(Double value, UnitHub unit) {
        this.value = unit.localToStandardFormula().apply(value);
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

        public Function<Double, Double> standardToLocalFormula() {
            return o -> o * magnification;
        }

        public Function<Double, Double> localToStandardFormula() {
            return o -> o / magnification;
        }
    }
}
