package yes.tdd.dojo.domain.lags;

public class Time implements Comparable<Time> {
    private final StartTime startTime;
    private final Integer duration;

    public Time(Integer startTime, Integer duration) {
        this.startTime = new StartTime(startTime);
        this.duration = duration;
    }

    private Integer endTime() {
        return this.startTime.startTime() + this.duration;
    }

    public boolean startBefore(Time o) {
        return this.startTime.startTime() > o.endTime();
    }

    @Override
    public int compareTo(Time o) {
        return startTime.compareTo(o.startTime);
    }
}
