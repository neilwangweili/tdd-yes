package yes.tdd.dojo.domain.romancalculator;

import java.util.Arrays;

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
        StringBuilder result = process();
        this.number = record;
        return result.toString();
    }

    private StringBuilder process() {
        StringBuilder result = new StringBuilder();
        Arrays.stream(values()).filter(o -> o != U && o != N).forEach(o -> this.process(result, o));
        return result;
    }

    private void process(StringBuilder result, RomanUnit unit) {
        StringBuilder cacheString = new StringBuilder();
        if (this.number >= unit.findUpper().value() - unit.findLower().value()) {
            cacheString.append(unit.findLower().name()).append(unit.findUpper().name());
            this.number -= unit.findUpper().value() - unit.findLower().value();
        } else {
            int appearCount = 0;
            while (this.number >= unit.value()) {
                this.number -= unit.value();
                appearCount++;
                if (appearCount <= unit.maxAppearTime()) {
                    cacheString.append(unit.name());
                } else {
                    appearCount = 0;
                    cacheString = new StringBuilder(cacheString.substring(0, cacheString.length() - unit.maxAppearTime() + 1)).append(unit.findUpper().name());
                }
            }
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
