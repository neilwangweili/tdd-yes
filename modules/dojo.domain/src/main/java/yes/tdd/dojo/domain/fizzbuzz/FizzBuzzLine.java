package yes.tdd.dojo.domain.fizzbuzz;

public final class FizzBuzzLine {
    private final String line;

    public static FizzBuzzLine newInstance(int number) {
        return new FizzBuzzLine(number);
    }

    private FizzBuzzLine(int number) {
        this.line = fizzbuzzLine(number);
    }

    private String fizzbuzzLine(int number) {
        if (isFizz(number) && isBuzz(number)) return "FizzBuzz";
        if (isFizz(number)) return "Fizz";
        if (isBuzz(number)) return "Buzz";
        return String.valueOf(number);
    }

    private boolean isBuzz(int number) {
        final int buzzTag = 5;
        return isHitTag(number, buzzTag);
    }

    private boolean isFizz(int number) {
        final int fizzTag = 3;
        return isHitTag(number, fizzTag);
    }

    private boolean isHitTag(int number, int tag) {
        return number % tag == 0 || String.valueOf(number).contains(String.valueOf(tag));
    }

    public String line() {
        return line;
    }
}
