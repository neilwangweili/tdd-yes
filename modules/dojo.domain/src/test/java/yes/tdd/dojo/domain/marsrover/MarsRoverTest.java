package yes.tdd.dojo.domain.marsrover;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static yes.tdd.dojo.domain.marsrover.Mars.build;
import static yes.tdd.dojo.domain.marsrover.Towards.N;

public class MarsRoverTest {
    @Nested
    class IntegrationTest {
        @Test
        void should_be_able_to_accept_commands_and_run_in_Mars_correctly() {
            MarsRover marsRover = MarsRover.define(build(10.0, 10.0), N, 0.0, 0.0);
            marsRover.executeCommands("f", "r", "f", "r", "l", "r", "r", "l", "r", "l", "r", "r", "r", "r", "l", "l", "l", "l", "l", "f", "b", "l", "f", "f");
            assertEquals(marsRover.report(), "I'm at (1.0, 3.0), towards North.");
        }
    }

    @Nested
    class UnitTest {
        @Test
        void should_build_an_area_in_mars() {
            Mars mars = build(10.0, 10.0);
            assertEquals(mars.x(), 10.0);
            assertEquals(mars.y(), 10.0);
        }

        @Test
        void should_build_a_car_by_Mars_area() {
            MarsRover marsRover = MarsRover.define(build(10.0, 10.0), N, 0.0, 0.0);
            assertEquals(marsRover.report(), "I'm at (0.0, 0.0), towards North.");
        }

        @ParameterizedTest
        @CsvSource(quoteCharacter = '#', value = {
            // Forward and back command.
            "0.0,   0.0,    #N#,    #f#,    #I'm at (0.0, 1.0), towards North.#",
            "0.0,   1.0,    #N#,    #b#,    #I'm at (0.0, 0.0), towards North.#",
            "1.0,   1.0,    #E#,    #b#,    #I'm at (0.0, 1.0), towards East.#",
            "1.0,   1.0,    #E#,    #f#,    #I'm at (2.0, 1.0), towards East.#",
            "1.0,   1.0,    #S#,    #f#,    #I'm at (1.0, 0.0), towards South.#",
            "1.0,   1.0,    #S#,    #b#,    #I'm at (1.0, 2.0), towards South.#",
            "1.0,   1.0,    #W#,    #f#,    #I'm at (0.0, 1.0), towards West.#",
            "1.0,   1.0,    #W#,    #b#,    #I'm at (2.0, 1.0), towards West.#",
            // MarsRover out of area.
            "0.0,   0.0,    #N#,    #b#,    #I'm at (0.0, 0.0), towards North.#",
            "0.0,   0.0,    #E#,    #b#,    #I'm at (0.0, 0.0), towards East.#",
            "10.0,  10.0,   #E#,    #f#,    #I'm at (10.0, 10.0), towards East.#",
            "10.0,  10.0,   #N#,    #f#,    #I'm at (10.0, 10.0), towards North.#",
            // Turns command.
            "0.0,   0.0,    #N#,    #l#,    #I'm at (0.0, 0.0), towards West.#",
            "0.0,   0.0,    #W#,    #l#,    #I'm at (0.0, 0.0), towards South.#",
            "0.0,   0.0,    #S#,    #l#,    #I'm at (0.0, 0.0), towards East.#",
            "0.0,   0.0,    #E#,    #l#,    #I'm at (0.0, 0.0), towards North.#",
            "0.0,   0.0,    #N#,    #r#,    #I'm at (0.0, 0.0), towards East.#",
            "0.0,   0.0,    #E#,    #r#,    #I'm at (0.0, 0.0), towards South.#",
            "0.0,   0.0,    #S#,    #r#,    #I'm at (0.0, 0.0), towards West.#",
            "0.0,   0.0,    #W#,    #r#,    #I'm at (0.0, 0.0), towards North.#",
        })
        void should_be_able_to_accept_one_command_and_do_it(Double x, Double y, Towards towards, String command, String actual) {
            MarsRover marsRover = MarsRover.define(build(10.0, 10.0), towards, x, y);
            marsRover.executeCommands(command);
            assertEquals(marsRover.report(), actual);
        }

        @Test
        void should_be_able_to_throw_exception_when_command_is_error() {
            Throwable x = catchThrowable(() -> MarsRover.define(build(10.0, 10.0), N, 0.0, 0.0).executeCommands("x"));
            assertThat(x).isInstanceOf(InsufficientCommandException.class).hasMessage("x");
        }
    }
}
