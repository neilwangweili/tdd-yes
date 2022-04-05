package yes.tdd.dojo.domain.dictionary;

public class InsufficientInputStringException extends RuntimeException {
    public InsufficientInputStringException(String message) {
        super(message);
    }
}
