package yes.tdd.dojo.domain.year;

public class InsufficientYearException extends IllegalArgumentException {
    public InsufficientYearException(String message) {
        super(message);
    }
}
