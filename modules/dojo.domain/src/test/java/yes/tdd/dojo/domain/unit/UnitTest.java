package yes.tdd.dojo.domain.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
    //100cm = 10dm = 1m
    @Test
    void should_be_able_to_transfer_1_m_to_100cm() {
        assertEquals(new Unit(1.0, "m").to("cm"), 100.0);
    }

    @Test
    void should_be_able_to_transfer_1_m_to_10dm() {
        assertEquals(new Unit(1.0, "m").to("dm"), 10.0);
    }
}