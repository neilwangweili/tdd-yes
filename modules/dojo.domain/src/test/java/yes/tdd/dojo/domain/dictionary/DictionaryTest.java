package yes.tdd.dojo.domain.dictionary;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryTest {
    @Nested
    class IntegrationTest {
        @Test
        void should_be_able_to_convert_string_to_expect_string() {
            Dictionary dictionary = Dictionary.build("temp", "temporary", "name", "Neil Wang");
            assertEquals(
                dictionary.convert("$temp$ here comes the name $name$"),
                "temporary here comes the name Neil Wang"
            );
        }
    }
}
