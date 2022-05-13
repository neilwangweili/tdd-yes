package yes.tdd.dojo.domain.args;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InOrder;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.*;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static yes.tdd.dojo.domain.args.OptionParsers.*;

public class OptionParserTest {

    @Nested
    class UnaryOptionTest {
        @Test
        void should_not_accept_extra_argument_for_single_valued_option() {
            TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () ->
                unary(0, Integer::parseInt).parse(asList("-p", "8080", "8081"), option("-p")));
            assertEquals(e.getOption(), "-p");
        }

        @ParameterizedTest
        @ValueSource(strings = {"-p -l", "-p"})
        void should_not_accept_insufficient_argument_for_single_valued_object(String arguments) {
            InsufficientArgumentsException e = assertThrows(InsufficientArgumentsException.class, () ->
                unary(0, Integer::parseInt).parse(asList(arguments.split(" ")), option("-p")));
            assertEquals(e.getOption(), "-p");
        }

        @Test
        void should_parse_value_if_flag_present() {
            Function<String, Object> parser = mock(Function.class);
            unary(any(), parser).parse(asList("-p", "8080"), option("-p"));
            verify(parser).apply("8080");
        }

        @Test
        void should_set_default_value_for_int_option() {
            assertEquals(0, unary(0, Integer::parseInt).parse(List.of(), option("-p")));
        }

        @Test
        void should_set_default_value_for_string_option() {
            assertEquals(0, unary(0, String::valueOf).parse(List.of(), option("-p")));
        }

        @Test
        void should_not_accept_extra_argument_for_d_object() {
            TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () ->
                unary("", String::valueOf).parse(asList("-d", "/usr/logs", "~/logs"), option("-d")));
            assertEquals(e.getOption(), "-d");
        }

        @Test
        void should_parse_value_if_flag_string_present() {
            assertEquals(8080, unary(0, Integer::parseInt).parse(List.of("-p", "8080"), option("-p")));
        }

        @Test
        void should_parse_value_if_flag_int_present() {
            assertEquals("/usr/logs", unary(0, String::valueOf).parse(List.of("-d", "/usr/logs"), option("-d")));
        }
    }

    @Nested
    class BooleanOptionParserTest {
        @Test
        void should_not_accept_extra_argument_for_boolean_option() {
            TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> bool().parse(asList("-l", "t"),
                option("-l")));
            assertEquals("-l", e.getOption());
        }

        @Test
        void should_not_accept_extra_arguments_for_boolean_option() {
            TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> bool().parse(asList("-l", "t", "m"),
                option("-l")));
            assertEquals("-l", e.getOption());
        }

        @Test
        void should_set_default_value_to_false_if_option_not_present() {
            assertFalse(bool().parse(List.of(), option("-l")));
        }

        @Test
        void should_set_default_value_to_true_if_option_present() {
            assertTrue(bool().parse(List.of("-l"), option("-l")));
        }

    }

    @Nested
    class ListOptionTest {

        @Test
        void should_not_treat_negative_int_with_flag() {
            assertArrayEquals(new Integer[]{1, 2, -3, 5}, list(Integer::parseInt, Integer[]::new).parse(asList("-", "-d", "1", "2", "-3", "5"), option("-d")));
        }

        @Test
        void should_parse_list_value() {
            Function<String, Object> parser = mock(Function.class);
            list(parser, Object[]::new).parse(asList("-g", "this", "is", "a", "list"), option("-g"));
            InOrder order = inOrder(parser);
            order.verify(parser).apply("this");
            order.verify(parser).apply("is");
            order.verify(parser).apply("a");
            order.verify(parser).apply("list");
        }

        @Test
        void should_use_empty_array_as_default_value() {
            assertEquals(0, list(String::valueOf, String[]::new).parse(List.of(), option("-g")).length);
        }
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
