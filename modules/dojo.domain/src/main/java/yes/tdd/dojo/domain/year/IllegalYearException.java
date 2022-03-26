package yes.tdd.dojo.domain.year;

public class IllegalYearException extends IllegalArgumentException {
    public IllegalYearException(String message) {
        super(message);
    }
}
