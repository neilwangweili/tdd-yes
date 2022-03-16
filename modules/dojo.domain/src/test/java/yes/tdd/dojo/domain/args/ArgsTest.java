package yes.tdd.dojo.domain.args;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {

    @Test
    void should_set_boolean_type_option_to_true_if_flag_present() {
        BooleanOptions options = Args.parse(BooleanOptions.class, "-l");
        assertTrue(options.logging());
    }

    @Test
    void should_set_boolean_type_option_to_false_if_flag_not_present() {
        BooleanOptions options = Args.parse(BooleanOptions.class);
        assertFalse(options.logging());
    }

    @Test
    void should_parse_int_as_option_value() {
        IntOptions options = Args.parse(IntOptions.class, "-p", "8080");
        assertEquals(options.port(), 8080);
    }

    @Test
    void should_parse_string_as_option_value() {
        StringOptions options = Args.parse(StringOptions.class, "-d", "/usr/logs");
        assertEquals(options.directory(), "/usr/logs");
    }

    @Test
    @Disabled
    void should_be_able_to_parse_bool_int_directory_by_args() {
        Options options = Args.parse(Options.class, "-l", "-p", "8080", "-d", "/usr/logs");
        assertTrue(options.logging());
        assertEquals(options.port(), 8080);
        assertEquals(options.directory(), "/usr/logs");
    }

    @Test
    @Disabled
    void should_be_able_to_parse_list_by_args() {
        ListOptions options = Args.parse(ListOptions.class, "-g", "this", "is", "a", "list", "-d", "1", "2", "-3", "5");
        assertArrayEquals(new String[]{"this", "is", "a", "list"}, options.group());
        assertArrayEquals(new int[]{1, 2, -3, 5}, options.decimals());
    }
}
