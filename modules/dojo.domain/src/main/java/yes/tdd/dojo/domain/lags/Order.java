package yes.tdd.dojo.domain.lags;

public final class Order implements Comparable<Order> {
    private final String plane;
    private final Integer startTime;
    private final Integer duration;
    private final Integer pay;

    public static Order of(String plane, Integer startTime, Integer duration, Integer pay) {
        return new Order(plane, startTime, duration, pay);
    }

    private Order(String plane, Integer startTime, Integer duration, Integer pay) {
        this.plane = plane;
        this.startTime = startTime;
        this.duration = duration;
        this.pay = pay;
    }

    public String plane() {
        return plane;
    }

    public Integer pay() {
        return pay;
    }

    private Integer endTime() {
        return startTime + duration;
    }

    public boolean startBefore(Order currentOrder) {
        return this.startTime >= currentOrder.endTime();
    }

    @Override
    public int compareTo(Order o) {
        return this.startTime - o.startTime;
    }
}
