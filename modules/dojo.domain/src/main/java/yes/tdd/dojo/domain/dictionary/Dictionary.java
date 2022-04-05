package yes.tdd.dojo.domain.dictionary;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class Dictionary {
    private final Map<String, String> dictionary;

    @SafeVarargs
    public static Dictionary build(Pair<String, String>... elements) {
        return new Dictionary(elements);
    }

    @SafeVarargs
    public Dictionary(Pair<String, String>... elements) {
        dictionary = new HashMap<>();
        Arrays.stream(elements).forEach(o -> dictionary.put(o.getKey(), o.getValue()));
    }

    public String convert(String target) {
        return "";
    }
}
