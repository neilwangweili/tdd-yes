package yes.tdd.dojo.domain.tasks;

public class Tasks {
    private final int[] taskNumbers;

    public Tasks(int... taskNumbers) {
        this.taskNumbers = taskNumbers;
    }


    public int maxDays() {
        TasksMaxDaysDp dp = new TasksMaxDaysDp();
        for (int i = 0; i < taskNumbers.length; i++) {
            dp.record(taskNumbers[i], i);
        }
        return dp.calculateMaxDays();
    }
}
