package yes.tdd.dojo.domain.lags;

public final class Order implements Comparable<Order> {
    private final Plane plane;
    private final Time time;
    private final Integer pay;

    public static Order of(String plane, Integer startTime, Integer duration, Integer pay) {
        return new Order(plane, startTime, duration, pay);
    }

    private Order(String plane, Integer startTime, Integer duration, Integer pay) {
        this.plane = new Plane(plane);
        this.time = new Time(startTime, duration);
        this.pay = pay;
    }

    public String plane() {
        return plane.plane();
    }

    public Integer pay() {
        return pay;
    }

    public boolean startBefore(Order o) {
        return time.startBefore(o.time);
    }

    @Override
    public int compareTo(Order o) {
        return this.time.compareTo(o.time);
    }
}
