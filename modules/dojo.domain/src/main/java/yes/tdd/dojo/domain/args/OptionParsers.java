package yes.tdd.dojo.domain.args;

import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;

public class OptionParsers {
    public static OptionParser<Boolean> bool() {
        return (arguments, option) -> values(arguments, option, 0).isPresent();
    }

    public static <T> OptionParser<T> unary(T defaultValue, Function<String, T> valueParser) {
        int expectedSize = 1;
        return (arguments, option) ->
            values(arguments, option, expectedSize).map(o -> parseValue(o.get(0), valueParser)).orElse(defaultValue);
    }

    public static <T> OptionParser<T[]> list(IntFunction<T[]> generator, Function<String, T> valueParser) {
        return (arguments, option) -> values(arguments, option)
            .map(o -> o.stream().map(value -> parseValue(value, valueParser)).toArray(generator)).orElse(generator.apply(0));
    }

    private static Optional<List<String>> values(List<String> arguments, Option option) {
        int index = arguments.indexOf(option.value());
        return Optional.ofNullable(index == -1 ? null : values(arguments, index));
    }

    private static Optional<List<String>> values(List<String> arguments, Option option, int expectedSize) {
        int index = arguments.indexOf(option.value());
        if (index == -1) return Optional.empty();
        List<String> values = values(arguments, index);
        if (values.size() < expectedSize) throw new InsufficientArgumentsException(option);
        if (values.size() > expectedSize) throw new TooManyArgumentsException(option);
        return Optional.of(values);
    }

    private static <T> T parseValue(String value, Function<String, T> valueParser) {
        return valueParser.apply(value);
    }

    static List<String> values(List<String> arguments, int index) {
        int followingFlag = IntStream.range(index + 1, arguments.size())
            .filter(o -> arguments.get(o).startsWith("-")).findFirst().orElse(arguments.size());
        return arguments.subList(index + 1, followingFlag);
    }

}
