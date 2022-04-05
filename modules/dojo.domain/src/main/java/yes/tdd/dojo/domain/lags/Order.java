package yes.tdd.dojo.domain.lags;

public class Order {
    private final String plane;
    private final Integer startTime;
    private final Integer duration;
    private final Integer pay;

    public Order(String plane, Integer startTime, Integer duration, Integer pay) {
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
