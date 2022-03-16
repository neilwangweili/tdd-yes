package yes.tdd.dojo.domain.args;

public class BooleanOptions {
    private final boolean logging;

    public BooleanOptions(@Option("-l") boolean logging) {
        this.logging = logging;
    }

    public boolean logging() {
        return logging;
    }
}
