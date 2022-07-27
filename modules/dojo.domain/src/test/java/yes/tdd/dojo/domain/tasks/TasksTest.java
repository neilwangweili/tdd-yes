package yes.tdd.dojo.domain.tasks;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksTest {
    @Nested
    class IntegrationTest {
        @Test
        void should__calculate_max_days() {
            assertEquals(6, new Tasks(1, 4, 2, 1, 4, 4, 4).maxDays());
        }
    }
}
