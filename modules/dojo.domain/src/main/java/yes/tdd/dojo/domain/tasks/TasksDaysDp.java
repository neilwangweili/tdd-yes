package yes.tdd.dojo.domain.tasks;

import com.google.common.collect.Lists;

import java.util.List;

public class TasksDaysDp {
    private final List<Integer> days;

    public TasksDaysDp(Integer day) {
        this.days = Lists.newArrayList(day);
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
