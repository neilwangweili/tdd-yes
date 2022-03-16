package yes.tdd.dojo.domain.args;

public class InsufficientArgumentsException extends RuntimeException {
    public InsufficientArgumentsException(Option option) {
        super(option.value());
    }

    public String getOption() {
        return super.getMessage();
    }
}
