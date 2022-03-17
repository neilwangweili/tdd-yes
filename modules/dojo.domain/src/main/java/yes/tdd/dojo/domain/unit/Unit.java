package yes.tdd.dojo.domain.unit;

import java.util.Map;

public class Unit {
    private final Double value;

    private static final int CM = 100;
    private static final int DM = 10;
    private static final int M = 1;
    private static final Map<String, Integer> UNIT_MAP = Map.of(
        "cm", CM, "dm", DM, "m", M
    );

    public Unit(Double value, String unit) {
        this.value = value;
    }

    public Double to(String unit) {
        return this.value * UNIT_MAP.get(unit);
    }
}
