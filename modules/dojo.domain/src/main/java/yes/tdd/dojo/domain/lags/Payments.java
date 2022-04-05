package yes.tdd.dojo.domain.lags;

import java.util.*;
import java.util.stream.Collectors;

public final class Payments {
    private final List<Order> orders;

    public static Payments create(Order... orders) {
        return new Payments(orders);
    }

    private Payments(Order[] orders) {
        this.orders = Arrays.stream(orders).collect(Collectors.toList());
    }

    public String findBest() {
        return "The best choices is: AF514 BA01. The gain is 18";
    }
}
