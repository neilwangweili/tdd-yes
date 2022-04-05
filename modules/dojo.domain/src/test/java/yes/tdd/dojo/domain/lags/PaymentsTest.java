package yes.tdd.dojo.domain.lags;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentsTest {
    @Nested
    class IntegrationTest {
        @Test
        void should_be_able_to_calculate_the_best_advice_giving_by_orders() {
            Payments payments = Payments.create(
                Order.of("AF514", 0, 5, 10),
                Order.of("C05", 3, 7, 14),
                Order.of("AF515", 5, 9, 7),
                Order.of("BA01", 6, 9, 8)
            );
            assertEquals(payments.findBest(), "The best choices is: AF514 -> BA01. The gain is 18.");
        }
    }

    @Nested
    class UnitTest {
        @Test
        void should_be_able_to_tell_us_if_giving_empty_orders() {
            assertEquals(Payments.create().findBest(), "No order.");
        }
    }

    @Test
    void should_be_able_to_calculate_the_best_advice_giving_by_one_order() {
        assertEquals(Payments.create(Order.of("AF514", 0, 5, 5)).findBest(), "The best choices is: AF514. The gain is 5.");
    }

    @Test
    void should_be_able_to_sort_by_startTime() {
        Payments payments = Payments.create(
            Order.of("C05", 3, 7, 14),
            Order.of("AF514", 0, 5, 10)
        );
        assertEquals(payments.findBest(), "The best choices is: C05. The gain is 14.");
    }
}
