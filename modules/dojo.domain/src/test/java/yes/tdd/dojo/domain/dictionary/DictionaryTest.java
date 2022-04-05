package yes.tdd.dojo.domain.dictionary;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryTest {

    private final Dictionary dictionary = Dictionary.build(Pair.of("temp", "temporary"), Pair.of("name", "Neil Wang"));

    @Nested
    class IntegrationTest {
        @Test
        @Disabled
        void should_be_able_to_convert_string_to_expect_string() {
            assertEquals(
                dictionary.convert("$temp$ here comes the name $name$"),
                "temporary here comes the name Neil Wang"
            );
        }
    }

    @Nested
    class UnitTest {
        @Test
        void should_be_able_to_convert_empty() {
            assertEquals(dictionary.convert(""), "");
        }
    }
}
