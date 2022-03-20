package yes.tdd.dojo.domain.marsrover;

public class InsufficientCommandException extends RuntimeException {
    public InsufficientCommandException(String command) {
        super(command);
    }
}
