package yes.tdd.dojo.domain.tasks;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksTest {
    @Nested
    class IntegrationTest {
        @Test
        void should_calculate_max_days() {
            assertEquals(6, new Tasks(1, 4, 2, 1, 4, 4, 4).maxDays());
        }
    }

    @Nested
    class UnitTest {
        @Test
        void should_return_4_when_calculate_max_days() {
            assertEquals(4, new Tasks(1, 2, 1, 1, 3).maxDays());
        }

        @Test
        void should_return_6_when_calculate_max_days() {
            assertEquals(6, new Tasks(1, 4, 2, 1, 4, 1, 4).maxDays());
        }

        @Test
        void should_return_0_when_have_nothing() {
            assertEquals(0, new Tasks().maxDays());
        }

        @Test
        void should_return_1_when_only_one_task_number() {
            assertEquals(1, new Tasks(1).maxDays());
        }
    }
}
