package yes.tdd.dojo.domain.args;

public class MutipleOptions {
    private final boolean logging;
    private final int port;
    private final String directory;

    public MutipleOptions(@Option("-l") boolean logging, @Option("-p") int port, @Option("-d") String directory) {
        this.logging = logging;
        this.port = port;
        this.directory = directory;
    }

    public boolean logging() {
        return logging;
    }

    public int port() {
        return port;
    }

    public String directory() {
        return directory;
    }
}
