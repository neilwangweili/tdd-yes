package yes.tdd.dojo.domain.unit;

import java.util.function.Function;

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
