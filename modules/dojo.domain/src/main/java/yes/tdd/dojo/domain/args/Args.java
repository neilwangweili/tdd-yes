package yes.tdd.dojo.domain.args;

import java.util.Map;

import static yes.tdd.dojo.domain.args.OptionParsers.*;

public final class Args {
    private Args() {
    }

    private static final Map<Class<?>, OptionParser<?>> PARSERS = Map.of(
        boolean.class, bool(),
        int.class, unary(0, Integer::parseInt),
        String.class, unary("", String::valueOf),
        String[].class, list(String::valueOf, String[]::new),
        Integer[].class, list(Integer::parseInt, Integer[]::new));

    public static <T> T parse(Class<T> optionClass, String... args) {
        return new OptionsClass<>(PARSERS, optionClass).parse(args);
    }
}
