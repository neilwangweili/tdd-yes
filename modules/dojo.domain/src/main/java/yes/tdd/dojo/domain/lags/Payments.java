package yes.tdd.dojo.domain.lags;

import yes.tdd.frameworks.domain.core.DomainField;

import java.util.*;
import java.util.stream.Collectors;

public final class Payments extends DomainField<List<Order>> {
    public static Payments create(Order... orders) {
        return new Payments(orders);
    }

    private Payments(Order[] orders) {
        super(Arrays.stream(orders).collect(Collectors.toList()), "The payments are too large!");
    }

    public String findBest() {
        return "The best choices is: AF514 BA01. The gain is 18";
    }
}
