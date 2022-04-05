package yes.tdd.dojo.domain.dictionary;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
//        "'$temp$ here comes the name $name$',       'Temporary here comes the name Neil Wang'"
    })
    void should_be_able_to_convert_string_to_expect_string(String original, String expect) {
        assertEquals(dictionary.convert(original), expect);
    }
}
