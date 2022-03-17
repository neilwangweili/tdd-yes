package yes.tdd.dojo.domain.fizzbuzz;

public class FizzBuzzLine {
    private final String line;

    public FizzBuzzLine(int number) {
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
        return number % buzzTag == 0 || String.valueOf(number).contains("5");
    }

    private boolean isFizz(int number) {
        final int fizzTag = 3;
        return number % fizzTag == 0 || String.valueOf(number).contains("3");
    }

    public String line() {
        return line;
    }
}
