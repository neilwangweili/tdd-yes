package yes.tdd.dojo.domain.args;

import org.junit.jupiter.api.*;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static yes.tdd.dojo.domain.args.OptionParserTest.option;

public class ArgsTest {
    @Test
    void should_be_able_to_parse_bool_int_directory_by_args() {
        MutipleOptions options = Args.parse(MutipleOptions.class, "-l", "-p", "8080", "-d", "/usr/logs");
        assertTrue(options.logging());
        assertEquals(options.port(), 8080);
        assertEquals(options.directory(), "/usr/logs");
    }

    @Test
    void should_be_able_to_parse_list_by_args() {
        ListOptions options = Args.parse(ListOptions.class, "-g", "this", "is", "a", "list", "-d", "1", "2", "-3", "5");
        assertArrayEquals(new String[]{"this", "is", "a", "list"}, options.group());
        assertArrayEquals(new Integer[]{1, 2, -3, 5}, options.decimals());
    }

    @Test
    void should_not_treat_negative_int_with_flag() {
        ListOptions options = Args.parse(ListOptions.class, "-d", "1", "2", "-3", "5");
        assertArrayEquals(new Integer[]{1, 2, -3, 5}, options.decimals());
    }

    @Nested
    class ListOptionTest {
        @Test
        void should_parse_list_value() {
            assertArrayEquals(new String[]{"this", "is", "a", "list"}, OptionParsers.list(String[]::new, String::valueOf).parse(asList("-g", "this", "is", "a", "list"), option("-g")));
        }

        @Test
        void should_use_empty_array_as_default_value() {
            assertEquals(0, OptionParsers.list(String[]::new, String::valueOf).parse(List.of(), option("-g")).length);
        }
    }
}
