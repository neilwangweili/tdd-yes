package yes.tdd.dojo.domain.unit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static yes.tdd.dojo.domain.unit.Unit.UnitHub.*;

public class UnitTest {

    @Nested
    class IntegrationTest {
        @Test
        void should_be_able_to_transfer_13_5_dm_to_135_cm() {
            assertEquals(new Unit(13.5, DM).to(CM), 135.0);
        }
    }

    @Nested
    class UnitInUnitTest {
        @Test
        void should_be_able_to_transfer_1_m_to_100_cm() {
            assertEquals(new Unit(1.0, M).to(CM), 100.0);
        }

        @Test
        void should_be_able_to_transfer_1_m_to_10_dm() {
            assertEquals(new Unit(1.0, M).to(DM), 10.0);
        }

        @Test
        void should_be_able_to_transfer_1_m_to_1_m() {
            assertEquals(new Unit(1.0, M).to(M), 1.0);
        }

        @Test
        void should_be_able_to_transfer_100cm_to_1_m() {
            assertEquals(new Unit(100.0, CM).to(M), 1.0);
        }

        @Test
        void should_be_able_to_transfer_10dm_to_1_m() {
            assertEquals(new Unit(10.0, DM).to(M), 1.0);
        }
    }
}
