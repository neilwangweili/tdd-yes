package yes.tdd.dojo.domain.args;

public class ListOptions {
    private final String[] group;
    private final Integer[] decimals;

    public ListOptions(@Option("-g") String[] group, @Option("-d") Integer[] decimals) {
        this.group = group;
        this.decimals = decimals;
    }

    public String[] group() {
        return group;
    }

    public Integer[] decimals() {
        return decimals;
    }
}
