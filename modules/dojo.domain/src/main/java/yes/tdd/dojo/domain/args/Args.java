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
        Option option = parameter.getAnnotation(Option.class);
        Object value = null;
        if (parameter.getType() == boolean.class) {
            value = arguments.contains(option.value());
        }
        if (parameter.getType() == int.class) {
            int index = arguments.indexOf(option.value());
            value = Integer.parseInt(arguments.get(index + 1));
        }
        if (parameter.getType() == String.class) {
            int index = arguments.indexOf(option.value());
            value = arguments.get(index + 1);
        }
        return value;
    }
}
