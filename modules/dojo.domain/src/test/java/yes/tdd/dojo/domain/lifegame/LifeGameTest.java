package yes.tdd.dojo.domain.lifegame;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifeGameTest {
    @Nested
    class IntegrationTest {
        @Test
        @Disabled
        void should_be_able_to_calculate_next_frame() {
            CellGame cellGame = CellGame.build(4, 8).newGame("........\n" +
                "....*...\n" +
                "...**...\n" +
                "........"
            );
            cellGame.nextFrame();
            assertEquals(cellGame.show(), "........\n" +
                "...**...\n" +
                "...**...\n" +
                "........");
        }
    }
}
