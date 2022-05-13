package yes.tdd.dojo.domain.args;

import yes.tdd.frameworks.domain.core.Exceptions;

import java.lang.reflect.*;
import java.util.*;

public class OptionsClass<T> {
    private final Class<T> optionsClass;

    public OptionsClass(Class<T> optionsClass) {
        this.optionsClass = optionsClass;
    }

    @SuppressWarnings("all")
    public T parse(String[] args, Map<Class<?>, OptionParser<?>> parsers) {
        Constructor<?> constructor = this.optionsClass.getDeclaredConstructors()[0];
        Object[] values = Arrays.stream(constructor.getParameters()).map(o -> parseOption(parsers, o, Arrays.asList(args))).toArray();
        return Exceptions.evaluate(() -> (T) constructor.newInstance(values));
    }

    private Object parseOption(Map<Class<?>, OptionParser<?>> parsers, Parameter parameter, List<String> arguments) {
        return getOptionalParser(parsers, parameter).parse(arguments, parameter.getAnnotation(Option.class));
    }

    private OptionParser<?> getOptionalParser(Map<Class<?>, OptionParser<?>> parsers, Parameter parameter) {
        return parsers.get(parameter.getType());
    }
}
