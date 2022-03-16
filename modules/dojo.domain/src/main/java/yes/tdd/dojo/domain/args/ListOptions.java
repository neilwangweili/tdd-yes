package yes.tdd.dojo.domain.args;

public class ListOptions {
    private final String[] group;
    private final int[] decimals;

    public ListOptions(String[] group, int[] decimals) {
        this.group = group;
        this.decimals = decimals;
    }

    public String[] group() {
        return group;
    }

    public int[] decimals() {
        return decimals;
    }
}
