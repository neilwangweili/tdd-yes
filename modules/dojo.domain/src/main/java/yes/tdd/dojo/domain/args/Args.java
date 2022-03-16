package yes.tdd.dojo.domain.args;

import yes.tdd.frameworks.domain.core.Exceptions;

import java.lang.reflect.*;
import java.util.*;

public class Args {
    public static <T> T parse(Class<T> optionClass, String... args) {
        Constructor<?> constructor = optionClass.getDeclaredConstructors()[0];
        Parameter parameter = constructor.getParameters()[0];
        Option option = parameter.getAnnotation(Option.class);
        List<String> arguments = Arrays.asList(args);

        return (T) Exceptions.evaluate(() -> constructor.newInstance(arguments.contains(option.value())));
    }
}
