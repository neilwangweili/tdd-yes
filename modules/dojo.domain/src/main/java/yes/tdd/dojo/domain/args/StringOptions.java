package yes.tdd.dojo.domain.args;

public class StringOptions {
    private final String directory;

    public StringOptions(@Option("-d") String directory) {
        this.directory = directory;
    }

    public String directory() {
        return directory;
    }
}
