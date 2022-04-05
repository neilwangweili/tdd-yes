package yes.tdd.dojo.domain.lifegame;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifeGameTest {
    @Nested
    class IntegrationTest {
        @Test
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

        @Test
        void should_be_able_to_show_frame_when_dead_resurrect() {
            String input = ".....\n" +
                ".***.\n" +
                ".*...\n" +
                ".....";
            CellGame cellGame = CellGame.build(5, 4).newGame(input);
            cellGame.nextFrame();
            assertEquals(cellGame.show(), ".....\n" +
                ".**..\n" +
                ".**..\n" +
                ".....");
        }

        @Test
        void should_be_able_to_show_frame_when_too_overcrowding_dead() {
            String input = ".....\n" +
                ".***.\n" +
                ".**..\n" +
                ".....";
            CellGame cellGame = CellGame.build(5, 4).newGame(input);
            cellGame.nextFrame();
            assertEquals(cellGame.show(), ".....\n" +
                ".*.*.\n" +
                ".*.*.\n" +
                ".....");
        }
    }
}
