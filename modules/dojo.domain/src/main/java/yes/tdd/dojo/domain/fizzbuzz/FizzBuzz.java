package yes.tdd.dojo.domain.fizzbuzz;

import java.util.*;
import java.util.stream.*;

public class FizzBuzz {
    public List<FizzBuzzLine> generate() {
        final int fizzbuzzSize = 101;
        return IntStream.range(1, fizzbuzzSize).mapToObj(FizzBuzzLine::new).collect(Collectors.toList());
    }
}
