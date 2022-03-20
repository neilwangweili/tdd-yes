package yes.tdd.dojo.domain.romancalculator;

import static yes.tdd.dojo.domain.romancalculator.RomanUnit.*;

public final class RomanNumber {
    private int number;

    public static RomanNumber of(String number) {
        return new RomanNumber(number);
    }

    public RomanNumber add(RomanNumber that) {
        return new RomanNumber(this.getNumber() + that.getNumber());
    }

    public String number() {
        return toRomain();
    }

    private String toRomain() {
        int record = number;
        StringBuilder result = new StringBuilder();
        process(result, M);
        process(result, D);
        process(result, C, D);
        process(result, L);
        process(result, X, L);
        this.number = record;
        return result.toString();
    }

    private void process(StringBuilder result, RomanUnit unit, RomanUnit levelUpUnit) {
        int appearCount = 0;
        StringBuilder cacheString = new StringBuilder();
        while (number >= unit.value()) {
            number -= unit.value();
            appearCount++;
            if (appearCount <= unit.maxAppearTime()) {
                cacheString.append(unit.name());
            } else {
                appearCount = 0;
                cacheString = new StringBuilder(cacheString.substring(0, cacheString.length() - unit.maxAppearTime() + 1)).append(levelUpUnit.name());
            }
        }
        result.append(cacheString);
    }

    private void process(StringBuilder result, RomanUnit unit) {
        process(result, unit, unit);
    }

    private int getNumber() {
        return number;
    }

    private RomanNumber(String number) {
        this.number = calculate(number);
    }

    private RomanNumber(int number) {
        this.number = number;
    }

    private int calculate(String number) {
        int result = 0;
        for (int i = 0; i < number.length(); i++) {
            result += RomanUnit.valueOf(String.valueOf(number.charAt(i))).value();
        }
        return result;
    }
}
