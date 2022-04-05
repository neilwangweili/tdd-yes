package yes.tdd.dojo.domain.dictionary;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryTest {
    private final Dictionary dictionary = Dictionary.build(
        Pair.of("temp", "Temporary"),
        Pair.of("name", "Neil Wang")
    );

    @ParameterizedTest
    @CsvSource({
        "'',                                        ''",
        "'$temp$',                                  'Temporary'",
        "'$temp$ here comes the name $name$',       'Temporary here comes the name Neil Wang'"
    })
    void should_be_able_to_convert_string_to_expect_string(String original, String expect) {
        assertEquals(dictionary.convert(original), expect);
    }

    @Test
    void should_throw_exception_when_giving_single_dollar() {
        assertThat(catchThrowable(() -> dictionary.convert("$")))
            .isInstanceOf(InsufficientInputStringException.class)
            .hasMessage("Dollar chars is not pairs!");
    }

    @Test
    void should_throw_exception_when_giving_no_such_key_string() {
        assertThat(catchThrowable(() -> dictionary.convert("$123$")))
            .isInstanceOf(InsufficientInputStringException.class)
            .hasMessage("No such key in dictionary!");
    }
}
