package yes.tdd.dojo.domain.marsrover;

import java.util.Arrays;

public enum Towards {
    N("North", 0), S("South", Math.PI), E("East", Math.PI / 2), W("West", 3 * (Math.PI / 2));

    private final String name;
    private final double degree;

    Towards(String name, double degree) {
        this.name = name;
        this.degree = degree;
    }

    @SuppressWarnings("all")
    public static Towards convert(Double degree) {
        return Arrays.stream(values()).filter(o -> o.degree == degree).findFirst().get();
    }

    public double degree() {
        return degree;
    }

    public String report() {
        return name;
    }
}
