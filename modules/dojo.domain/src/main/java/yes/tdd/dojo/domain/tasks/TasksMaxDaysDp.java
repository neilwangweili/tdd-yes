package yes.tdd.dojo.domain.tasks;

import com.google.common.collect.Lists;

import java.util.*;

public class TasksMaxDaysDp {
    private final Map<Integer, TasksDaysDp> dp;

    public TasksMaxDaysDp() {
        this.dp = new HashMap<>();
    }

    public void record(Integer number, Integer index) {
        if (!dp.containsKey(number)) {
            dp.put(number, new TasksDaysDp(Lists.newArrayList(index)));
            return;
        }
        dp.get(number).add(index);
    }

    public int calculateMaxDays() {
        return dp.values().stream().map(TasksDaysDp::duration).max(Comparator.naturalOrder()).orElse(0);
    }
}
