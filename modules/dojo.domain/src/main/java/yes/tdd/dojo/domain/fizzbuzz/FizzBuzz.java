package yes.tdd.dojo.domain.fizzbuzz;

import java.util.*;
import java.util.stream.*;

public class FizzBuzz {
    public List<String> generate() {
        final int fizzbuzzSize = 101;
        final int fizzTag = 3;
        return IntStream.range(1, fizzbuzzSize).mapToObj(o -> {
            if (o % fizzTag == 0) return "Fizz";
            return String.valueOf(o);
        }).collect(Collectors.toList());
    }
}
