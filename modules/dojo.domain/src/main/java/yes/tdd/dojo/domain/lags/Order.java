package yes.tdd.dojo.domain.lags;

public final class Order {
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

    public Integer startTime() {
        return startTime;
    }

    public Integer duration() {
        return duration;
    }

    public Integer pay() {
        return pay;
    }
}
