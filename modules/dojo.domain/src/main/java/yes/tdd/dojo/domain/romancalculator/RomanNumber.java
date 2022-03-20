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
        if (number == 0) return "N";
        int record = number;
        StringBuilder result = new StringBuilder();
        process(result, M, D);
        process(result, D, M, C);
        process(result, C, D);
        process(result, L, C, X);
        process(result, X, L);
        process(result, V, X, I);
        process(result, I, V);
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

    private void process(StringBuilder result, RomanUnit unit, RomanUnit levelUpUnit, RomanUnit levelDownUnit) {
        StringBuilder cacheString = new StringBuilder();
        if (number >= levelUpUnit.value() - levelDownUnit.value()) {
            cacheString.append(levelDownUnit.name()).append(levelUpUnit.name());
            number -= levelUpUnit.value() - levelDownUnit.value();
        } else if (number >= unit.value()) {
            number -= unit.value();
            cacheString.append(unit.name());
        }
        result.append(cacheString);
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
        while (number.length() > 0) {
            if (number.length() == 1) {
                result += valueOf(number).value();
                number = number.substring(1);
            } else if (valueOf(String.valueOf(number.charAt(0))).value() >= valueOf(String.valueOf(number.charAt(1))).value()) {
                result += valueOf(String.valueOf(number.charAt(0))).value();
                number = number.substring(1);
            } else {
                result += valueOf(String.valueOf(number.charAt(1))).value() - valueOf(String.valueOf(number.charAt(0))).value();
                number = number.substring(2);
            }
        }
        return result;
    }
}
