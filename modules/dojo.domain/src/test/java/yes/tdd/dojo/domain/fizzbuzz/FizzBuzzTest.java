package yes.tdd.dojo.domain.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    void should_fizz_buzz_generate_100_lines() {
        assertEquals(new FizzBuzz().generate().size(), 100);
    }

    @Test
    void should_be_able_to_get_1_when_line_is_1() {
        assertEquals(new FizzBuzz().generate().get(0).line(), "1");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 31})
    void should_be_able_to_get_fizz_when_line_is_multi_of_3_or_contains_3(int index) {
        assertEquals(new FizzBuzz().generate().get(index - 1).line(), "Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 56})
    void should_be_able_to_get_buzz_when_line_is_multi_of_5_or_contains_5(int index) {
        assertEquals(new FizzBuzz().generate().get(index - 1).line(), "Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 51, 30})
    void should_be_able_to_get_fizzbuzz_when_line_is_multi_of_3_or_contains_3_and_multi_of_5_or_contains_5(int index) {
        assertEquals(new FizzBuzz().generate().get(index - 1).line(), "FizzBuzz");
    }
}
