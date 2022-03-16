package yes.tdd.dojo.domain.args;

import java.lang.reflect.*;
import java.util.*;

public class Args {
    public static <T> T parse(Class<T> optionClass, String... args) {
        Constructor<?> constructor = optionClass.getDeclaredConstructors()[0];
        List<String> arguments = Arrays.asList(args);
        Object[] values = Arrays.stream(constructor.getParameters()).map(o -> parseOption(o, arguments)).toArray();
        try {
            return (T) constructor.newInstance(values);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object parseOption(Parameter parameter, List<String> arguments) {
        return getOptionalParser(parameter).parse(arguments, parameter.getAnnotation(Option.class));
    }

    private static final Map<Class<?>, OptionParser<?>> PARSERS = Map.of(
        boolean.class, new BooleanOptionParser(),
        int.class, new SingleValuedOptionParser<>(0, Integer::parseInt),
        String.class, new SingleValuedOptionParser<>("", String::valueOf));

    private static OptionParser<?> getOptionalParser(Parameter parameter) {
        return PARSERS.get(parameter.getType());
    }

}
