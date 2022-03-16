package yes.tdd.dojo.domain.args;

public class TooManyArgumentsException extends RuntimeException {
    public TooManyArgumentsException(String value) {
        super(value);
    }

    public String getOption() {
        return super.getMessage();
    }
}
