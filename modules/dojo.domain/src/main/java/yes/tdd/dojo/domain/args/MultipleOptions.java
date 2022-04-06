package yes.tdd.dojo.domain.args;

public record MultipleOptions(@Option("-l") boolean logging, @Option("-p") int port, @Option("-d") String directory) {
}
