package yes.tdd.dojo.domain.args;

import java.util.List;
import java.util.function.Function;

public class SingleValuedOptionParser<T> implements OptionParser<T> {
    private final Function<String, T> valueParser;
    private final T defaultValue;

    public SingleValuedOptionParser(T defaultValue, Function<String, T> valueParser) {
        this.defaultValue = defaultValue;
        this.valueParser = valueParser;
    }

    @Override
    public T parse(List<String> arguments, Option option) {
        int index = arguments.indexOf(option.value());
        if (index == -1) return defaultValue;
        if (index + 1 == arguments.size() || arguments.get(index + 1).startsWith("-")) throw new InsufficientArgumentsException(option);
        if (index + 2 < arguments.size() && !arguments.get(index + 2).startsWith("-")) throw new TooManyArgumentsException(option);
        return valueParser.apply(arguments.get(index + 1));
    }

}
