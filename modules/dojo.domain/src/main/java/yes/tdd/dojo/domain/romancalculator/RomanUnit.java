package yes.tdd.dojo.domain.romancalculator;

import java.util.List;

public enum RomanUnit {
    U(Integer.MAX_VALUE, Integer.MAX_VALUE),
    M(1000, Integer.MAX_VALUE),
    D(500, 1),
    C(100, 3),
    L(50, 1),
    X(10, 3),
    V(5, 1),
    I(1, 3),
    N(0, 0);

    private final int value;
    private final int maxAppearTime;

    RomanUnit(int value, int maxAppearTime) {
        this.value = value;
        this.maxAppearTime = maxAppearTime;
    }

    public RomanUnit findUpper() {
        int index = List.of(values()).indexOf(this);
        return values()[index - 1];
    }

    public RomanUnit findLower() {
        int index = List.of(values()).indexOf(this);
        return values()[index + 1];
    }

    public int value() {
        return value;
    }

    public int maxAppearTime() {
        return maxAppearTime;
    }
}
