package yes.tdd.dojo.domain.fizzbuzz;

import java.util.*;
import java.util.stream.*;

public class FizzBuzz {
    public List<String> generate() {
        final int fizzbuzzSize = 100;
        return IntStream.range(0, fizzbuzzSize).mapToObj(String::valueOf).collect(Collectors.toList());
    }
}
