package yes.tdd.dojo.domain.tasks;

import java.util.List;

public class TasksDaysDp {
    private final List<Integer> days;

    public TasksDaysDp(List<Integer> days) {
        this.days = days;
    }

    public void add(Integer index) {
        this.days.add(index);
    }

    public Integer duration() {
        return last() - first() + 1;
    }

    private Integer first() {
        return days.get(0);
    }

    private Integer last() {
        return days.get(days.size() - 1);
    }
}
