package yes.tdd.dojo.domain.args;

import yes.tdd.frameworks.domain.core.Exceptions;

import java.lang.reflect.*;
import java.util.*;

import static yes.tdd.dojo.domain.args.OptionParsers.*;

public final class Args<T> {
    private static final Map<Class<?>, OptionParser<?>> PARSERS = Map.of(
        boolean.class, bool(),
        int.class, unary(0, Integer::parseInt),
        String.class, unary("", String::valueOf),
        String[].class, list(String[]::new, String::valueOf),
        Integer[].class, list(Integer[]::new, Integer::parseInt));

    private final Class<T> optionClass;
    private final Map<Class<?>, OptionParser<?>> parsers;


    public Args(Class<T> optionClass, Map<Class<?>, OptionParser<?>> parsers) {
        this.optionClass = optionClass;
        this.parsers = parsers;
    }

    @SuppressWarnings("all")
    public T parse(String... args) {
        Constructor<?> constructor = optionClass.getDeclaredConstructors()[0];
        Object[] values = Arrays.stream(constructor.getParameters()).map(o -> parseOption(o, Arrays.asList(args))).toArray();
        return Exceptions.evaluate(() -> (T) constructor.newInstance(values));
    }

    public static <T> T parse(Class<T> optionClass, String... args) {
        return new Args<>(optionClass, PARSERS).parse(args);
    }

    private Object parseOption(Parameter parameter, List<String> arguments) {
        return getOptionalParser(parameter).parse(arguments, parameter.getAnnotation(Option.class));
    }

    private OptionParser<?> getOptionalParser(Parameter parameter) {
        return parsers.get(parameter.getType());
    }
}
