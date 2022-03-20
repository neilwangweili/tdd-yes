package yes.tdd.dojo.domain.marsrover;

public class Degree {
    private final Double degree;

    public Degree(Towards towards) {
        this.degree = towards.degree();
    }

    public String report() {
        return "towards " + Towards.convert(degree).report();
    }
}
