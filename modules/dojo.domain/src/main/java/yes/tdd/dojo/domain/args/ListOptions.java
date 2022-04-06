package yes.tdd.dojo.domain.args;

public record ListOptions(@Option("-g") String[] group, @Option("-d") Integer[] decimals) {
}
