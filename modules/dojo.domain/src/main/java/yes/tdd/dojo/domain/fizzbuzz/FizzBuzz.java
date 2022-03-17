package yes.tdd.dojo.domain.fizzbuzz;

import java.util.*;
import java.util.stream.*;

public class FizzBuzz {
    public List<String> generate() {
        final int fizzbuzzSize = 101;
        final int fizzTag = 3;
        final int buzzTag = 5;
        return IntStream.range(1, fizzbuzzSize).mapToObj(o -> {
            if (o % fizzTag == 0 && o % buzzTag == 0) return "FizzBuzz";
            if (o % fizzTag == 0) return "Fizz";
            if (o % buzzTag == 0) return "Buzz";
            return String.valueOf(o);
        }).collect(Collectors.toList());
    }
}
