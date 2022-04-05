package yes.tdd.dojo.domain.lags;

public class Time implements Comparable<Time> {
    private final Integer startTime;
    private final Integer duration;

    public Time(Integer startTime, Integer duration) {
        this.startTime = startTime;
        this.duration = duration;
    }

    private Integer endTime() {
        return this.startTime + this.duration;
    }

    @Override
    public int compareTo(Time o) {
        return startTime - o.startTime;
    }

    public boolean startBefore(Time time) {
        return this.startTime >= time.endTime();
    }
}
