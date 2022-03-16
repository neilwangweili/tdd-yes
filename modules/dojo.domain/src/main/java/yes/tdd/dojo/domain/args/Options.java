package yes.tdd.dojo.domain.args;

public class Options {
    private final boolean logging;
    private final int port;
    private final String directory;

    public Options(boolean logging, int port, String directory) {
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
