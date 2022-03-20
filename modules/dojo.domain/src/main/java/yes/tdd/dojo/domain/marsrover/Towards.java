package yes.tdd.dojo.domain.marsrover;

import java.util.Arrays;

import static java.lang.Math.PI;

public enum Towards {
    N("North", PI / 2.0),
    S("South", 3 * (PI / 2)),
    E("East", 0),
    W("West", PI);

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
