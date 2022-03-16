package yes.tdd.dojo.domain.args;

import java.lang.reflect.*;
import java.util.*;

public class Args {
    public static <T> T parse(Class<T> optionClass, String... args) {
        Constructor<?> constructor = optionClass.getDeclaredConstructors()[0];
        Parameter parameter = constructor.getParameters()[0];
        Option option = parameter.getAnnotation(Option.class);
        List<String> arguments = Arrays.asList(args);
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
        try {
            return (T) constructor.newInstance(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
