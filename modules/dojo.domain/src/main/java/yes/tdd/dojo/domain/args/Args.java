package yes.tdd.dojo.domain.args;

import java.util.*;

import static yes.tdd.dojo.domain.args.OptionParsers.*;

public final class Args<T> {
    private static final Map<Class<?>, OptionParser<?>> PARSERS = Map.of(
        boolean.class, bool(),
        int.class, unary(0, Integer::parseInt),
        String.class, unary("", String::valueOf),
        String[].class, list(String::valueOf, String[]::new),
        Integer[].class, list(Integer::parseInt, Integer[]::new));

    private final Class<T> optionClass;
    private final Map<Class<?>, OptionParser<?>> parsers;


    public Args(Class<T> optionClass, Map<Class<?>, OptionParser<?>> parsers) {
        this.optionClass = optionClass;
        this.parsers = parsers;
    }


    public T parse(String... args) {
        return new OptionsClass<>(optionClass).parse(args, this.parsers);
    }

    public static <T> T parse(Class<T> optionClass, String... args) {
        return new Args<>(optionClass, PARSERS).parse(args);
    }
}
