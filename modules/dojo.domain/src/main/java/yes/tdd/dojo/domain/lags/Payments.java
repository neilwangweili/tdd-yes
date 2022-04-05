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
        if (empty()) return "No order.";
        return report(orders());
    }

    private String report(List<Order> orders) {
        String names = orders.stream().map(Order::plane).collect(Collectors.joining(" "));
        int sum = orders.stream().mapToInt(Order::pay).sum();
        return "The best choices is: " + names + ". The gain is " + sum + ".";
    }

    private boolean empty() {
        return orders().size() == 0;
    }

    private List<Order> orders() {
        return super.get();
    }
}
