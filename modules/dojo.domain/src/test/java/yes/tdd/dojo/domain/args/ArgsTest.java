package yes.tdd.dojo.domain.args;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
