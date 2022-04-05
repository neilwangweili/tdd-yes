package yes.tdd.dojo.domain.lifegame;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifeGameTest {
    @Nested
    class IntegrationTest {
        @Test
        @Disabled
        void should_be_able_to_calculate_next_frame() {
            CellGame cellGame = CellGame.build(8, 4).newGame("........\n" +
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

    @Nested
    class UnitTest {
        @Test
        void should_be_able_to_show_correct_frame_by_giving_string() {
            String input = "........\n" +
                "....*...\n" +
                "...**...\n" +
                "........";
            CellGame cellGame = CellGame.build(8, 4).newGame(input);
            assertEquals(cellGame.show(), input);
        }
    }
}
