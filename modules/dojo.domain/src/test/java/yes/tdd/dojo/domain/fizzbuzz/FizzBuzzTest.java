package yes.tdd.dojo.domain.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    void should_fizz_buzz_generate_100_lines() {
        assertEquals(new FizzBuzz().generate().size(), 100);
    }
}
// 1 -> 1
// 2 -> 2
// 3 -> Fizz
// 4 -> 4
// 5 -> Buzz
// 3的倍数 || 含有3 Fizz
// 5的倍数 || 含有5 Buzz
// 符合上两种： FizzBuzz
// 100行。

// 测试要给代码开发一个指引 一个导向 一个把大问题变为小问题逐步解决的节奏
