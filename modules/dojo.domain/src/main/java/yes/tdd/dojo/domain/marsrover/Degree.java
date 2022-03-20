package yes.tdd.dojo.domain.marsrover;

import org.apache.commons.lang3.tuple.Pair;

public class Degree {
    private final Double degree;

    public Degree(Towards towards) {
        this.degree = towards.degree();
    }

    public Pair<Double, Double> orthogonalDecomposition() {
        return Pair.of((double) Math.round(Math.cos(degree)), (double) Math.round(Math.sin(degree)));
    }

    public String report() {
        return "towards " + Towards.convert(degree).report();
    }
}
