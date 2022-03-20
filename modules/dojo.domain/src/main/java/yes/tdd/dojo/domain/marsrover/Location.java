package yes.tdd.dojo.domain.marsrover;

public class Location {
    private final Double x;
    private final Double y;

    public Location(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public String report() {
        return "I'm at (" + x + ", " + y + ")";
    }
}
