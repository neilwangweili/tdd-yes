package yes.tdd.dojo.domain.dictionary;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    private static final String TARGET_MARKER = "$";
    private final Map<String, String> dictionary;

    @SafeVarargs
    public static Dictionary build(Pair<String, String>... elements) {
        return new Dictionary(elements);
    }

    @SafeVarargs
    public Dictionary(Pair<String, String>... elements) {
        dictionary = Arrays.stream(elements).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    }

    public String convert(String target) {
        while (target.contains("$")) target = convertTarget(target);
        return target;
    }

    private String convertTarget(String target) {
        int firstIndex = indexOfMarker(target);
        target = target.replaceFirst("\\$", "");
        target = leftPart(target, firstIndex) + replacement(target, firstIndex) + rightPart(target);
        return target;
    }

    private String replacement(String target, int firstIndex) {
        if (!target.contains(TARGET_MARKER)) throw new InsufficientInputStringException("Dollar chars is not pairs!");
        if (!dictionary.containsKey(replacementString(target, firstIndex))) throw new InsufficientInputStringException("No such key in dictionary!");
        return dictionary.get(replacementString(target, firstIndex));
    }

    private String replacementString(String target, int firstIndex) {
        return target.substring(firstIndex, indexOfMarker(target));
    }

    private String rightPart(String target) {
        return target.substring(indexOfMarker(target) + 1);
    }

    private int indexOfMarker(String target) {
        return target.indexOf(TARGET_MARKER);
    }

    private String leftPart(String target, int firstIndex) {
        return target.substring(0, firstIndex);
    }
}
