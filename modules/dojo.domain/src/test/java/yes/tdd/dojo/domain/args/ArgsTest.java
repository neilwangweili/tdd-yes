package yes.tdd.dojo.domain.args;

import org.junit.jupiter.api.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ArgsTest {
    @Nested
    class IntegrationTest {
        @Test
        void should_be_able_to_parse_bool_int_directory_by_args() {
            MultipleOptions options = Args.parse(MultipleOptions.class, "-l", "-p", "8080", "-d", "/usr/logs");
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

    }

    @Nested
    class UnitTest {
        @Test
        void should_parse_option_parsers_if_option_parser_provided() {
            OptionParser<Boolean> boolParser = mock(OptionParser.class);
            OptionParser<Integer> intParser = mock(OptionParser.class);
            OptionParser<String> stringParser = mock(OptionParser.class);
            when(boolParser.parse(any(), any())).thenReturn(true);
            when(intParser.parse(any(), any())).thenReturn(1);
            when(stringParser.parse(any(), any())).thenReturn("Hello");
            Args<MultipleOptions> args = new Args<>(MultipleOptions.class, Map.of(boolean.class, boolParser, int.class, intParser, String.class, stringParser));
            MultipleOptions options = args.parse("-l", "-p", "8080", "-d", "/usr/logs");
            assertTrue(options.logging());
            assertEquals(options.port(), 1);
            assertEquals(options.directory(), "Hello");
        }
    }
}
