package yes.tdd.dojo.domain.args;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class BooleanOptionParserTest {
    @Test
    void should_not_accept_extra_argument_for_boolean_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> new BooleanOptionParser().parse(asList("-l", "t"),
            option("-l")));
        assertEquals("-l", e.getOption());
    }

    @Test
    void should_not_accept_extra_arguments_for_boolean_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> new BooleanOptionParser().parse(asList("-l", "t", "m"),
            option("-l")));
        assertEquals("-l", e.getOption());
    }

    @Test
    void should_set_default_value_to_false_if_option_not_present() {
        assertFalse((Boolean) new BooleanOptionParser().parse(List.of(), option("-l")));
    }

    static Option option(String value) {
        return new Option() {
            @Override
            public String value() {
                return value;
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return Option.class;
            }
        };
    }
}
