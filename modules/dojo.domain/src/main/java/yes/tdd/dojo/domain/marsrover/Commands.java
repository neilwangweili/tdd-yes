package yes.tdd.dojo.domain.marsrover;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class Commands {
    private Commands() {
    }

    public static Stream<Consumer<MarsRover>> buildFrom(String... commands) {
        return Arrays.stream(commands).map(Commands::extracted);
    }

    private static Consumer<MarsRover> extracted(String command) {
        if (command.equals("f")) return MarsRover::towards;
        if (command.equals("b")) return MarsRover::back;
        if (command.equals("l")) return MarsRover::turnLeft;
        if (command.equals("r")) return MarsRover::turnRight;
        return o -> o.errorCommand(command);
    }
}
