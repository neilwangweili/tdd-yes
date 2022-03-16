package yes.tdd.dojo.domain.args;

public class IntOptions {
    private final int port;

    public IntOptions(@Option("-p") int port) {
        this.port = port;
    }

    public int port() {
        return port;
    }
}
