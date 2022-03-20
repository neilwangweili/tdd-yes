package yes.tdd.dojo.domain.marsrover;

public class Location {
    private final Mars area;
    private Double x;
    private Double y;

    public Location(Double x, Double y, Mars mars) {
        this.area = mars;
        this.x = x;
        this.y = y;
    }

    public String report() {
        return "I'm at (" + x + ", " + y + ")";
    }

    public void towards(Degree degree) {
        x += degree.orthogonalDecomposition().getLeft();
        y += degree.orthogonalDecomposition().getRight();
    }
}
