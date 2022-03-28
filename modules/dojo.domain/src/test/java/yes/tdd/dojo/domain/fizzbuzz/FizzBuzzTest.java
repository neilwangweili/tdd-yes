package yes.tdd.dojo.domain.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    void should_fizz_buzz_generate_100_lines() {
        assertEquals(new FizzBuzz().generate().size(), 100);
    }

    @ParameterizedTest
    @CsvSource({
        "1,     '1'",
        "3,     'Fizz'",
        "31,    'Fizz'",
        "5,     'Buzz'",
        "56,    'Buzz'",
        "15,    'FizzBuzz'",
        "51,    'FizzBuzz'",
        "30,    'FizzBuzz'",
    })
    void should_be_able_to_get_true_word(int number, String expect) {
        assertEquals(new FizzBuzz().generate().get(number - 1).line(), expect);
    }
}
