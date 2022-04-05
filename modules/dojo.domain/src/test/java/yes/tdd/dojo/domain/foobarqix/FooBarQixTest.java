package yes.tdd.dojo.domain.foobarqix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooBarQixTest {
    @ParameterizedTest
    @CsvSource({
        "1,     '1'",
        "9,     'Foo'",
        "3,     'FooFoo'"
    })
    void should_be_able_to_convert_to_foo_bar_qix_string_by_giving_number(Integer giving, String expect) {
        assertEquals(new FooBarQix(giving).toString(), expect);
    }
}