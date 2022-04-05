package yes.tdd.dojo.domain.lags;

import yes.tdd.frameworks.domain.core.DomainField;

public class StartTime extends DomainField<Integer> implements Comparable<StartTime> {
    public StartTime(Integer startTime) {
        super(startTime, 0, "Start time must be positive!");
    }

    public Integer startTime() {
        return super.get();
    }

    @Override
    public int compareTo(StartTime o) {
        return startTime() - o.startTime();
    }
}
