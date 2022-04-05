package yes.tdd.dojo.domain.lags;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @Test
    void should_be_able_to_init_one_order_correctly() {
        Order order = Order.of("AF514", 0, 5, 10);
        assertEquals(order.plane(), "AF514");
        assertEquals(order.startTime(), 0);
        assertEquals(order.duration(), 5);
        assertEquals(order.pay(), 10);
    }
}
