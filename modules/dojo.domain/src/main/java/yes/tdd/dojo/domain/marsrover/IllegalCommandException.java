package yes.tdd.dojo.domain.marsrover;

public class IllegalCommandException extends RuntimeException {
    public IllegalCommandException(String command) {
        super(command);
    }
}
