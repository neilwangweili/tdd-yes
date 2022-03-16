package yes.tdd.dojo.domain.args;

import java.util.List;
import java.util.function.Function;

public class SingleValuedOptionParser<T> implements OptionParser<T> {
    private final Function<String, T> valueParser;

    public SingleValuedOptionParser(Function<String, T> valueParser) {
        this.valueParser = valueParser;
    }

    @Override
    public T parse(List<String> arguments, Option option) {
        int index = arguments.indexOf(option.value());
        return valueParser.apply(arguments.get(index + 1));
    }

}
