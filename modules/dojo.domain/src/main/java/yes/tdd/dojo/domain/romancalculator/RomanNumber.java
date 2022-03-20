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
        if (isBigPart(unit)) transferBigPart(unit, cacheString);
        else transferNumbers(unit, cacheString);
        result.append(cacheString);
    }

    private void transferBigPart(RomanUnit unit, StringBuilder cacheString) {
        cacheString.append(unit.findLower().name()).append(unit.findUpper().name());
        this.number -= unit.findUpper().value() - unit.findLower().value();
    }

    private void transferNumbers(RomanUnit unit, StringBuilder cacheString) {
        int appearCount = 0;
        while (this.number >= unit.value()) {
            this.number -= unit.value();
            appearCount++;
            transferNumber(unit, cacheString, appearCount);
        }
    }

    private void transferNumber(RomanUnit unit, StringBuilder cacheString, int appearCount) {
        if (appearCount <= unit.maxAppearTime()) cacheString.append(unit.name());
        else cacheString.delete(cacheString.length() - unit.maxAppearTime() + 1, cacheString.length()).append(unit.findUpper().name());
    }

    private boolean isBigPart(RomanUnit unit) {
        return this.number >= unit.findUpper().value() - unit.findLower().value();
    }

    private int getNumber() {
        return number;
    }

    private RomanNumber(String number) {
        calculate(number);
    }

    private RomanNumber(int number) {
        this.number = number;
    }

    private void calculate(String romanNumber) {
        while (romanNumber.length() > 0) {
            if (isSmallUnitAfterBigUnit(romanNumber)) {
                this.number += firstCharToNumber(romanNumber);
                romanNumber = romanNumber.substring(1);
            } else {
                this.number += secondCharMinusFirstCharToNumber(romanNumber);
                romanNumber = romanNumber.substring(2);
            }
        }
    }

    private int secondCharMinusFirstCharToNumber(String romanNumber) {
        return asNumber(romanNumber, 1) - asNumber(romanNumber, 0);
    }

    private int firstCharToNumber(String romanNumber) {
        return asNumber(romanNumber, 0);
    }

    private int asNumber(String romanNumber, int charAt) {
        return valueOf(String.valueOf(romanNumber.charAt(charAt))).value();
    }

    private boolean isSmallUnitAfterBigUnit(String number) {
        return number.length() == 1 || valueOf(String.valueOf(number.charAt(0))).value() >= valueOf(String.valueOf(number.charAt(1))).value();
    }
}
