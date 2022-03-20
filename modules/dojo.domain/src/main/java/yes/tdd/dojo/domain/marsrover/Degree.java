package yes.tdd.dojo.domain.marsrover;

import org.apache.commons.lang3.tuple.Pair;

import static java.lang.Math.PI;

public class Degree {
    private Double degree;

    public Degree(Towards towards) {
        this.degree = towards.degree();
    }

    public Pair<Double, Double> orthogonalDecompose() {
        return Pair.of((double) Math.round(Math.cos(degree)), (double) Math.round(Math.sin(degree)));
    }

    public String report() {
        return "towards " + Towards.convert(degree).report();
    }

    public void turnLeft() {
        final double ninetyDegree = PI / 2;
        turn(ninetyDegree);
    }

    public void turnRight() {
        final double twentyHundredAndSeventyDegree = PI * 1.5;
        turn(twentyHundredAndSeventyDegree);
    }

    private void turn(double degree) {
        this.degree += degree;
        this.degree = (this.degree + (2 * PI)) % (2 * PI);
    }
}
