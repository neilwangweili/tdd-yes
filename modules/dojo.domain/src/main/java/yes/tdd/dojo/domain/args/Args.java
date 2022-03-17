package yes.tdd.dojo.domain.args;

import yes.tdd.frameworks.domain.core.Exceptions;

import java.lang.reflect.*;
import java.util.*;

import static yes.tdd.dojo.domain.args.OptionParsers.*;

public final class Args {
    private Args() {
    }

    @SuppressWarnings("all")
    public static <T> T parse(Class<T> optionClass, String... args) {
        Constructor<?> constructor = optionClass.getDeclaredConstructors()[0];
        Object[] values = Arrays.stream(constructor.getParameters()).map(o -> parseOption(o, Arrays.asList(args))).toArray();
        return Exceptions.evaluate(() -> (T) constructor.newInstance(values));
    }

    private static Object parseOption(Parameter parameter, List<String> arguments) {
        return getOptionalParser(parameter).parse(arguments, parameter.getAnnotation(Option.class));
    }

    private static final Map<Class<?>, OptionParser<?>> PARSERS = Map.of(
        boolean.class, bool(),
        int.class, unary(0, Integer::parseInt),
        String.class, unary("", String::valueOf),
        String[].class, list(String[]::new, String::valueOf),
        Integer[].class, list(Integer[]::new, Integer::parseInt));

    private static OptionParser<?> getOptionalParser(Parameter parameter) {
        return PARSERS.get(parameter.getType());
    }
}
