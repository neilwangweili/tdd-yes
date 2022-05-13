package yes.tdd.dojo.domain.args;

import yes.tdd.frameworks.domain.core.Exceptions;

import java.lang.reflect.*;
import java.util.*;

public class OptionsClass<T> {
    private final Map<Class<?>, OptionParser<?>> parsers;
    private final Class<T> optionsClass;

    public OptionsClass(Map<Class<?>, OptionParser<?>> parsers, Class<T> optionsClass) {
        this.parsers = parsers;
        this.optionsClass = optionsClass;
    }

    @SuppressWarnings("all")
    public <T> T parse(String[] args) {
        Constructor<?> constructor = this.optionsClass.getDeclaredConstructors()[0];
        Object[] values = Arrays.stream(constructor.getParameters()).map(o -> this.parseOption(o, Arrays.asList(args))).toArray();
        return Exceptions.evaluate(() -> (T) constructor.newInstance(values));
    }

    private Object parseOption(Parameter parameter, List<String> arguments) {
        return getOptionalParser(parameter).parse(arguments, parameter.getAnnotation(Option.class));
    }

    private OptionParser<?> getOptionalParser(Parameter parameter) {
        return this.parsers.get(parameter.getType());
    }
}
