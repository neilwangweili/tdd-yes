package yes.tdd.dojo.domain.unit;

import java.util.Map;

public class Unit {
    private final Double value;

    private static final int CM = 100;
    private static final int DM = 10;
    private static final int M = 1;
    private static final Map<String, Integer> FORMULA_MAP = Map.of(
        "cm", CM, "dm", DM, "m", M
    );

    public Unit(Double value, String unit) {
        this.value = value / FORMULA_MAP.get(unit);
    }

    public Double to(String unit) {
        return this.value * FORMULA_MAP.get(unit);
    }
}
