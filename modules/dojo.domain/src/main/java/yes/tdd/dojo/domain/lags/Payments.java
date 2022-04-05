package yes.tdd.dojo.domain.lags;

import yes.tdd.frameworks.domain.core.DomainField;

import java.util.*;
import java.util.stream.Collectors;

public final class Payments extends DomainField<List<Order>> {
    public static Payments create(Order... orders) {
        return new Payments(orders);
    }

    private Payments(Order[] orders) {
        super(
            Arrays.stream(orders)
                .sorted()
                .collect(Collectors.toList()),
            "The payments are too large!"
        );
    }

    public String findBest() {
        if (orders().isEmpty()) return "No order.";
        return report(findBestOrders(orders()));
    }

    private List<Order> findBestOrders(List<Order> orders) {
        if (orders.isEmpty()) return new ArrayList<>();
        return findBestOrders(findBestOrdersWithCurrentOrder(orders), findBestOrdersBeforeCurrentOrder(orders)).stream().sorted().collect(Collectors.toList());
    }

    private List<Order> findBestOrders(List<Order> o1, List<Order> o2) {
        return sum(o1) > sum(o2) ? o1 : o2;
    }

    private List<Order> findBestOrdersBeforeCurrentOrder(List<Order> orders) {
        return findBestOrders(buildOrdersWithoutCurrentOrder(orders));
    }

    private List<Order> findBestOrdersWithCurrentOrder(List<Order> orders) {
        Order currentOrder = orders.get(0);
        List<Order> result = findBestOrders(buildOrdersRemainingByStart(currentOrder));
        result.add(currentOrder);
        return result;
    }

    private List<Order> buildOrdersWithoutCurrentOrder(List<Order> orders) {
        List<Order> ordersWithoutCurrentOrder = new ArrayList<>(orders);
        ordersWithoutCurrentOrder.remove(0);
        return ordersWithoutCurrentOrder;
    }

    private List<Order> buildOrdersRemainingByStart(Order order) {
        return orders().stream().filter(o -> o.startBefore(order)).collect(Collectors.toList());
    }

    private String report(List<Order> orders) {
        return "The best choices is: " + names(orders) + ". The gain is " + sum(orders) + ".";
    }

    private int sum(List<Order> orders) {
        return orders.stream().mapToInt(Order::pay).sum();
    }

    private String names(List<Order> orders) {
        return orders.stream().map(Order::plane).collect(Collectors.joining(" -> "));
    }

    private List<Order> orders() {
        return new ArrayList<>(super.get());
    }
}
