package yes.tdd.dojo.domain.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    void should_fizz_buzz_generate_100_lines() {
        assertEquals(new FizzBuzz().generate().size(), 100);
    }

    @Test
    void should_be_able_to_get_1_when_line_is_1() {
        assertEquals(new FizzBuzz().generate().get(0), "1");
    }

    @Test
    void should_be_able_to_get_fizz_when_line_is_3() {
        assertEquals(new FizzBuzz().generate().get(2), "Fizz");
    }
}
// 3 -> Fizz
// 5 -> Buzz
// 3的倍数 || 含有3 Fizz
// 5的倍数 || 含有5 Buzz
// 符合上两种： FizzBuzz
// 100行。

// 测试要给代码开发一个指引 一个导向 一个把大问题变为小问题逐步解决的节奏
